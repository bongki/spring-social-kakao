package org.springframework.social.kakao.api.impl;

import java.net.URI;

import org.springframework.social.MissingAuthorizationException;
import org.springframework.social.support.URIBuilder;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public class AbstractKakaoOperations {
	private final boolean isAuthorized;
	
	private final static String API_HOST = "https://kapi.kakao.com";
	
	private final static MultiValueMap<String, String> EMPTY_PARAMETER = new LinkedMultiValueMap<String, String>();
	
	public AbstractKakaoOperations(boolean isAuthorized) {
		this.isAuthorized = isAuthorized;
	}
	
	protected void requireAuthorization() {
		if (!isAuthorized) {
			throw new MissingAuthorizationException("kakao");
		}
	}
	
	protected URI buildApiUri(String path) {
		return buildApiUri(path, EMPTY_PARAMETER);
	}
	protected URI buildApiUri(String path, MultiValueMap<String, String> parameters) {
		return URIBuilder.fromUri(API_HOST + path).queryParams(parameters).build();
	}
}
