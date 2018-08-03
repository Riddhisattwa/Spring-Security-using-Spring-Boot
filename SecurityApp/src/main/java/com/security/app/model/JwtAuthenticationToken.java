package com.security.app.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

//willbe used by other class as the model
//here the authentication token is set and get also credentials and principal is set and get
public class JwtAuthenticationToken extends UsernamePasswordAuthenticationToken {

    private String token;
    public JwtAuthenticationToken(String token) {
        super(null,null);
        this.token=token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return null;
    }
}
