package org.springframework.social.kakao.api;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public class StoryLinkData {
	private String url;
	private String message;
	
	public StoryLinkData(String url, String message) {
		this.url = url;
		this.message = message;
	}
	
	public MultiValueMap<String, Object> toLinkInfoRequestParameter() {
		MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
		
		params.set("url", url);
		
		return params;
	}
	
	public MultiValueMap<String, Object> toRequestParameter() {
		MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
		
		params.set("url", this.url);
		if (this.message != null) {
			params.set("message", this.message);
		}
		
		return params;
	}
}
