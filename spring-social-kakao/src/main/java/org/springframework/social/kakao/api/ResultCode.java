package org.springframework.social.kakao.api;

import java.io.Serializable;

public class ResultCode extends KakaoObject implements Serializable {

	private static final long serialVersionUID = 1L;

	private int resultCode;

	public int getResultCode() {
		return resultCode;
	}
}
