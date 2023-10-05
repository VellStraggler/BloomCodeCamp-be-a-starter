package com.hcc.controllers;

import com.hcc.data_transferers.AuthCredentialRequest;
import com.hcc.entities.Authority;
import com.hcc.entities.User;
import com.hcc.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*") //gets around CORS
public class AuthorizationController {

    @Autowired
    AuthenticationManager manager;

    @Autowired
    JwtUtil util;

    @PostMapping("/login")
    ResponseEntity<?> login(@RequestBody AuthCredentialRequest request) {
        try {
            // authenticating by making a new authentication
            // This tells the API to allow HTTP requests
            Authentication auth = manager.authenticate(new UsernamePasswordAuthenticationToken(
                    request.getUsername(), request.getPassword()));
            User user = (User)auth.getPrincipal();
            return ResponseEntity.ok().header(HttpHeaders.AUTHORIZATION, util.generateToken(user))
                    .body("\nLogged in with username: " + user.getUsername());
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @GetMapping("/validate")
    ResponseEntity<?> validate(@AuthenticationPrincipal Authority authority) {
        return ResponseEntity.ok("Authority Entered Successfully");
    }
}
