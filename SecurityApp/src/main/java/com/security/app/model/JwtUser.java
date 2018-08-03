package com.security.app.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//this is the model class for JWT user. We have used lombok to perform automatic setter and getter.

@Getter
@Setter
@NoArgsConstructor
public class JwtUser {

    String username;
    long Id;
    String role;

}
