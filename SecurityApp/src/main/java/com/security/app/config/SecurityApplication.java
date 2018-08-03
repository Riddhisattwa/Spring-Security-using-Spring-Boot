package com.security.app.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//the application file which runs the spring boot application
@SpringBootApplication
@ComponentScan({"com.security.app","com.security.app.*"})
public class SecurityApplication {
    public static void main(String args[]){
        SpringApplication.run(SecurityApplication.class,args);
    }
}
