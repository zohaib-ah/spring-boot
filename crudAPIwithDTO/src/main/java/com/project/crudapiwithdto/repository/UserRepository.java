package com.project.crudapiwithdto.repository;


import com.project.crudapiwithdto.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String  user);
}
