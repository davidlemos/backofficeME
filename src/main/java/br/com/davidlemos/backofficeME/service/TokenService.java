package br.com.davidlemos.backofficeME.service;

import java.util.Date;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


public class TokenService {
		
	private static final long EXPIRATIONTIME = 10 * 60 * 1000;
    private static final String SECRETKEY = "M0nk3y3xch4ng3";
    
	public String  gerarToken(String email){

	        String JWT = Jwts.builder()
	                .setSubject(email)
	                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
	                .signWith(SignatureAlgorithm.HS512, SECRETKEY)
	                .compact();

	        String token = JWT;
	       return token;
	}
}
