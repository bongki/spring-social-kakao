package org.springframework.social.kakao.api;

public interface UserOperation {
	long getProfileId();
	
	String getNickname();
	
	KakaoProfile getUserProfile();
}