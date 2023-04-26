package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.PetDTO;
import com.example.demo.models.ReportDTO;
import com.example.demo.service.ReportService;

@RestController
@RequestMapping("/api")
public class RestReport {

	@Autowired
	@Qualifier("reportService")
	private ReportService reportService;

	// Lista todas los mensajes
	@GetMapping("/veterinary/reports")
	public ResponseEntity<?> getReports() {
		boolean exist = reportService.listAllReports() != null;
		if (exist) {
			List<ReportDTO> reports = reportService.listAllReports();
			return ResponseEntity.ok(reports);
		} else
			return ResponseEntity.noContent().build();
	}

	// Lista todas los mensajes de un user
	@GetMapping("/user/reports{idUser}")
	public ResponseEntity<?> getReportsUser(@PathVariable int idUser) {
		boolean exist = reportService.findReportByIdUser(idUser) != null;
		if (exist) {
			List<ReportDTO> pets = reportService.findReportByIdUser(idUser);
			return ResponseEntity.ok(pets);
		} else
			return ResponseEntity.noContent().build();
	}
	
	// Lista todas los mensajes de un veterinario
		@GetMapping("/user/reports{idVeterinary}")
		public ResponseEntity<?> getReportsVeterinary(@PathVariable int idVeterinary) {
			boolean exist = reportService.findReportByIdUser(idVeterinary) != null;
			if (exist) {
				List<ReportDTO> pets = reportService.findReportByIdUser(idVeterinary);
				return ResponseEntity.ok(pets);
			} else
				return ResponseEntity.noContent().build();
		}

	// Crea un mensaje
	@PostMapping("/veterinaty/report")
	public ResponseEntity<?> insertReportNew(@RequestBody ReportDTO reportDTO) {
		reportService.addReport(reportDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(reportDTO);
	}
}
