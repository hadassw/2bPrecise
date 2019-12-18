package com.exercise.hadas.web.models;

import java.util.List;

public class EmployeeDto {

	private int id;
	private String firstName;
	private String lastName;
	private String position;
	private EmployeeDto manager;
	private List<EmployeeDto> subordinates;
	private List<ReportDto> reports;
	private List<TaskDto> tasks;

	public EmployeeDto() {

	}

	public EmployeeDto(String firstName, String lastName, String position, EmployeeDto manager) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.position = position;
		this.manager = manager;
	}

	public String getFirstName() {
		return firstName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public EmployeeDto getManager() {
		return manager;
	}

	public void setManager(EmployeeDto manager) {
		this.manager = manager;
	}

	public List<ReportDto> getReports() {
		return reports;
	}

	public void setReports(List<ReportDto> reports) {
		this.reports = reports;
	}

	public List<TaskDto> getTasks() {
		return tasks;
	}

	public void setTasks(List<TaskDto> tasks) {
		this.tasks = tasks;
	}

	public List<EmployeeDto> getSubordinates() {
		return subordinates;
	}

	public void setSubordinates(List<EmployeeDto> subordinates) {
		this.subordinates = subordinates;
	}
	
}
