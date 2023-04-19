package com.example.demo.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Appointment;

@Repository("appointmentRepository")
public interface AppointmentRepository extends JpaRepository<Appointment, Serializable> {
	public abstract Appointment findById(int id);
	public abstract List<Appointment> findByIdVeterinary(int idVeterinary);
}
