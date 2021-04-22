package com.techprimers.example.Spring._starter.repository;


import com.techprimers.example.Spring._starter.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

//
public interface UsersRepository extends JpaRepository<Users, Integer> {
    List<Users> findByName(String name);
}
