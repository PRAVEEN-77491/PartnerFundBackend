package com.partnersFunds.utils;

import org.springframework.stereotype.Component;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import javax.crypto.SecretKey;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Component
public class JwtUtil {

	private static final Map<String, Boolean> blacklistedTokens = new ConcurrentHashMap<>();

	private String SECRET_KEY = "TaK+HaV^uvCHEFsEVfypW#7g9^k*Z8$V";
//	String SECRET_KEY = Jwts.SIG.HS256.key().build().toString();

	private SecretKey getSigningKey() {
		return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
	}

	public String extractUsername(String token) {
		Claims claims = extractAllClaims(token);
		return claims.getSubject();
	}

	public Date extractExpiration(String token) {
		return extractAllClaims(token).getExpiration();
	}

	public Claims extractAllClaims(String token) {
		return Jwts.parser().verifyWith(getSigningKey()).build().parseSignedClaims(token).getPayload();
	}

	public List<String> extractAllClaimRoles(String token) {
	    Object rolesObject = Jwts.parser().verifyWith(getSigningKey()).build().parseSignedClaims(token).getPayload().get("roles");

	    if (rolesObject instanceof List<?>) {
	        return ((List<?>) rolesObject).stream()
	                    .filter(role -> role instanceof String)
	                    .map(role -> (String) role)
	                    .collect(Collectors.toList());
	    } else {
	        return Collections.emptyList();
	    }
	}
	
	public Boolean isTokenExpired(String token) {
		return extractExpiration(token).before(new Date());
	}

	public String generateToken(String username, String[] claims) {
		return createToken(username, claims);
	}

	private String createToken(String subject, String[] claims) {
		return Jwts.builder().claim("roles",claims).subject(subject).header().empty().add("typ", "JWT").and()
				.issuedAt(new Date(System.currentTimeMillis()))
				.expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 5)) // 5 minutes expiration time
				.signWith(getSigningKey())
				.compact();
	}

	public Boolean validateToken(String token) {
		return !isTokenExpired(token);
	}
	
    
    public void blacklistToken(String token) {
        blacklistedTokens.put(token, true);
    }
    
    public boolean isTokenBlacklisted(String token) {
        return blacklistedTokens.containsKey(token);
    }

}