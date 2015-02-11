package org.springframework.social.kakao.api;

import org.springframework.social.ApiBinding;

public interface Kakao extends ApiBinding {
	/**
	 * <pre>
	 * 사용자 관리 API 호출
	 * </pre>
	 * @return
	 */
	UserOperation userOperation();
	
	/**
	 * <pre>
	 * 카카오 스토리 API 호출
	 * </pre>
	 * @return
	 */
	StoryOperation storyOperation();
	
	/**
	 * <pre>
	 * 카카오 톡 API 호출
	 * </pre>
	 * @return
	 */
	TalkOperation talkOperation();
	
	/**
	 * <pre>
	 * 푸시 알림 API 호출
	 * </pre>
	 * @return
	 * @deprecated
	 * <pre>
	 * 해당 operation 내의 모든 메서드는 admin key를 사용중에 있음.
	 * user operation 내의 일부 메서드와 같이 admin key 이슈 해결필요
	 * </pre>
	 */
	@Deprecated
	PushOperation pushOperation();
}
