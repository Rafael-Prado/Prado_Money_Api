package com.prado.moneyapi.token;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import com.prado.moneyapi.config.property.MoneyApiProperty;

@ControllerAdvice
public class RefreshTokenPostProcessor implements ResponseBodyAdvice<OAuth2AccessToken>{
	
	@Autowired
	private MoneyApiProperty moneyApiProperty;

	
	@Override
	public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> convertType) {
		return returnType.getMethod().getName().equals("postAccessToken") ;
	}
	
	@Override
	public OAuth2AccessToken beforeBodyWrite(OAuth2AccessToken body, MethodParameter returnType, MediaType selectContentype,
			Class<? extends HttpMessageConverter<?>> selectdConvertType, ServerHttpRequest request, ServerHttpResponse response) {
		 
		 DefaultOAuth2AccessToken token = (DefaultOAuth2AccessToken) body;
		 
		 HttpServletRequest req = ((ServletServerHttpRequest) request).getServletRequest();
		 HttpServletResponse respo = ((ServletServerHttpResponse) response).getServletResponse();
		
		String refreshToken = body.getRefreshToken().getValue();
		adionarRefreshTokenNoCookie(refreshToken, req, respo );	
		
		removerRefreshTokenDoBody(token);		
		
		return body;
	}

	private void removerRefreshTokenDoBody(DefaultOAuth2AccessToken token) {
		token.setRefreshToken(null);
		
	}

	private void adionarRefreshTokenNoCookie(String refreshToken, HttpServletRequest req, HttpServletResponse respo) {
		Cookie refreshTokenCooke = new Cookie("refreshToken", refreshToken);
		refreshTokenCooke.setHttpOnly(true);
		refreshTokenCooke.setSecure(moneyApiProperty.getSeguranca().isEnableHttps());
		refreshTokenCooke.setPath(req.getContextPath() + "/oauth/token");
		refreshTokenCooke.setMaxAge(2592000);
		
		respo.addCookie(refreshTokenCooke);
		
	}

}
