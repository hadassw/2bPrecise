package com.exercise.hadas.web.controllers;

import java.util.List;
import java.util.Optional;

import javax.swing.text.html.Option;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Optionals;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exercise.hadas.domain.entities.Employee;
import com.exercise.hadas.domain.entities.EmployeeType;
import com.exercise.hadas.service.services.EmployeeService;
import com.exercise.hadas.service.services.TaskService;
import com.exercise.hadas.web.models.EmployeeDto;
import com.exercise.hadas.web.models.TaskDto;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private TaskService taskService;

	@GetMapping("/employee/{employeeId}")
	public Optional<EmployeeDto> getEmployeeId(@PathVariable Integer employeeId) {
		return employeeService.getEmployeeById(employeeId);
	}
	@GetMapping("/manager/{managerId}")
	public Optional<EmployeeDto> getManagerId(@PathVariable Integer managerId) {
		return employeeService.findByIdAndEmployeeType(managerId,EmployeeType.MANAGER);
	}
	@GetMapping("/employee")
	public List<EmployeeDto> getEmployees() {
		return employeeService.getEmployees();
	}
	@GetMapping("/manager")
	public List<EmployeeDto> getManagers() {
		return employeeService.getManagers();
	}
	@PostMapping("/employee")
	public void createEmployee(@RequestBody EmployeeDto employee) {
	
		 employeeService.createEmployee(Optional.ofNullable(employee)) ;
		
	}
	@PostMapping("/manager")
	public void createManager(@RequestBody EmployeeDto employee) {
	
		 employeeService.createManager(Optional.ofNullable(employee)) ;
		
	}

	@PutMapping("/manager/{managerId}/assignEmployee/{employeeId}")
	public void assignEmployeeToManager(@PathVariable int managerId,@PathVariable int employeeId) {
	
		 employeeService.assignEmployeeToManager(managerId,employeeId) ;
		
	}
	@GetMapping("/veryBigTeam")
	public  List<EmployeeDto> getVeryBigTeam()
	{
		return employeeService.getVeryBigTeam();
	}
	
	@PostMapping("/employee/{employeeId}/createTask")
	public void createTaskToEmployee(@RequestBody TaskDto taskDto,@PathVariable int employeeId) {
	
		 employeeService.createTaskToEmployee(Optional.ofNullable(taskDto),employeeId) ;
		
	}
	@GetMapping("/task")
	public List<TaskDto> getTask() {	
		return taskService.getTask();		
	}
	
	@PostMapping("/task")
	public void createTask(@RequestBody TaskDto taskDto) {
	
		taskService.createTask(taskDto);
		
	}
}
