package com.hcc.utils;

import com.hcc.entities.Authority;
import com.hcc.entities.User;
import com.hcc.repositories.AuthorityRepository;
import com.hcc.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class SeedData implements CommandLineRunner {

    @Autowired
    UserRepository userRepo;

    @Autowired
    AuthorityRepository authRepo;

    @Override
    public void run(String... args) throws Exception {

        loadUserData();
        loadAuthorityData();
    }

    private void loadAuthorityData() {
        if(authRepo.count() == 0) {
            User user = userRepo.findByUsername("Dave").get();
            Authority auth = new Authority("ROLE_ADMIN", user);

            authRepo.save(auth);
        }
    }

    private void loadUserData() {
        // check for nothing in userRepo
        if (userRepo.count() == 0) {
            PasswordEncoder pwEnc = new BCryptPasswordEncoder();
            String password = pwEnc.encode("SecretSauce");
            User user = new User("Dave", password);

            userRepo.save(user);
        }
    }
}
