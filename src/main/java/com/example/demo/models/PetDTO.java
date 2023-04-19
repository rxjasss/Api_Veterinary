package com.example.demo.models;

public class PetDTO {
	private int id, idUser;
	private int age;
	private String name, animal, breed;

	public PetDTO() {
		super();
	}

	public PetDTO(int id, int idUser, int age, String name, String animal, String breed) {
		super();
		this.id = id;
		this.idUser = idUser;
		this.age = age;
		this.name = name;
		this.animal = animal;
		this.breed = breed;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAnimal() {
		return animal;
	}

	public void setAnimal(String animal) {
		this.animal = animal;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	@Override
	public String toString() {
		return "PetDTO [id=" + id + ", idUser=" + idUser + ", age=" + age + ", name=" + name + ", animal=" + animal
				+ ", breed=" + breed + "]";
	}

}
