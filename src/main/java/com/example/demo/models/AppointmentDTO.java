package com.example.demo.models;

import java.util.Date;

public class AppointmentDTO {
	private int id, idPet, idUser;
	private String hour;
	private Date date;

	public AppointmentDTO() {
		super();
	}

	public AppointmentDTO(int id, int idPet, int idUser, String hour, Date date) {
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

	public int getIdPet() {
		return idPet;
	}

	public void setIdPet(int idPet) {
		this.idPet = idPet;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
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
		return "AppointmentDTO [id=" + id + ", idPet=" + idPet + ", idUser=" + idUser + ", hour=" + hour + ", date="
				+ date + "]";
	}

	

}
