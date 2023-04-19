package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.AppointmentDTO;



@RestController
public class RestAppointment {
	
	@PostMapping("/user/appointment")
	public ResponseEntity<?> insertAppointmentNew (@RequestBody AppointmentDTO appointment){
		return null;
	}
	
	
}
