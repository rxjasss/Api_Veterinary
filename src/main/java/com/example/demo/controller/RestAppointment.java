package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.AppointmentDTO;
import com.example.demo.service.AppointmentService;

@RestController
@RequestMapping("/api")
public class RestAppointment {

	@Autowired
	@Qualifier("appointmentService")
	private AppointmentService appointmentService;

	// Lista todas las citas
	@GetMapping("/all/appointments")
	public ResponseEntity<?> getAppointments() {
		boolean exist = appointmentService.listAllAppointments() != null;
		if (exist) {
			List<AppointmentDTO> appointments = appointmentService.listAllAppointments();
			return ResponseEntity.ok(appointments);
		} else
			return ResponseEntity.noContent().build();
	}

	// Lista todas las citas de un veterinario
	@GetMapping("/veterinary/appointments/{idVeterinary}")
	public ResponseEntity<?> getAppointmentsVeterinary(@PathVariable int idVeterinary) {
		boolean exist = appointmentService.findAppointmentByIdVeterinary(idVeterinary) != null;
		if (exist) {
			List<AppointmentDTO> appointments = appointmentService.findAppointmentByIdVeterinary(idVeterinary);
			return ResponseEntity.ok(appointments);
		} else
			return ResponseEntity.noContent().build();
	}

	// Lista todas las citas de una mascota
	@GetMapping("/user/appointments/{idPet}")
	public ResponseEntity<?> getAppointmentPet(@PathVariable int idPet) {
		boolean exist = appointmentService.findAppointmentByIdPet(idPet) != null;
		if (exist) {
			List<AppointmentDTO> appointments = appointmentService.findAppointmentByIdPet(idPet);
			return ResponseEntity.ok(appointments);
		} else
			return ResponseEntity.noContent().build();
	}
	

	// Crea una cita
	@PostMapping("/user/appointment")
	public ResponseEntity<?> insertAppointmentNew(@RequestBody AppointmentDTO appointmentDTO) {
		appointmentService.addAppointment(appointmentDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(appointmentDTO);
	}

	// Elimina una cita
	@DeleteMapping("/all/appointment/{idAppointment}")
	public ResponseEntity<?> deleteAppointment(@PathVariable int idAppointment) {
		boolean exists = appointmentService.removeAppointment(idAppointment);
		if (exists)
			return ResponseEntity.ok().build();
		else
			return ResponseEntity.noContent().build();
	}

}
