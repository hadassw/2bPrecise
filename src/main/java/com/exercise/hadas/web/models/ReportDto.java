package com.exercise.hadas.web.models;

import java.time.LocalDate;



public class ReportDto {

	
	private int id;	
	private String text;
	private LocalDate date;
	private EmployeeDto employee;
	
	public ReportDto() {
	
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Report [id=" + id + ", " + (text != null ? "text=" + text + ", " : "")
				+ (date != null ? "date=" + date : "") + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public EmployeeDto getEmployee() {
		return employee;
	}
	public void setEmployee(EmployeeDto employee) {
		this.employee = employee;
	}
	
	
	
}
