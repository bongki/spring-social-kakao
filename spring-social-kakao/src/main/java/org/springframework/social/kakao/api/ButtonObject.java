package org.springframework.social.kakao.api;

import java.io.Serializable;

public class ButtonObject implements Serializable {

	ButtonObject() {
	}

	private static final long serialVersionUID = 1L;

	private String title;
	private LinkObject link;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LinkObject getLink() {
		return link;
	}

	public void setLink(LinkObject link) {
		this.link = link;
	}
}
