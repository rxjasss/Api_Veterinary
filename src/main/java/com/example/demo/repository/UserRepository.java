package com.example.demo.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Serializable> {
	public abstract User findByUsername(String username);
	public abstract User findById (int id);
}