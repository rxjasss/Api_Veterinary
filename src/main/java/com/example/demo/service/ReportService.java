package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Report;
import com.example.demo.models.ReportDTO;


public interface ReportService {
	public abstract ReportDTO addReport(ReportDTO reportDTO);
	public abstract List<ReportDTO> listAllReports();
	public abstract Report findReportById(int id);
	public abstract List<ReportDTO> findReportByIdUser(int idUser);
	public abstract boolean removeAppointment(int id);
	public abstract Report transform(ReportDTO reportDTO);
	public abstract ReportDTO transform(Report report);
}
