package com.hcc.services;

import com.hcc.entities.User;
import com.hcc.repositories.UserRepository;
import com.hcc.utils.CustomPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

// uncomment this class once you have created all the needed parts

// VERSION 1: found in forked clone
//@Service
//public class UserDetailServiceImpl implements UserDetailsService {
//    @Autowired
//    CustomPasswordEncoder passwordEncoder;
//
//    @Autowired
//     UserRepository userRepo;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Optional<User> user = userRepo.findByUsername(username); //was userOpt
//        user.setUsername(username);
//        user.setPassword(passwordEncoder.getPasswordEncoder().encode("asdfasdf"));
//        return user.orElseThrow(() -> new UsernameNotFoundException("Invalid Credentials")); //was userOpt
//    }
//}

@Service
public class UserDetailServiceImpl implements UserDetailsService {
//    @Autowired
//    CustomPasswordEncoder passwordEncoder; //commented out for secondTicket

    @Autowired
    UserRepository userRepo;

    // Changed return type from UserDetails to User
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepo.findByUsername(username); //was userOpt
//        user.setUsername(username);
//        user.setPassword(passwordEncoder.getPasswordEncoder().encode("asdfasdf"));
        return user.orElseThrow(() -> new UsernameNotFoundException("Invalid Credentials")); //was userOpt
    }
}
