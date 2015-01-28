package org.springframework.social.kakao.api.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.social.kakao.api.Kakao;
import org.springframework.social.kakao.api.KakaoProfile;
import org.springframework.social.kakao.api.KakaoStoryProfile;
import org.springframework.social.kakao.api.KakaoTalkProfile;
import org.springframework.social.kakao.api.StoryLinkInfo;
import org.springframework.social.kakao.api.StoryLinkPosting;
import org.springframework.social.kakao.api.StoryNotePosting;
import org.springframework.social.kakao.api.StoryPhotoPosting;
import org.springframework.social.kakao.api.StoryPhotoUpload;
import org.springframework.social.kakao.api.StoryPostingResult;

import com.fasterxml.jackson.databind.ObjectMapper;

public class KakaoTemplateTest {
	static final String ACCESS_TOKEN = ""; //insert access token
	static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	
	Kakao kakao;
	
	StoryPhotoUpload storyPhotoUpload = new StoryPhotoUpload();
	
	@Before
	public void before() {
		kakao = new KakaoTemplate(ACCESS_TOKEN);
	
		List<String> photoFileList = new ArrayList<String>();
		photoFileList.add("D:\\sample_photo\\1.jpg");
		photoFileList.add("D:\\sample_photo\\2.jpg");
		photoFileList.add("D:\\sample_photo\\3.jpg");
		photoFileList.add("D:\\sample_photo\\4.jpg");
		photoFileList.add("D:\\sample_photo\\5.jpg");
		storyPhotoUpload.setFilePathList(photoFileList);
	}
	
	@Test
	public void getProfile() {
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
	
	@Test
	public void notePostingTest() {
		//kakao story posting
		System.out.println("********************************************************");
		System.out.println("** Story note posting operation");
		System.out.println("********************************************************");
		StoryNotePosting storyNotePosting = new StoryNotePosting();
		StringBuilder sbNoteContent = new StringBuilder("Kakao rest api library ���� �׽�Ʈ(spring social kakao).\r\n")
			.append("\r\n�׽�Ʈ �ð� : ").append(DATE_FORMAT.format(new Date()));
		storyNotePosting.setContent(sbNoteContent.toString());
		
		StoryPostingResult notePostingResult = kakao.storyOperation().postNote(storyNotePosting);
		System.out.println(String.format("** posting article id : %s", notePostingResult.getId()));
		System.out.println("********************************************************");
	}
	
	@Test
	public void linkPostingTest() {
		//kakao story linkInfo
		System.out.println("********************************************************");
		System.out.println("** Story link info");
		System.out.println("********************************************************");
		StoryLinkInfo storyLinkInfo = kakao.storyOperation().linkInfo("https://github.com/bongki/spring-social-kakao");
		System.out.println(String.format("** storyOperation -> linkInfo -> url : %s", storyLinkInfo.getUrl()));
		System.out.println(String.format("** storyOperation -> linkInfo -> requested_url : %s", storyLinkInfo.getRequested_url()));
		System.out.println(String.format("** storyOperation -> linkInfo -> host : %s", storyLinkInfo.getHost()));
		System.out.println(String.format("** storyOperation -> linkInfo -> title : %s", storyLinkInfo.getTitle()));
		System.out.println(String.format("** storyOperation -> linkInfo -> image : %s", storyLinkInfo.getImage()));
		System.out.println(String.format("** storyOperation -> linkInfo -> description : %s", storyLinkInfo.getDescription()));
		System.out.println(String.format("** storyOperation -> linkInfo -> section : %s", storyLinkInfo.getSection()));
		System.out.println(String.format("** storyOperation -> linkInfo -> site_name : %s", storyLinkInfo.getSite_name()));
		System.out.println("********************************************************");
		
		System.out.println("********************************************************");
		System.out.println("** Story link info object to json string");
		System.out.println("********************************************************");
		System.out.println("** Story link info object to json string (pretty print)");
		System.out.println(storyLinkInfo.toJsonString(true));
		System.out.println("** Story link info object to json string");
		System.out.println(storyLinkInfo.toJsonString(false));
		System.out.println("********************************************************");
		
		System.out.println("********************************************************");
		System.out.println("** Story link posting operation (use storyLinkInfo object)");
		System.out.println("********************************************************");
		StoryLinkPosting storyLinkPosting = new StoryLinkPosting();
		
		storyLinkPosting.setStoryLinkInfo(storyLinkInfo);
		
		StringBuilder sbLinkContent = new StringBuilder("Kakao rest api library ���� �׽�Ʈ(spring social kakao).\r\n")
			.append("kakao linkinfo rest api ȣ�� ��� ��ü ���� �׽�Ʈ\r\n")
			.append("\r\n�׽�Ʈ �ð� : ").append(DATE_FORMAT.format(new Date()));
		storyLinkPosting.setContent(sbLinkContent.toString());
		
		StoryPostingResult linkResult = kakao.storyOperation().postLink(storyLinkPosting);
		System.out.println(String.format("** link article id : %s", linkResult.getId()));
		System.out.println("********************************************************");
		
	}
	
	@Test
	public void linkWithURLPostingTest() {
		System.out.println("********************************************************");
		System.out.println("** Story link posting operation (use url)");
		System.out.println("********************************************************");
		StoryLinkPosting storyLinkPostingWithURL = new StoryLinkPosting();
		
		storyLinkPostingWithURL.setUrl("https://github.com/bongki/spring-social-kakao");
		
		StringBuilder sbLinkWithURLContent = new StringBuilder("Kakao rest api library ���� �׽�Ʈ(spring social kakao).\r\n")
			.append("url ����(kakao linkinfo rest api ȣ�� ���� ó��) �׽�Ʈ\r\n")
			.append("\r\n�׽�Ʈ �ð� : ").append(DATE_FORMAT.format(new Date()));
		storyLinkPostingWithURL.setContent(sbLinkWithURLContent.toString());
		
		StoryPostingResult linkWithURLResult = kakao.storyOperation().postLink(storyLinkPostingWithURL);
		System.out.println(String.format("** link(with url) article id : %s", linkWithURLResult.getId()));
		System.out.println("********************************************************");
	}
	
	@Test
	public void uploadPhotoTest() {
		System.out.println("********************************************************");
		System.out.println("** Story photo upload operation");
		System.out.println("********************************************************");
		List<String> imageUrlList = kakao.storyOperation().uploadPhoto(storyPhotoUpload);
		for (String photoUrl : imageUrlList) {
			System.out.println(String.format("** image url : %s", photoUrl));
		}
		System.out.println("********************************************************");
		
		System.out.println("********************************************************");
		System.out.println("** Story photo posting operation (use imageUrlList object)");
		System.out.println("********************************************************");
		StoryPhotoPosting storyPhotoPosting = new StoryPhotoPosting();
		storyPhotoPosting.setImageUrlList(imageUrlList);
		StringBuilder sbPhotoContent = new StringBuilder("Kakao rest api library ���� �׽�Ʈ(spring social kakao).\r\n")
			.append("kakao multi rest api ȣ�� ��� ��ü ���� �׽�Ʈ\r\n")
			.append("\r\n�׽�Ʈ �ð� : ").append(DATE_FORMAT.format(new Date()));
		storyPhotoPosting.setContent(sbPhotoContent.toString());
		StoryPostingResult photoResult = kakao.storyOperation().postPhoto(storyPhotoPosting);
		System.out.println(String.format("** photo article id : %s", photoResult.getId()));
		System.out.println("********************************************************");
	}
	
	@Test
	public void uploadPhotoTestWithFileList() {
		System.out.println("********************************************************");
		System.out.println("** Story photo posting operation (use storyPhotoUpload object)");
		System.out.println("********************************************************");
		StoryPhotoPosting storyPhotoPosting = new StoryPhotoPosting();
		storyPhotoPosting.setStoryPhotoUpload(storyPhotoUpload);
		StringBuilder sbPhotoContent = new StringBuilder("Kakao rest api library ���� �׽�Ʈ(spring social kakao).\r\n")
			.append("kakao multi rest api ���� ó�� �׽�Ʈ\r\n")
			.append("\r\n�׽�Ʈ �ð� : ").append(DATE_FORMAT.format(new Date()));
		storyPhotoPosting.setContent(sbPhotoContent.toString());
		StoryPostingResult photoResult = kakao.storyOperation().postPhoto(storyPhotoPosting);
		System.out.println(String.format("** photo article id : %s", photoResult.getId()));
		System.out.println("********************************************************");
	}
	
	@Test
	public void listToJson() {
		List<String> list = new ArrayList<String>();
		
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		
		ObjectMapper om = new ObjectMapper();
		try {
			System.out.println(om.writerWithDefaultPrettyPrinter().writeValueAsString(list));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}