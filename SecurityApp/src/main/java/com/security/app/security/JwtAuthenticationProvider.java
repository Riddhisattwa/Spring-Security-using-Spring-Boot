package com.security.app.security;

import com.security.app.model.JwtAuthenticationToken;
import com.security.app.model.JwtUser;
import com.security.app.model.JwtUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JwtAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

    @Autowired
    private JwtValidator validator;
    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {

    }
    //this will be called when there is a user here
    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {
        JwtUser jwtUser=null;
        JwtAuthenticationToken jwtAuthenticationToken = (JwtAuthenticationToken) usernamePasswordAuthenticationToken;
        String token = jwtAuthenticationToken.getToken();
        jwtUser = (JwtUser) validator.validate(token);
        if(jwtUser==null)
            throw new RuntimeException("Jwt Token incorrect!");
        List<GrantedAuthority> grantedAuthorities=AuthorityUtils.commaSeparatedStringToAuthorityList(jwtUser.getRole());
        JwtUserDetails jwtUserDetails=new JwtUserDetails(jwtUser.getUsername(),jwtUser.getId(),jwtAuthenticationToken.getToken(),grantedAuthorities);
        return jwtUserDetails;
    }

    @Override
    public boolean supports(Class<?> aClass) {

        return JwtAuthenticationToken.class.isAssignableFrom(aClass);
    }
}
