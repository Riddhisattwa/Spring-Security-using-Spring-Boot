package com.security.app.controller;

import com.security.app.model.JwtUser;
import com.security.app.security.JwtGenerator;
import org.springframework.web.bind.annotation.*;

//controller which generates token
@RestController
@RequestMapping("/token")
public class TokenController {

    @PostMapping
    public String generate(@RequestBody final JwtUser jwtUser){

        JwtGenerator jwtGenerator=new JwtGenerator();
        return jwtGenerator.generate(jwtUser);
    }

}
