package com.hcc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hcc.entities.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//@Repository will make a class out of this for you
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    //findByUsername : it will automatically search by username
    Optional<User> findByUsername(String username);

}
