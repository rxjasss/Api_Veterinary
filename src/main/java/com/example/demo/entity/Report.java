package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Report {
	@Id
	@GeneratedValue
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "idUser")
	private User idUser;
	
	@ManyToOne
	@JoinColumn(name = "idVeterinary")
	private User idVeterinary;
	
	private String description;
	
	public Report() {
		super();
	}

	public Report(int id, User idUser, String description) {
		super();
		this.id = id;
		this.idUser = idUser;
		this.description = description;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Report [id=" + id + ", idUser=" + idUser + ", description=" + description + "]";
	}
	
	
}
