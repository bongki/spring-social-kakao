package org.springframework.social.kakao.connect;

import org.springframework.social.connect.support.OAuth2ConnectionFactory;
import org.springframework.social.kakao.api.Kakao;

public class KakaoConnectionFactory extends OAuth2ConnectionFactory<Kakao>{
	public KakaoConnectionFactory(String clientId, String clientSecret) {
		super("kakao", new KakaoServiceProvider(clientId, clientSecret), new KakaoAdapter());
	}
}