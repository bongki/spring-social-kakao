package org.springframework.social.kakao.api.impl;

import org.springframework.social.kakao.api.KakaoTalkProfile;
import org.springframework.social.kakao.api.ResultCode;
import org.springframework.social.kakao.api.TalkOperation;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class TalkTemplate extends AbstractKakaoOperations implements TalkOperation {
	private final RestTemplate restTemplate;

	public TalkTemplate(RestTemplate restTemplate, boolean isAuthorized) {
		super(isAuthorized);
		this.restTemplate = restTemplate;
	}

	public KakaoTalkProfile getUserProfile() {
		requireAuthorization();
		return restTemplate.getForObject(buildApiUri("/v1/api/talk/profile"), KakaoTalkProfile.class);
	}

	public ResultCode sendToMe(String message) {
		requireAuthorization();
		MultiValueMap<String, String> param = new LinkedMultiValueMap<String, String>();
		param.set("template_object", message);
		return restTemplate.postForObject(buildApiUri("/v2/api/talk/memo/default/send"), param, ResultCode.class);
	}
}