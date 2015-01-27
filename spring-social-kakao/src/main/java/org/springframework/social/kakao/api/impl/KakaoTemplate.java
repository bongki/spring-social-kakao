package org.springframework.social.kakao.api.impl;

import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.social.kakao.api.Kakao;
import org.springframework.social.kakao.api.StoryOperation;
import org.springframework.social.kakao.api.TalkOperation;
import org.springframework.social.kakao.api.UserOperation;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.support.ClientHttpRequestFactorySelector;

public class KakaoTemplate extends AbstractOAuth2ApiBinding implements Kakao {
	private UserOperation userOperation;
	private StoryOperation storyOperation;
	private TalkOperation talkOperation;
	
	public KakaoTemplate() {
		initialize();
	}
	
	public KakaoTemplate(String accessToken) {
		super(accessToken);
		initialize();
	}
	
	@Override
	public void setRequestFactory(ClientHttpRequestFactory requestFactory) {
		super.setRequestFactory(ClientHttpRequestFactorySelector.bufferRequests(requestFactory));
	}

	public UserOperation userOperation() {
		return userOperation;
	}

	public StoryOperation storyOperation() {
		return storyOperation;
	}

	public TalkOperation talkOperation() {
		return talkOperation;
	}
	
	private void initialize() {
		super.setRequestFactory(ClientHttpRequestFactorySelector.bufferRequests(getRestTemplate().getRequestFactory()));
		initSubApis();
	}
	
	private void initSubApis() {
		userOperation = new UserTemplate(getRestTemplate(), isAuthorized());
		storyOperation = new StoryTemplate(getRestTemplate(), isAuthorized());
		talkOperation = new TalkTemplate(getRestTemplate(), isAuthorized());
	}
}
