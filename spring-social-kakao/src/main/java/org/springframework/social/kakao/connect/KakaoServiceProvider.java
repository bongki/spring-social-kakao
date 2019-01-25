package org.springframework.social.kakao.connect;

import org.springframework.social.kakao.api.Kakao;
import org.springframework.social.kakao.api.impl.KakaoTemplate;
import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;

public class KakaoServiceProvider extends AbstractOAuth2ServiceProvider<Kakao> {
	public KakaoServiceProvider(String clientId, String clientSecret) {
		super(new KakaoOAuth2Template(clientId, clientSecret));
	}
	
	@SuppressWarnings("deprecation")
	public Kakao getApi(String accessToken) {
		return new KakaoTemplate(accessToken);
	}
}
