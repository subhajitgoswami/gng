package com.assignment.authentication.gng.config;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import com.assignment.authentication.gng.user.CustomUser;

public class CustomTokenEnhancer extends  JwtAccessTokenConverter {
	
	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		CustomUser user = (CustomUser) authentication.getPrincipal();
		Map<String, Object> info = new LinkedHashMap<>(accessToken.getAdditionalInformation());
		if (user.getId() != null)
			info.put("id", user.getId());
		if (user.getName() != null)
			info.put("name", user.getName());
		if (user.getUsername() != null)
			info.put("userName", user.getUsername());
		if (user.getLastName() != null)
			info.put("lastName", user.getLastName());
		if (user.getCountry() != null)
			info.put("country", user.getCountry());
		if (user.getMobile() != null)
			info.put("mobile", user.getMobile());
		if (user.getIsTwoFaEnabled() != null)
			info.put("isTwoFaEnabled", user.getIsTwoFaEnabled());
		if (user.getTwoFaType() != null)
			info.put("usetwoFaTyperName", user.getTwoFaType());
		DefaultOAuth2AccessToken customAccessToken = new DefaultOAuth2AccessToken(accessToken);
		customAccessToken.setAdditionalInformation(info);
		return super.enhance(customAccessToken, authentication);
	}

}
