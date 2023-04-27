package com.example.demo.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Report;
import com.example.demo.entity.User;

@Repository("reportRepository")
public interface ReportRepository extends JpaRepository<Report, Serializable> {
	public abstract Report findById(int id);
	public abstract List<Report> findByIdUser(User user);
	public abstract List<Report> findByIdVeterinary(User veterinary);
}
