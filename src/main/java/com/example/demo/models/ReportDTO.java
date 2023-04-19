package com.example.demo.models;

public class ReportDTO {
	private int id, idUser;
	private String description;

	public ReportDTO() {
		super();
	}

	public ReportDTO(int id, int idUser, String description) {
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

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
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
		return "ReportDTO [id=" + id + ", idUser=" + idUser + ", description=" + description + "]";
	}

}
