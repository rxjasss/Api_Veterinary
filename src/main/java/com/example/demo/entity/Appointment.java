package com.example.demo.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Appointment {
	@Id
	@GeneratedValue
	private int id;

	@OneToOne
	@JoinColumn(name = "idPet")
	private Pet idPet;

	@ManyToOne
	@JoinColumn(name = "idVeterinary")
	private User idVeterinary;

	private String hour;
	private Date date;

	public Appointment() {
		super();
	}

	public Appointment(int id, Pet idPet, User idVeterinary, String hour, Date date) {
		super();
		this.id = id;
		this.idPet = idPet;
		this.idVeterinary = idVeterinary;
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

	public User getIdVeterinary() {
		return idVeterinary;
	}

	public void setIdVeterinary(User idVeterinary) {
		this.idVeterinary = idVeterinary;
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
		return "Appointment [id=" + id + ", idPet=" + idPet + ", idVeterinary=" + idVeterinary + ", hour=" + hour
				+ ", date=" + date + "]";
	}

}
