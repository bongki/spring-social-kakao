package org.springframework.social.kakao.api.impl;

import org.springframework.social.kakao.api.AbstractStoryPosting;
import org.springframework.social.kakao.api.KakaoStoryProfile;
import org.springframework.social.kakao.api.StoryLinkInfo;
import org.springframework.social.kakao.api.StoryLinkPosting;
import org.springframework.social.kakao.api.StoryNotePosting;
import org.springframework.social.kakao.api.StoryOperation;
import org.springframework.social.kakao.api.StoryPhotoPosting;
import org.springframework.social.kakao.api.StoryPhotoUpload;
import org.springframework.social.kakao.api.StoryPhotoUploadResult;
import org.springframework.social.kakao.api.StoryPostingResult;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
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
	
	public StoryPostingResult postNote(StoryNotePosting storyNotePosting) {
		requireAuthorization();
		//파라메터 생성하기
		MultiValueMap<String, Object> param = commonParamSetting(storyNotePosting);
		param.set("content", storyNotePosting.getContent());
		
		//API 요청
		return restTemplate.postForObject(buildApiUri("/v1/api/story/post/note"), param, StoryPostingResult.class);
	}
	
	public StoryPhotoUploadResult uploadPhoto(StoryPhotoUpload storyPhotoUpload) {
		requireAuthorization();
		return null;
	}
	
	public StoryPostingResult postPhoto(StoryPhotoPosting storyPhotoPosting) {
		requireAuthorization();
		return null;
	}
	
	public StoryLinkInfo linkInfo(String url) {
		requireAuthorization();
		MultiValueMap<String, String> param = new LinkedMultiValueMap<String, String>();
		param.set("url", url);
		
		return restTemplate.getForObject(buildApiUri("/v1/api/story/linkinfo", param), StoryLinkInfo.class);
	}

	public StoryPostingResult postLink(StoryLinkPosting storyLinkPosting) {
		requireAuthorization();
		//url 정보 체크. url 값이 있다면 linkInfo 메서드 호출
		if (!StringUtils.isEmpty(storyLinkPosting.getUrl())) {
			storyLinkPosting.setStoryLinkInfo(linkInfo(storyLinkPosting.getUrl()));
		}
		
		//파라메터 셋팅
		MultiValueMap<String, Object> param = commonParamSetting(storyLinkPosting);
		param.set("link_info", storyLinkPosting.getStoryLinkInfo().toJsonString(false));
		param.set("content", storyLinkPosting.getContent());
		
		return restTemplate.postForObject(buildApiUri("/v1/api/story/post/link"), param, StoryPostingResult.class);
	}
	
	private MultiValueMap<String, Object> commonParamSetting(AbstractStoryPosting abstractStoryPosting) {
		MultiValueMap<String, Object> param = new LinkedMultiValueMap<String, Object>();
		
		param.set("permission", abstractStoryPosting.getPermission());
		param.set("enable_share", abstractStoryPosting.isEnableShare());
		if (!StringUtils.isEmpty(abstractStoryPosting.getAndroidExecParam())) {
			param.set("android_exec_param", abstractStoryPosting.getAndroidExecParam());
		}
		if (!StringUtils.isEmpty(abstractStoryPosting.getIosExecParam())) {
			param.set("ios_exec_param", abstractStoryPosting.getIosExecParam());
		}
		if (!StringUtils.isEmpty(abstractStoryPosting.getAndroidMarketParam())) {
			param.set("android_market_param", abstractStoryPosting.getAndroidMarketParam());
		}
		if (!StringUtils.isEmpty(abstractStoryPosting.getIosMarketParam())) {
			param.set("ios_market_param", abstractStoryPosting.getIosMarketParam());
		}
		
		return param;
	}
}
