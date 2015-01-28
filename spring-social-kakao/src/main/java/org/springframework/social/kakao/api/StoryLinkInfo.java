package org.springframework.social.kakao.api;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class StoryLinkInfo {
	private String url;
	private String requested_url;
	private String host;
	private String title;
	private List<String> image;
	private String description;
	private String section;
	private String site_name;
	
	/**
	 * <pre>
	 * 스크랩 한 주소의 URL. shorten URL의 경우 resolution한 실제 URL
	 * </pre>
	 * @return
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * <pre>
	 * 요청시의 URL 원본. resolution을 하기 전의 URL
	 * </pre>
	 * @return
	 */
	public String getRequested_url() {
		return requested_url;
	}
	/**
	 * <pre>
	 * 요청한 주소의 Host 명
	 * </pre>
	 * @return
	 */
	public String getHost() {
		return host;
	}
	/**
	 * <pre>
	 * 웹페이지 타이틀
	 * </pre>
	 * @return
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * <pre>
	 * 해당 웹 페이지의 대표 이미지 주소. 최대 3개.
	 * </pre>
	 * @return
	 */
	public List<String> getImage() {
		return image;
	}
	/**
	 * <pre>
	 * 해당 웹 페이지의 설명
	 * </pre>
	 * @return
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * <pre>
	 * 해당 웹 페이지의 섹션 정보
	 * </pre>
	 * @return
	 */
	public String getSection() {
		return section;
	}
	/**
	 * <pre>
	 * 해당 웹 사이트 이름
	 * </pre>
	 * @return
	 */
	public String getSite_name() {
		return site_name;
	}
	
	/**
	 * <pre>
	 * Json string 형태로 데이터를 변환한다.
	 * </pre>
	 * @param prettyPrint
	 * @return
	 */
	public String toJsonString(boolean prettyPrint) {
		ObjectMapper objectMapper = new ObjectMapper();
		
		try {
			if (prettyPrint) {
				return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(this);
			} else {
				return objectMapper.writeValueAsString(this);
			}
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return "";
		}
	}

	StoryLinkInfo(){}
}
