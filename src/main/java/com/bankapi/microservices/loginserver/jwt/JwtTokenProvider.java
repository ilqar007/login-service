package com.bankapi.microservices.loginserver.jwt;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.Date;
import lombok.Data;

import static com.bankapi.microservices.loginserver.constants.JWTConstants.JWT_KEY;

@Component
public class JwtTokenProvider {
	 private String secretKey="secret-key";
	 private long validityInMilliseconds = 3600000; // 1h
	 



    public String createToken(String username) {

        return Jwts.builder()
                .setSubject(username)
                .setIssuer(JWT_KEY)
                .setExpiration(calculateExpirationDate())
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    private Date calculateExpirationDate() {
        Date now = new Date();
        return new Date(now.getTime() + validityInMilliseconds);
    }
}
