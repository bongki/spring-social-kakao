package org.springframework.social.kakao.api;

public class KakaoProfileProperties {
	private String nickname;
	private String thumbnail_image;
	private String profile_image;
	
	public String getNickname() {
		return this.nickname;
	}
	
	public String getThumbnail_image() {
		return thumbnail_image;
	}

	public String getProfile_image() {
		return profile_image;
	}

	KakaoProfileProperties(){}
}
