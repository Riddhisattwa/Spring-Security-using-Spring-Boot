package com.security.app.config;

import com.security.app.security.JwtAuthenticationEntryPoint;
import com.security.app.security.JwtAuthenticationProvider;
import com.security.app.security.JwtAuthenticationTokenFilter;
import com.security.app.security.JwtSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.Collections;

//security configuration for spring boot provided here

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Configuration
public class JwtSecurityConfig extends WebSecurityConfigurerAdapter {

    //responsible for authenticating the user
    @Autowired
    private JwtAuthenticationProvider authenticationProvider;

    //responsible for entry point for performing authentication
    @Autowired
    private JwtAuthenticationEntryPoint entrypoint;

    //perform filters before the request is sent to the servlet from user side
    @Bean
    public JwtAuthenticationTokenFilter authenticationTokenFilter(){

        JwtAuthenticationTokenFilter filter=new JwtAuthenticationTokenFilter();
        filter.setAuthenticationManager(authenticationManager());
        filter.setAuthenticationSuccessHandler(new JwtSuccessHandler());
        return filter;
    }

    //authenticationManager bean for performing authentication
    @Bean
    public AuthenticationManager authenticationManager(){
        return new ProviderManager(Collections.singletonList(authenticationProvider));
    }

    //here all the http related configurations are done
    @Override
    protected void configure(HttpSecurity http)throws Exception{
        http.csrf().disable()
                .authorizeRequests().antMatchers("**/hello/")
                .authenticated()
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(entrypoint)
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(authenticationTokenFilter(),UsernamePasswordAuthenticationFilter.class);
        http.headers().cacheControl();
    }
}
