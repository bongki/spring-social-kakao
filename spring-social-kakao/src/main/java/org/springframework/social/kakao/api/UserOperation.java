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
	
	/**
	 * <pre>
	 * 해당 access token을 발급받은 사용자의 프로필 정보를 수정합니다.
	 *  - 관리자 페이지에서 확인가능한 default field이외에 개발자가 추가한 custom field의 데이터에 대한 데이터를 셋팅하는데 사용합니다.
	 *  - 반환 데이터에는 업데이트된 사용자의 id 만 존재합니다. 
	 * </pre>
	 * @param profileJsonString
	 * @return
	 */
	KakaoProfile updateProfile(String profileJsonString);
}