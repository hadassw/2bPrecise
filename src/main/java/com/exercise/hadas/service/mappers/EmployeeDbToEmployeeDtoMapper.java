package com.exercise.hadas.service.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.exercise.hadas.domain.entities.Employee;
import com.exercise.hadas.domain.entities.Report;
import com.exercise.hadas.domain.entities.Task;
import com.exercise.hadas.web.models.EmployeeDto;
import com.exercise.hadas.web.models.ReportDto;
import com.exercise.hadas.web.models.TaskDto;

@Component
public class EmployeeDbToEmployeeDtoMapper {

	public EmployeeDto mapEmployeeToEmployeeDto(Employee employee)
	{
		EmployeeDto employeeDto = mapBasicEmployeeAttributes(employee);
		employeeDto.setSubordinates(mapSubordinates(employee.getSubordinates()));
		
		if(employee.getManager() != null)
		{
			employeeDto.setManager(mapBasicEmployeeAttributes(employee.getManager()));
		}
		
		return employeeDto;
	}

	private EmployeeDto mapBasicEmployeeAttributes(Employee employee) {
		EmployeeDto employeeDto = new EmployeeDto();
		employeeDto.setId(employee.getId());
		employeeDto.setFirstName(employee.getFirstName());
		employeeDto.setLastName(employee.getLastName());
		employeeDto.setPosition(employee.getPosition());
		employeeDto.setTasks(mapTasksToTasksBasicDto(employee.getTasks()));
		employeeDto.setReports(mapReportToReportDto(employee.getReports()));
		return employeeDto;
	}

	private List<EmployeeDto> mapSubordinates(List<Employee> subordinates) {
		List<EmployeeDto> employeesDto = null;
		
		if(subordinates != null)
		{
			employeesDto = subordinates.stream().map(this::mapBasicEmployeeAttributes).collect(Collectors.toList());
		}
		
		return employeesDto;
	}

	public List<TaskDto> mapTasksToTasksBasicDto(List<Task> tasks) {
		
		List<TaskDto> tasksDto = null;
		if(tasks != null)
		{
			tasksDto = tasks.stream().map(this::mapTasksToTasksBasicDto).collect(Collectors.toList());
		}
		return tasksDto;
	}
	
	private TaskDto mapTasksToTasksBasicDto(Task task)
	{
		TaskDto taskDto = new TaskDto();
		taskDto.setText(task.getText());
		taskDto.setAssDate(task.getAssDate());
		taskDto.setDueDate(task.getDueDate());
		return taskDto;
	}
	private TaskDto mapTasksToTasksDto(Task task)
	{
		TaskDto taskDto = mapTasksToTasksBasicDto(task);
		taskDto.setId(task.getId());
		taskDto.setEmployeeId(task.getEmployeeId());
		return taskDto;
	}
	private List<ReportDto> mapReportToReportDto(List<Report> report) {
		
		List<ReportDto> reportDto = null;
		if(report != null)
		{
			reportDto = report.stream().map(this::mapReportToReportDto).collect(Collectors.toList());
		}
		return reportDto;
	}
	
	private ReportDto mapReportToReportDto(Report report)
	{
		ReportDto reportDto = new ReportDto();
		reportDto.setText(report.getText());
		reportDto.setDate(report.getDate());
		return reportDto;
	}

	public List<TaskDto> mapTasksToTasksDto(List<Task> tasks) {
		List<TaskDto> tasksDto = null;
		if(tasks != null)
		{
			tasksDto = tasks.stream().map(this::mapTasksToTasksDto).collect(Collectors.toList());
		}
		return tasksDto;
	}
}
