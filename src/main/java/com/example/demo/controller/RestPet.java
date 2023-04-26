package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Pet;
import com.example.demo.models.PetDTO;
import com.example.demo.service.PetService;

@RestController
@RequestMapping("/api")
public class RestPet {

	@Autowired
	@Qualifier("petService")
	private PetService petService;

	// Lista todas las mascotas
	@GetMapping("/veterinary/pets")
	public ResponseEntity<?> getPets() {
		boolean exist = petService.listAllPets() != null;
		if (exist) {
			List<PetDTO> pets = petService.listAllPets();
			return ResponseEntity.ok(pets);
		} else
			return ResponseEntity.noContent().build();
	}

	// Lista todas las mascotas de un user
	@GetMapping("/user/pets{idUser}")
	public ResponseEntity<?> getPetsUser(@PathVariable int idUser) {
		boolean exist = petService.findPetByIdUser(idUser) != null;
		if (exist) {
			List<PetDTO> pets = petService.findPetByIdUser(idUser);
			return ResponseEntity.ok(pets);
		} else
			return ResponseEntity.noContent().build();
	}

	// Crea una mascota
	@PostMapping("/veterinary/pet")
	public ResponseEntity<?> insertPetNew(@RequestBody PetDTO petDTO) {
		petService.addPet(petDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(petDTO);
	}

	// Edita una mascota
	@PutMapping("/veterinary/pet/{idPet}")
	public ResponseEntity<?> updatePet(@RequestBody PetDTO pet, @PathVariable int idPet) {
		boolean exist = petService.findPetById(idPet) != null;
		if (exist) {
			Pet p = petService.findPetById(idPet);
			p.setAge(pet.getAge());
			p.setAnimal(pet.getAnimal());
			p.setBreed(pet.getBreed());
			p.setName(pet.getName());
			return ResponseEntity.ok(petService.addPet(petService.transform(p)));
		} else {
			return ResponseEntity.noContent().build();
		}

	}

	// Elimina una mascota
	@DeleteMapping("/veterinary/pet/{idPet}")
	public ResponseEntity<?> deleteAppointment(@PathVariable int idPet) {
		boolean exists = petService.removePet(idPet);
		if (exists)
			return ResponseEntity.ok().build();
		else
			return ResponseEntity.noContent().build();
	}
}
