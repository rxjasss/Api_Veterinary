package com.example.demo.models;

import java.util.Date;

public class AppointmentDTO {
	private int id, iPet, idVeterinary;
	private String hour;
	private Date date;

	public AppointmentDTO() {
		super();
	}

	public AppointmentDTO(int id, int iPet, int idVeterinary, String hour, Date date) {
		super();
		this.id = id;
		this.iPet = iPet;
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

	public int getiPet() {
		return iPet;
	}

	public void setiPet(int iPet) {
		this.iPet = iPet;
	}

	public int getIdVeterinary() {
		return idVeterinary;
	}

	public void setIdVeterinary(int idVeterinary) {
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
		return "AppointmentDTO [id=" + id + ", iPet=" + iPet + ", idVeterinary=" + idVeterinary + ", hour=" + hour
				+ ", date=" + date + "]";
	}

}
