package org.springframework.social.kakao.api;

import org.springframework.social.ApiBinding;

public interface Kakao extends ApiBinding {
	UserOperation userOperation();
	
	StoryOperation storyOperation();
	
	TalkOperation talkOperation();
}
