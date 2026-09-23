package com.sunbeam.users.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.users.domain.User;

public interface UserDao extends JpaRepository<User,Integer> {

    Optional<User> findByEmail(String email);
}
