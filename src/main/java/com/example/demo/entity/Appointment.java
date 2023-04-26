package com.example.demo.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Appointment {
	@Id
	@GeneratedValue
	private int id;

	@ManyToOne
	@JoinColumn(name = "idPet")
	private Pet idPet;

	@ManyToOne
	@JoinColumn(name = "idUser")
	private User idUser;

	private String hour;
	private Date date;

	public Appointment() {
		super();
	}

	public Appointment(int id, Pet idPet, User idUser, String hour, Date date) {
		super();
		this.id = id;
		this.idPet = idPet;
		this.idUser = idUser;
		this.hour = hour;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Pet getIdPet() {
		return idPet;
	}

	public void setIdPet(Pet idPet) {
		this.idPet = idPet;
	}

	public User getIdUser() {
		return idUser;
	}

	public void setIdUser(User idUser) {
		this.idUser = idUser;
	}

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Appointment [id=" + id + ", idPet=" + idPet + ", idUser=" + idUser + ", hour=" + hour + ", date=" + date
				+ "]";
	}

}
