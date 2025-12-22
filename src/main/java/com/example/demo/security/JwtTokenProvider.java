package com.example.demo.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtTokenProvider {

    // Secret key (must be at least 256 bits for HS256)
    private static final String JWT_SECRET =
            "MySuperSecretKeyForJwtGenerationMySuperSecretKey";

    // Token validity (24 hours)
    private static final long JWT_EXPIRATION_MS = 86400000;

    private final Key key = Keys.hmacShaKeyFor(JWT_SECRET.getBytes());

    // =========================
    // GENERATE TOKEN
    // =========================
    public String generateToken(String username) {

        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + JWT_EXPIRATION_MS);

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    // =========================
    // GET USERNAME FROM TOKEN
    // =========================
    public String getUsernameFromToken(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }

    // =========================
    // VALIDATE TOKEN
    // =========================
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }
}
