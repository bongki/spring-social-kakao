package org.springframework.social.kakao.api;

public interface UserOperation {
	/**
	 * <pre>
	 * 해당 access token을 발급받은 사용자의 고유 id값을 가져옵니다.
	 * </pre>
	 * @return
	 */
	long getProfileId();
	
	/**
	 * <pre>
	 * 해당 access token을 발급받은 사용자의 닉네임 정보를 가져옵니다.
	 * </pre>
	 * @return
	 */
	String getNickname();
	
	/**
	 * <pre>
	 * 해당 access token을 발급받은 사용자의 프로필 정보를 조회합니다.
	 * </pre>
	 * @return
	 */
	KakaoProfile getUserProfile();
	
	/**
	 * <pre>
	 * 해당 access token을 발급받은 사용자의 앱 연결을 해제 합니다.
	 * - 앱과의 연동이완전히 끊기며 해당 사용자 정보는 제거 되어 복구 불가능합니다.
	 * </pre> 
	 * @return
	 */
	KakaoProfile unlink();
	
	/**
	 * <pre>
	 * 해당 access token의 상태를 확인한다.
	 *  - 비정상적 토큰의 경우 401 error 발생 (org.springframework.web.client.HttpClientErrorException)
	 * </pre>
	 * @return
	 */
	AccessTokenInfo accessTokenInfo();
}