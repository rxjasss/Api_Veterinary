package com.example.demo.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.example.demo.entity.Pet;
import com.example.demo.models.PetDTO;
import com.example.demo.repository.PetRepository;
import com.example.demo.service.PetService;

public class PetServiceImpl implements PetService{

	@Autowired
	@Qualifier("petRepository")
	private PetRepository petRepository;
	
	@Override
	public PetDTO addPet(PetDTO petDTO) {
		petRepository.save(transform(petDTO));
		return petDTO;
	}

	@Override
	public List<PetDTO> listAllPets() {
		return petRepository.findAll().stream().map(c -> transform(c)).collect(Collectors.toList());
	}

	@Override
	public Pet findPetById(int id) {
		return petRepository.findById(id);
	}

	@Override
	public List<PetDTO> findPetByIdUser(int idUser) {
		return petRepository.findByIdUser(idUser).stream().map(c -> transform(c))
				.collect(Collectors.toList());
	}

	@Override
	public boolean removePet(int id) {
		if (petRepository.findById(id) != null) {
			petRepository.deleteById(id);
			return true;
		} else
			return false;
	}

	@Override
	public Pet transform(PetDTO petDTO) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(petDTO, Pet.class);
	}

	@Override
	public PetDTO transform(Pet pet) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(pet, PetDTO.class);
	}

}
