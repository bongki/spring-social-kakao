package org.springframework.social.kakao.api;

public interface StoryOperation {
	KakaoStoryProfile isStoryUser();
	
	KakaoStoryProfile getUserProfile();
	
	void postLink(StoryLinkData storyLinkData);
}
