package org.springframework.social.kakao.api;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TextObject extends KakaoObject {

	private static final long serialVersionUID = 1L;

	private String object_type = "text";
	private String text;
	private LinkObject link = new LinkObject();
	private String button_title;
	private ButtonObject[] buttons;

	public String getObject_type() {
		return object_type;
	}

	public void setObject_type(String object_type) {
		this.object_type = object_type;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public LinkObject getLink() {
		return link;
	}

	public void setLink(LinkObject link) {
		this.link = link;
	}

	public String getButton_title() {
		return button_title;
	}

	public void setButton_title(String button_title) {
		this.button_title = button_title;
	}

	public ButtonObject[] getButtons() {
		return buttons;
	}

	public void setButtons(ButtonObject[] buttons) {
		this.buttons = buttons;
	}

}