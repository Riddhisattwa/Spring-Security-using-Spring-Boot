package com.security.app.security;

import com.security.app.model.JwtUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

@Component
public class JwtValidator {
    //user defined secret
    private String secret="youtube";

    public Object validate(String token) {

        Claims body=Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
        //extracting data from jwt and setting it to the model
        JwtUser jwtUser=new JwtUser();
        jwtUser.setUsername(body.getSubject());
        jwtUser.setId(Long.parseLong(body.get("userId").toString()));
        //jwtUser.setId(Long.parseLong(body.get("Id").toString()));
        jwtUser.setRole(body.get("role").toString());

        return jwtUser;
    }
}
