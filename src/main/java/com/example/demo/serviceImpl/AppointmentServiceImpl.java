package com.example.demo.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Appointment;
import com.example.demo.entity.User;
import com.example.demo.models.AppointmentDTO;
import com.example.demo.repository.AppointmentRepository;
import com.example.demo.service.AppointmentService;

@Service("appointmentService")
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	@Qualifier("appointmentRepository")
	private AppointmentRepository appointmentRepository;
	
	@Autowired
	@Qualifier("userService")
	private UserService userService;

	@Override
	public AppointmentDTO addAppointment(AppointmentDTO appointmentDTO) {
		appointmentRepository.save(transform(appointmentDTO));
		return appointmentDTO;
	}

	@Override
	public List<AppointmentDTO> listAllAppointments() {
		return appointmentRepository.findAll().stream().map(c -> transform(c)).collect(Collectors.toList());
	}

	@Override
	public Appointment findAppointmentById(int id) {
		return appointmentRepository.findById(id);
	}

	@Override
	public List<AppointmentDTO> findAppointmentByIdVeterinary(int idVeterinary) {
		User u = userService.findUserId(idVeterinary);
		return appointmentRepository.findByIdVeterinary(u).stream().map(c -> transform(c))
				.collect(Collectors.toList());
	}

	@Override
	public boolean removeAppointment(int id) {
		if (appointmentRepository.findById(id) != null) {
			appointmentRepository.deleteById(id);
			return true;
		} else
			return false;
	}

	@Override
	public Appointment transform(AppointmentDTO appointmentDTO) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(appointmentDTO, Appointment.class);
	}

	@Override
	public AppointmentDTO transform(Appointment appointment) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(appointment, AppointmentDTO.class);
	}

}
