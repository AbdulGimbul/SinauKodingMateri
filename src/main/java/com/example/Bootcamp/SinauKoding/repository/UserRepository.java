package com.example.Bootcamp.SinauKoding.repository;

import com.example.Bootcamp.SinauKoding.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByProfileNameContaining(String profileName);
}
