package com.aacademy.firstrestproject.repository;


import com.aacademy.firstrestproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {


   Optional<User> findByName(String name);

   void deleteByName(String name);
}
