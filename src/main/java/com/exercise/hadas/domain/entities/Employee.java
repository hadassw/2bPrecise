package com.exercise.hadas.domain.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String firstName;
	private String lastName;
	private String position;

	private EmployeeType employeeType = EmployeeType.EMPLOYEE;

	@ManyToOne
	@JoinColumn(name = "manager_id", nullable = true)
	private Employee manager;

	@OneToMany(mappedBy = "manager")
	private List<Employee> subordinates = new ArrayList<Employee>();

	@OneToMany(cascade = CascadeType.ALL)
	private List<Report> reports = new ArrayList<Report>();

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "employee_id", nullable = true)
	private List<Task> tasks = new ArrayList<Task>();
	
	private int numOfEmployees;

	public Employee() {
	}

	public Employee(String firstName, String lastName, String position, EmployeeType employeeType, Employee manager) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.position = position;
		this.employeeType = employeeType;
		this.manager = manager;
	}

	public EmployeeType getEmployeeType() {
		return employeeType;
	}

	public void setEmployeeType(EmployeeType employeeType) {
		this.employeeType = employeeType;
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

	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}

	public List<Employee> getSubordinates() {
		return subordinates;
	}

	public void setSubordinates(List<Employee> subordinates) {
		this.subordinates = subordinates;
	}

	public List<Report> getReports() {
		return reports;
	}

	public void setReports(List<Report> reports) {
		this.reports = reports;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	
	public int getNumOfEmployees() {
		return numOfEmployees;
	}

	public void setNumOfEmployees(int numOfEmployees) {
		this.numOfEmployees = numOfEmployees;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", " + (firstName != null ? "firstName=" + firstName + ", " : "")
				+ (lastName != null ? "lastName=" + lastName + ", " : "")
				+ (position != null ? "position=" + position + ", " : "") + "type=" + employeeType + ", "
				+ (manager != null ? "manager=" + manager : "") + "]";
	}

}
