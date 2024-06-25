package com.FileCloud.FileCloud.utility;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import java.util.Base64;
import java.util.Date;
import java.util.function.Function;

@Component
public class JwtUtil {
    private String secretKey = "DQJgWpxqSwJlv5x5JNf3czwEx-XnPGxPehWfb18wgNY";




        public String generateToken(String username) {
            try {
              //  logger.debug("Attempting to generate token for user: {}", username);
                String token = Jwts.builder()
                        .setSubject(username)
                        .setIssuedAt(new Date())
                        .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 hours
                        .signWith(SignatureAlgorithm.HS256, secretKey.getBytes())
                        .compact();
                //logger.debug("Token generated successfully");
                return token;
            } catch (Exception e) {
               // logger.error("Error generating token for user: {}", username, e);
                return null;
            }
        }



    public boolean validateToken(String token, String username) {
        String extractedUsername = Jwts.parser()
                .setSigningKey(Base64.getEncoder().encodeToString(secretKey.getBytes()))
                .parseClaimsJws(token)
                .getBody()
                .getSubject();

        return extractedUsername.equals(username);
    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
    }

    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }
}
