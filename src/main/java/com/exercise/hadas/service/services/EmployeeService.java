package com.exercise.hadas.service.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercise.hadas.domain.entities.Employee;
import com.exercise.hadas.domain.entities.EmployeeType;
import com.exercise.hadas.domain.entities.Task;
import com.exercise.hadas.domain.repositories.EmployeeRepository;
import com.exercise.hadas.service.mappers.EmployeeDbToEmployeeDtoMapper;
import com.exercise.hadas.service.mappers.EmployeeDtoToEmployeeDbMapper;
import com.exercise.hadas.web.models.EmployeeDto;
import com.exercise.hadas.web.models.TaskDto;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	EmployeeDbToEmployeeDtoMapper employeeDtoMapper;
	
	@Autowired
	EmployeeDtoToEmployeeDbMapper employeeDbMapper;
	
	public Optional<EmployeeDto> findByIdAndEmployeeType(Integer id,EmployeeType type)
	{
		Optional<Employee> employeeOptional = employeeRepository.findByIdAndEmployeeType(id,type);
		return employeeOptional.map(employeeDtoMapper::mapEmployeeToEmployeeDto);
	}

	public void createEmployee(Optional<EmployeeDto>  employeeDto) {
		Optional<Employee> employeeDB = employeeDto.map(employeeDbMapper::mapEmployeeDtoToEmployee);
		employeeDB.get().setEmployeeType(EmployeeType.EMPLOYEE);
		employeeRepository.save(employeeDB.get());
	}
	public void createManager(Optional<EmployeeDto>  employeeDto) {
		Optional<Employee> employeeDB = employeeDto.map(employeeDbMapper::mapEmployeeDtoToEmployee);
		employeeDB.get().setEmployeeType(EmployeeType.MANAGER);
		employeeRepository.save(employeeDB.get());
	}



	public void assignEmployeeToManager(int managerId, int employeeId) {
		Employee employeeOptional = employeeRepository.findById(employeeId).get();
		Employee managerOptional = employeeRepository.findById(managerId).get();
		managerOptional.getSubordinates().add(employeeOptional);
		if(employeeOptional.getManager()!=null)
		{
			Optional<Employee> prevManager =employeeRepository.findById(employeeOptional.getManager().getId());
			prevManager.get().setNumOfEmployees(prevManager.get().getNumOfEmployees()-1);
			employeeRepository.save(prevManager.get());
			
		}
		managerOptional.setNumOfEmployees(managerOptional.getNumOfEmployees()+1);
		employeeRepository.save(managerOptional);
		
	}



	public List<EmployeeDto> getEmployees() {
		return employeeRepository.findAll().stream().
		 map(employeeDtoMapper::mapEmployeeToEmployeeDto).collect(Collectors.toList());
		
	}

	public List<EmployeeDto> getManagers() {
		return employeeRepository.findByEmployeeType(EmployeeType.MANAGER).stream().
				 map(employeeDtoMapper::mapEmployeeToEmployeeDto).collect(Collectors.toList());
	}

	public List<EmployeeDto> getVeryBigTeam() {
		Float avarage = employeeRepository.getAvarage();
		return	employeeRepository.findByNumOfEmployeesGreaterThan(avarage.intValue()).stream().
		 map(employeeDtoMapper::mapEmployeeToEmployeeDto).collect(Collectors.toList());
		
	}

	public Optional<EmployeeDto> getEmployeeById(Integer employeeId) {
		Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);
		return employeeOptional.map(employeeDtoMapper::mapEmployeeToEmployeeDto);
	}

	public void createTaskToEmployee(Optional<TaskDto> task, int employeeId) {
		Employee employeeOptional = employeeRepository.findById(employeeId).get();
		Task taskDb =task.map(employeeDbMapper::mapTaskDtoToTask).get();
		employeeOptional.getTasks().add(taskDb);
		employeeRepository.save(employeeOptional);
	}
}
