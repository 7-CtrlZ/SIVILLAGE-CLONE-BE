package com.academy.sivillageclonebe.common.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@RequiredArgsConstructor
@Service
public class JwtTokenProvider {

    private final Environment env;

    public String generateAccessToken(Authentication authentication) {
        return generateToken(authentication, env.getProperty("jwt.access-expire-times", Long.class));
    }

    public String generateRefreshToken(Authentication authentication) {
        return generateToken(authentication, env.getProperty("jwt.refresh-expire-times", Long.class));
    }

    private String generateToken(Authentication authentication, Long expireTime) {
        Claims claims = Jwts.claims().subject(authentication.getName()).build();
        Date now = new Date();
        Date expiration = new Date(now.getTime() + expireTime);

        return Jwts.builder()
                .claim("email", claims.getSubject())
                .issuedAt(now)
                .expiration(expiration)
                .signWith(getSignKey())
                .compact();
    }

    public Key getSignKey() {
        return Keys.hmacShaKeyFor( env.getProperty("jwt.secret-key").getBytes() );
    }

    // todo: 뭐야이거
    public Claims getClaims(String token) {
        return Jwts.parser()
                .setSigningKey(getSignKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public boolean validateToken(String token) {
        try {
            getClaims(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}