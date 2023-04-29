package com.aiglesiasp.javamodc4.springjwt.piezas.security;

import static com.aiglesiasp.javamodc4.springjwt.piezas.security.Constants.HEADER_AUTHORIZACION_KEY;
import static com.aiglesiasp.javamodc4.springjwt.piezas.security.Constants.ISSUER_INFO;
import static com.aiglesiasp.javamodc4.springjwt.piezas.security.Constants.SUPER_SECRET_KEY;
import static com.aiglesiasp.javamodc4.springjwt.piezas.security.Constants.TOKEN_BEARER_PREFIX;
import static com.aiglesiasp.javamodc4.springjwt.piezas.security.Constants.TOKEN_EXPIRATION_TIME;

import java.io.IOException;
import java.util.Date;
import java.util.ArrayList;


import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.aiglesiasp.javamodc4.springjwt.piezas.dto.Usuario;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter{
	
	private AuthenticationManager authenticationManager;

	public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		try {
			Usuario credenciales = new ObjectMapper().readValue(request.getInputStream(), Usuario.class);

			return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					credenciales.getUsername(), credenciales.getPassword(), new ArrayList<>()));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication auth) throws IOException, ServletException {

		String token = Jwts.builder().setIssuedAt(new Date()).setIssuer(ISSUER_INFO)
				.setSubject(((Usuario)auth.getPrincipal()).getUsername())
				.setExpiration(new Date(System.currentTimeMillis() + TOKEN_EXPIRATION_TIME))
				.signWith(SignatureAlgorithm.HS512, SUPER_SECRET_KEY).compact();
		response.addHeader(HEADER_AUTHORIZACION_KEY, TOKEN_BEARER_PREFIX + " " + token);//devuelve token por cabecera
		response.getWriter().write("{\"token\": \"" + token + "\"}");//devuelve token por body
		System.out.println(response.getHeader(HEADER_AUTHORIZACION_KEY));
	
	}
}
