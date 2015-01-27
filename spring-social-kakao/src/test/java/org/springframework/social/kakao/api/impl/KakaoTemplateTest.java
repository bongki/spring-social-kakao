package org.springframework.social.kakao.api.impl;

import org.junit.Test;
import org.springframework.social.kakao.api.Kakao;
import org.springframework.social.kakao.api.KakaoProfile;
import org.springframework.social.kakao.api.KakaoStoryProfile;
import org.springframework.social.kakao.api.KakaoTalkProfile;

public class KakaoTemplateTest {
	@Test
	public void getProfile() {
		String accessToken = ""; //insert access token
		
		Kakao kakao = new KakaoTemplate(accessToken);
		
		//kakao
		System.out.println("********************************************************");
		System.out.println("** Kakao operation");
		System.out.println("********************************************************");
		long id = kakao.userOperation().getProfileId();
		System.out.println(String.format("** userOperation -> getProfileId : %s", id));
		
		String nickname = kakao.userOperation().getNickname();
		System.out.println(String.format("** userOperation -> getNickname : %s", nickname));
		
		KakaoProfile profile = kakao.userOperation().getUserProfile();
		System.out.println(String.format("** userOperation -> getUserProfile -> id : %s", profile.getId()));
		System.out.println(String.format("** userOperation -> getUserProfile -> properties -> nickanme : %s", profile.getProperties().getNickname()));
		System.out.println(String.format("** userOperation -> getUserProfile -> properties -> thumbnail_image : %s", profile.getProperties().getThumbnail_image()));
		System.out.println(String.format("** userOperation -> getUserProfile -> properteis -> profile_image : %s", profile.getProperties().getProfile_image()));
		System.out.println("********************************************************");
	
		//kakao story
		System.out.println("********************************************************");
		System.out.println("** Story operation");
		System.out.println("********************************************************");
		KakaoStoryProfile storyProfile = kakao.storyOperation().isStoryUser();
		System.out.println(String.format("** storyOperation -> isStoryUser : %b", storyProfile.getIsStoryUser()));
		
		storyProfile = kakao.storyOperation().getUserProfile();
		System.out.println(String.format("** storyOperation -> getUserProfile -> nickName : %s", storyProfile.getNickName()));
		System.out.println(String.format("** storyOperation -> getUserProfile -> profileImageURL : %s", storyProfile.getProfileImageURL()));
		System.out.println(String.format("** storyOperation -> getUserProfile -> thumbnailURL : %s", storyProfile.getThumbnailURL()));
		System.out.println(String.format("** storyOperation -> getUserProfile -> bgImageURL : %s", storyProfile.getBgImageURL()));
		System.out.println(String.format("** storyOperation -> getUserProfile -> permalink : %s", storyProfile.getPermalink()));
		System.out.println(String.format("** storyOperation -> getUserProfile -> birthday : %s", storyProfile.getBirthday()));
		System.out.println(String.format("** storyOperation -> getUserProfile -> birthdayType : %s", storyProfile.getBirthdayType()));
		System.out.println("********************************************************");
		
		//kakao talk
		System.out.println("********************************************************");
		System.out.println("** Talk operation");
		System.out.println("********************************************************");
		KakaoTalkProfile talkProfile = kakao.talkOperation().getUserProfile();
		System.out.println(String.format("** talkOperation -> getUserProfile -> nickName : %s", talkProfile.getNickName()));
		System.out.println(String.format("** talkOperation -> getUserProfile -> profileImageURL : %s", talkProfile.getProfileImageURL()));
		System.out.println(String.format("** talkOperation -> getUserProfile -> thumbnailURL : %s", talkProfile.getThumbnailURL()));
		System.out.println(String.format("** talkOperation -> getUserProfile -> countryISO : %s", talkProfile.getCountryISO()));
		System.out.println("********************************************************");
	}
}
