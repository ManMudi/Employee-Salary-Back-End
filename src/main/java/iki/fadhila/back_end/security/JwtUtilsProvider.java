package iki.fadhila.back_end.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtUtilsProvider {

    @Value("${app.jwt-secret}")
    private String secretKey;
    @Value("${app.jwt-expiration-milliseconds}")
    private Long expirationTime;

    //generateKey
    public SecretKey keys(){
        return Keys.hmacShaKeyFor(Decoders.BASE64URL.decode(secretKey));
    }

    //generateToken
    public String generateToken(Authentication authentication){
        String username=authentication.getName();
        Date currentDate=new Date();
        return Jwts.builder()
                .signWith(keys())
                .issuedAt(currentDate)
                .expiration(new Date(currentDate.getTime()+expirationTime))
                .subject(username)
                .compact();
    }

    //getUsernameFromToken
    public String getUsernameFromToken(String token){
        return Jwts.parser()
                .verifyWith(keys())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }


    //validateToken
    public Boolean validateToken(String token){
        Jwts.parser()
                .verifyWith(keys())
                .build()
                .parseSignedClaims(token);
        return true;
    }
}
