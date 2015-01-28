package org.springframework.social.kakao.api;

import java.util.List;


public interface StoryOperation {
	/**
	 * <pre>
	 * 해당 access token을 발급받은 사용자의 카카오 스토리 사용 여부 확인
	 * </pre>
	 * @return
	 */
	KakaoStoryProfile isStoryUser();
	
	/**
	 * <pre>
	 * 해당 access token을 발급받은 사용자의 카카오 스토리 프로필 정보 조회
	 * </pre>
	 * @return
	 */
	KakaoStoryProfile getUserProfile();
	
	/**
	 * <pre>
	 * 해당 access token을 발급받은 사용자의 카카오 스토리 글 작성
	 * </pre>
	 * @param storyNotePosting
	 * @return
	 */
	StoryPostingResult postNote(StoryNotePosting storyNotePosting);
	
	/**
	 * <pre>
	 * 해당 access token을 발급받은 사용자의 카카오 이미지 업로드 (for postPhoto)
	 * </pre>
	 * @param storyPhotoUpload
	 * @return
	 */
	List<String> uploadPhoto(StoryPhotoUpload storyPhotoUpload);
	
	/**
	 * <pre>
	 * 해당 access token을 발급받은 사용자의 카카오 스토리 포토 포함 글 작성
	 * </pre>
	 * @param storyPhotoPosting
	 * @return
	 */
	StoryPostingResult postPhoto(StoryPhotoPosting storyPhotoPosting);
	
	/**
	 * <pre>
	 * 외부 링크 정보 가져오기 (link 포스팅 정보에 활용)
	 * </pre>
	 * @param uri
	 * @return
	 */
	StoryLinkInfo linkInfo(String url);
	
	/**
	 * <pre>
	 * 해당 access token을 발급받은 사용자의 카카오 스토리 외부 페이지 링크 포함 글 작성
	 * </pre>
	 * @param storyLinkData
	 * @return
	 */
	StoryPostingResult postLink(StoryLinkPosting storyLinkPosting);
}
