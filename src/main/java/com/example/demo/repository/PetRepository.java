package com.example.demo.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Pet;
import com.example.demo.entity.User;

@Repository("petRepository")
public interface PetRepository extends JpaRepository<Pet, Serializable> {
	public abstract Pet findById(int id);
	public abstract List<Pet> findByIdUser(User user);
}
