package com.exercise.hadas.web.models;

import java.time.LocalDate;

import com.exercise.hadas.domain.entities.Employee;



public class TaskDto {


	private int id;
	private String text;
	private LocalDate assDate;
	private LocalDate dueDate;
	private int employeeId;
	
	public TaskDto() {

	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public LocalDate getAssignDate() {
		return assDate;
	}

	public void setAssDate(LocalDate assDate) {
		this.assDate = assDate;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", " + (text != null ? "text=" + text + ", " : "")
				+ (assDate != null ? "assDate=" + assDate + ", " : "") + (dueDate != null ? "dueDate=" + dueDate : "")
				+ "]";
	}

}
