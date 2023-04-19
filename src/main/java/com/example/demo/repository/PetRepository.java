package com.example.demo.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Pet;

@Repository("petRepository")
public interface PetRepository extends JpaRepository<Pet, Serializable> {
	public abstract Pet findById(int id);
	public abstract Pet findByIdUser(int idUser);
}
