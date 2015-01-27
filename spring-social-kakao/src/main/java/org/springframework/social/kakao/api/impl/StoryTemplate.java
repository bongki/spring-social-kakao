package org.springframework.social.kakao.api.impl;

import org.springframework.social.kakao.api.KakaoStoryProfile;
import org.springframework.social.kakao.api.StoryLinkData;
import org.springframework.social.kakao.api.StoryOperation;
import org.springframework.web.client.RestTemplate;

public class StoryTemplate extends AbstractKakaoOperations implements StoryOperation {
	private final RestTemplate restTemplate;
	
	public StoryTemplate(RestTemplate restTemplate, boolean isAuthorized) {
		super(isAuthorized);
		this.restTemplate = restTemplate;
	}

	public KakaoStoryProfile isStoryUser() {
		requireAuthorization();
		return restTemplate.getForObject(buildApiUri("/v1/api/story/isstoryuser"), KakaoStoryProfile.class);
	}

	public KakaoStoryProfile getUserProfile() {
		requireAuthorization();
		return restTemplate.getForObject(buildApiUri("/v1/api/story/profile"), KakaoStoryProfile.class);
	}

	public void postLink(StoryLinkData storyLinkData) {
		requireAuthorization();
		//구현해야하며 2스탭으로 진행되어야함 (링크 대상페이지 정보 가져오기 -> 카카오 스토리에 링크 생성하기)
	}
}
