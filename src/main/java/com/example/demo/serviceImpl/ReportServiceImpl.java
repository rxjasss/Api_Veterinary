package com.example.demo.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Report;
import com.example.demo.entity.User;
import com.example.demo.models.ReportDTO;
import com.example.demo.repository.ReportRepository;
import com.example.demo.service.ReportService;

@Service("reportService")
public class ReportServiceImpl implements ReportService {

	@Autowired
	@Qualifier("reportRepository")
	private ReportRepository reportRepository;
	
	@Autowired
	@Qualifier("userService")
	private UserService userService;

	@Override
	public ReportDTO addReport(ReportDTO reportDTO) {
		reportRepository.save(transform(reportDTO));
		return reportDTO;
	}

	@Override
	public List<ReportDTO> listAllReports() {
		return reportRepository.findAll().stream().map(c -> transform(c)).collect(Collectors.toList());
	}

	@Override
	public Report findReportById(int id) {
		return reportRepository.findById(id);
	}

	@Override
	public List<ReportDTO> findReportByIdUser(int idUser) {
		User u = userService.findUserId(idUser);
		return reportRepository.findByIdUser(u).stream().map(c -> transform(c))
				.collect(Collectors.toList());
	}

	@Override
	public Report transform(ReportDTO reportDTO) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(reportDTO, Report.class);
	}

	@Override
	public ReportDTO transform(Report report) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(report, ReportDTO.class);
	}

	@Override
	public List<ReportDTO> findReportByIdVeterinary(int idVeterinary) {
		User v = userService.findUserId(idVeterinary);
		return reportRepository.findByIdVeterinary(v).stream().map(c -> transform(c))
				.collect(Collectors.toList());
	}


}
