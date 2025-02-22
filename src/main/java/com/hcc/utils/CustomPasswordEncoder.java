package com.hcc.utils;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@Component
public class CustomPasswordEncoder {
    private final PasswordEncoder passwordEncoder; //made final as it is used only once.

    public CustomPasswordEncoder(){
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public PasswordEncoder getPasswordEncoder(){
        return passwordEncoder;
    }
}
