package com.victorecmonteiro.attendease.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.time.Instant;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class JWTGenerator {
    private final Key key;
    public JWTGenerator(
            @Value("${app.properties.JWTKeyBase64}") String secretBase64
    ) {
        byte[] decodedKey = java.util.Base64
                .getDecoder()
                .decode(secretBase64);

        this.key = Keys.hmacShaKeyFor(decodedKey);
    }



    public String generateToken(Authentication authentication) {
        String username = authentication.getName();
        Instant currentInstant = Instant.now();
        Instant expireInstant = currentInstant.plusSeconds(36000);
        Date expireDate = Date.from(expireInstant);

        String token =
                Jwts.builder()
                        .setSubject(username)
                        .setIssuedAt(new Date())
                        .setExpiration(expireDate)
                        .signWith(key, SignatureAlgorithm.HS512)
                        .compact();
        System.out.println("New token :");
        System.out.println(token);
        return token;
    }

    public String getUsernameFromJWT(String token) {
        Claims claims = Jwts.parser().setSigningKey(key).build().parseClaimsJws(token).getBody();
        return claims.getSubject();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (Exception ex) {
            throw new AuthenticationCredentialsNotFoundException(
                    "JWT was expired or incorrect", ex.fillInStackTrace());
        }
    }
}
