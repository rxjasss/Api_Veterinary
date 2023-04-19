package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Pet;
import com.example.demo.models.PetDTO;

public interface PetService {
	public abstract PetDTO addPet(PetDTO petDTO);
	public abstract List<PetDTO> listAllPets();
	public abstract Pet findPetById(int id);
	public abstract List<PetDTO> findPetByIdUser(int idUser);
	public abstract boolean removePet(int id);
	public abstract Pet transform(PetDTO petDTO);
	public abstract PetDTO transform(Pet pet);
}
