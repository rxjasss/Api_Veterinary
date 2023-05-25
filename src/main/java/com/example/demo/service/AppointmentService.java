package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Appointment;
import com.example.demo.models.AppointmentDTO;


public interface AppointmentService {
	public abstract AppointmentDTO addAppointment(AppointmentDTO appointmentDTO);
	public abstract List<AppointmentDTO> listAllAppointments();
	public abstract Appointment findAppointmentById(int id);
	public abstract List<AppointmentDTO> findAppointmentByIdVeterinary(int idVeterinary);
	public abstract List<AppointmentDTO> findAppointmentByIdPet(int idPet);
	public abstract boolean removeAppointment(int id);
	public abstract Appointment transform(AppointmentDTO appointmentDTO);
	public abstract AppointmentDTO transform(Appointment appointment);
}
