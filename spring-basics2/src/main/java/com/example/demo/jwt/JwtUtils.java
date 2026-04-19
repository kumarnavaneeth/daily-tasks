package com.example.demo.jwt;


import java.nio.charset.StandardCharsets;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.example.demo.service.UserDetailsImplementation;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import java.security.Key;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SecurityException;

@Component
public class JwtUtils {
private static final Logger logger=LoggerFactory.getLogger(JwtUtils.class);

@Value("${com.tek.security.jwt.jwtSecret}")
private String jwtSecret;
@Value("${com.tek.security.jwt.jwtExpirationMs}")
private int jwtExpirationMs;
private Key getSigningKey() {
    byte[] keyBytes = this.jwtSecret.getBytes(StandardCharsets.UTF_8);
    return Keys.hmacShaKeyFor(keyBytes);
}
public String generateJwtToken(Authentication authentication) {
	UserDetailsImplementation userPrincipal=(UserDetailsImplementation) authentication.getPrincipal();
	 return Jwts.builder()
             .setSubject((userPrincipal.getUsername()))
             .setIssuedAt(new Date())
             .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
             .signWith(getSigningKey(), SignatureAlgorithm.HS512)
             .compact();
}
public boolean validateJwtToken(String authToken) {
	try {
		Jwts.parserBuilder()
        .setSigningKey(getSigningKey())
        .build()
        .parseClaimsJws(authToken);
    return true;
	}
	catch(SecurityException securityException){
		logger.error("Invalid JWT Token: {}",securityException.getMessage());
	}
	catch(MalformedJwtException malformedJwtException) {
		logger.error("Invalid JWT Token : {}",malformedJwtException.getMessage());
	}
	catch(ExpiredJwtException expiredJwtException) {
		logger.error("JWT token is expired : {}",expiredJwtException.getMessage());
	}
	catch(UnsupportedJwtException unsupportedJwtException) {
		logger.error("JWT token is unsupported: {}",unsupportedJwtException.getMessage());
	}
	catch(IllegalArgumentException illegalArgumentException) {
		logger.error("JWT claims string is empty: {}", illegalArgumentException.getMessage());
	}
	return false;
}

public String getUsernameFromJwtToken(String authToken) {
    return Jwts.parserBuilder()
            .setSigningKey(getSigningKey())
            .build()
            .parseClaimsJws(authToken)
            .getBody()
            .getSubject();
}
}
