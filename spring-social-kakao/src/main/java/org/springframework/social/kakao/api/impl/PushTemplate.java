package org.springframework.social.kakao.api.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.social.kakao.api.ForApns;
import org.springframework.social.kakao.api.ForGcm;
import org.springframework.social.kakao.api.PushOperation;
import org.springframework.social.kakao.api.PushToken;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

public class PushTemplate extends AbstractKakaoOperations implements PushOperation {
	private final RestTemplate restTemplate;
	private final String adminKey;
	
	public PushTemplate(RestTemplate restTemplate, boolean isAuthorized, String adminKey) {
		super(isAuthorized);
		this.restTemplate = restTemplate;
		this.adminKey = adminKey;
	}
	
	public String register(String uuid, String deviceId, String pushType, String pushToken) {
		HttpHeaders headers = getAdminKeyHeader(adminKey);
		
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		parameters.set("uuid", uuid);
		parameters.set("device_id", deviceId);
		parameters.set("push_type", pushType);
		parameters.set("push_token", pushToken);
		
		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String,String>>(parameters, headers);
		
		return restTemplate.postForObject(buildApiUri("/v1/push/register"), entity, String.class);
	}
	
	public List<PushToken> tokens(String uuid) {
		HttpHeaders headers = getAdminKeyHeader(adminKey);
		
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		parameters.set("uuid", uuid);
		
		ResponseEntity<PushToken[]> response = restTemplate.exchange(buildApiUri("/v1/push/tokens", parameters)
																		, HttpMethod.GET, new HttpEntity<Object>(headers), PushToken[].class);
		
		return Arrays.asList(response.getBody());
	}
	
	public void deregister(String uuid, String deviceId, String pushType) {
		HttpHeaders headers = getAdminKeyHeader(adminKey);
		
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		parameters.set("uuid", uuid);
		parameters.set("device_id", deviceId);
		parameters.set("push_type", pushType);
		
		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String,String>>(parameters, headers);
		
		restTemplate.postForLocation(buildApiUri("/v1/push/deregister"), entity);
	}
	
	public void send(List<String> uuids, ForApns forApns, ForGcm forGcm) {
		HttpHeaders headers = getAdminKeyHeader(adminKey);
		
		MultiValueMap<String, Object> parameters = new LinkedMultiValueMap<String, Object>();
		parameters.set("uuids", uuids);
		if (forApns != null) {
			if (forApns.isEmpty()) {
				parameters.set("for_apns", new HashMap<String, String>());
			} else {
				parameters.set("for_apns", forApns);
			}
		}
		if (forGcm != null) {
			if (forGcm.isEmpty()) {
				parameters.set("for_gcm", new HashMap<String, String>());
			} else {
				parameters.set("for_gcm", forGcm);
			}
		}
		
		HttpEntity<MultiValueMap<String, Object>> entity = new HttpEntity<MultiValueMap<String,Object>>(parameters, headers);
		
		restTemplate.postForLocation(buildApiUri("/v1/push/send"), entity);
	}
}
