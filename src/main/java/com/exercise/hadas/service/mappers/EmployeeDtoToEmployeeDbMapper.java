package com.exercise.hadas.service.mappers;

import org.springframework.stereotype.Component;

import com.exercise.hadas.domain.entities.Employee;
import com.exercise.hadas.domain.entities.Task;
import com.exercise.hadas.web.models.EmployeeDto;
import com.exercise.hadas.web.models.TaskDto;

@Component
public class EmployeeDtoToEmployeeDbMapper {

	public Employee mapEmployeeDtoToEmployee(EmployeeDto employeeDto)
	{
		Employee employee = mapBasicEmployeeAttributes(employeeDto);
		
		if(employeeDto.getManager() != null)
		{
			employee.setManager(mapBasicEmployeeAttributes(employeeDto.getManager()));
		}
		
		return employee;
	}
	
	private Employee mapBasicEmployeeAttributes(EmployeeDto employee) {
		Employee employeeDb = new Employee();
	
		employeeDb.setFirstName(employee.getFirstName());
		employeeDb.setLastName(employee.getLastName());
		employeeDb.setPosition(employee.getPosition());
		
		
		return employeeDb;
	}
	public Task mapTaskDtoToTask(TaskDto taskDto)
	{
		Task task = new Task();
		task.setText(taskDto.getText());
		task.setAssignDate(taskDto.getAssignDate());
		task.setDueDate(taskDto.getDueDate());
		return task;
	}
	


}
