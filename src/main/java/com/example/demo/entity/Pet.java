package com.example.demo.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Pet {
	@Id
	@GeneratedValue
	private int id;

	@ManyToOne
	@JoinColumn(name = "idUser")
	private User idUser;

	private int age;
	private String name, animal, breed;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "idPet")
	private Appointment appointment;

	public Pet() {
		super();
	}

	public Pet(int id, User idUser, int age, String name, String animal, String breed) {
		super();
		this.id = id;
		this.idUser = idUser;
		this.age = age;
		this.name = name;
		this.animal = animal;
		this.breed = breed;
	}

	public Pet(int id, User idUser, int age, String name, String animal, String breed, Appointment appointment) {
		super();
		this.id = id;
		this.idUser = idUser;
		this.age = age;
		this.name = name;
		this.animal = animal;
		this.breed = breed;
		this.appointment = appointment;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getIdUser() {
		return idUser;
	}

	public void setIdUser(User idUser) {
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

	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

	@Override
	public String toString() {
		return "Pet [id=" + id + ", idUser=" + idUser + ", age=" + age + ", name=" + name + ", animal=" + animal
				+ ", breed=" + breed + ", appointment=" + appointment + "]";
	}

}
