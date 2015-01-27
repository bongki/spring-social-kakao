package org.springframework.social.kakao.api.impl;

import org.springframework.social.kakao.api.KakaoProfile;
import org.springframework.social.kakao.api.UserOperation;
import org.springframework.web.client.RestTemplate;

public class UserTemplate extends AbstractKakaoOperations implements UserOperation {
	private final RestTemplate restTemplate;
	
	public UserTemplate(RestTemplate restTemplate, boolean isAuthorized) {
		super(isAuthorized);
		this.restTemplate = restTemplate;
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
	
	
}
