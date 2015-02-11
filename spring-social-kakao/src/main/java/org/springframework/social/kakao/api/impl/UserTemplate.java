package org.springframework.social.kakao.api.impl;

import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.social.kakao.api.AccessTokenInfo;
import org.springframework.social.kakao.api.KakaoIds;
import org.springframework.social.kakao.api.KakaoProfile;
import org.springframework.social.kakao.api.UserOperation;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

public class UserTemplate extends AbstractKakaoOperations implements UserOperation {
	private final RestTemplate restTemplate;
	
	private final String adminKey;
	
	public UserTemplate(RestTemplate restTemplate, boolean isAuthorized, String adminKey) {
		super(isAuthorized);
		this.restTemplate = restTemplate;
		this.adminKey = adminKey;
	}

	public long getProfileId() {
		requireAuthorization();
		return getUserProfile().getId();
	}

	public String getNickname() {
		requireAuthorization();
		return getUserProfile().getProperties().getNickname();
	}

	public KakaoProfile getUserProfile() {
		requireAuthorization();
		return restTemplate.getForObject(buildApiUri("/v1/user/me"), KakaoProfile.class);
	}
	
	public KakaoProfile unlink() {
		requireAuthorization();
		
		return restTemplate.postForObject(buildApiUri("/v1/user/unlink"), null, KakaoProfile.class);
	}
	
	public AccessTokenInfo accessTokenInfo() {
		requireAuthorization();
		
		return restTemplate.getForObject(buildApiUri("/v1/user/access_token_info"), AccessTokenInfo.class);
	}
	
	public KakaoProfile updateProfile(String profileJsonString) {
		requireAuthorization();
		
		MultiValueMap<String, Object> param = new LinkedMultiValueMap<String, Object>();
		param.set("properties", profileJsonString);
		
		return restTemplate.postForObject(buildApiUri("/v1/user/update_profile"), param, KakaoProfile.class);
	}
	
	public KakaoProfile logout() {
		requireAuthorization();
		
		return restTemplate.postForObject(buildApiUri("/v1/user/logout"), null, KakaoProfile.class);
	}
	
	public KakaoProfile signup(String profileJsonString) {
		MultiValueMap<String, String> param = new LinkedMultiValueMap<String, String>();
		if (!StringUtils.isEmpty(profileJsonString)) {
			param.set("properties", profileJsonString);
		}
		
		return restTemplate.postForObject(buildApiUri("/v1/user/signup"), param, KakaoProfile.class);
	}
	
	public KakaoIds ids() {
		return ids("", "", ""); //default search call
	}
	
	public KakaoIds ids(String limit, String fromId, String order) {
		HttpHeaders headers = getAdminKeyHeader(adminKey);
		
		MultiValueMap<String, String> param = new LinkedMultiValueMap<String, String>();
		param.set("limit", limit);
		param.set("fromId", fromId);
		param.set("order", order);
		
		restTemplate.setInterceptors(Arrays.asList(new ClientHttpRequestInterceptor[]{new AdminKeyHeaderOAuth2RequestInterceptor()}));
		
		ResponseEntity<KakaoIds> response = restTemplate.exchange(buildApiUri("/v1/user/ids", param)
																	, HttpMethod.GET, new HttpEntity<Object>(headers), KakaoIds.class);
		
		return response.getBody();
	}
	
	public KakaoProfile getUserProfile(String userId) {
		HttpHeaders headers = getAdminKeyHeader(adminKey);
		
		MultiValueMap<String, String> param = new LinkedMultiValueMap<String, String>();
		param.set("user_id", userId);
		
		restTemplate.setInterceptors(Arrays.asList(new ClientHttpRequestInterceptor[]{new AdminKeyHeaderOAuth2RequestInterceptor()}));
		
		ResponseEntity<KakaoProfile> response = restTemplate.exchange(buildApiUri("/v1/user/me")
																		, HttpMethod.GET, new HttpEntity<Object>(headers), KakaoProfile.class);
		
		return response.getBody();
	}
}
