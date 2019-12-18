package com.exercise.hadas.service.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercise.hadas.domain.entities.Task;

import com.exercise.hadas.domain.repositories.TaskRepository;
import com.exercise.hadas.service.mappers.EmployeeDbToEmployeeDtoMapper;
import com.exercise.hadas.service.mappers.EmployeeDtoToEmployeeDbMapper;
import com.exercise.hadas.web.models.TaskDto;

@Service
public class TaskService {

	@Autowired
	private TaskRepository taskRepository;
	
	@Autowired
	EmployeeDbToEmployeeDtoMapper employeeDtoMapper;
	
	@Autowired
	EmployeeDtoToEmployeeDbMapper employeeDbMapper;

	public List<TaskDto> getTask() {
		List<Task> tasks =  taskRepository.findAll();
		return employeeDtoMapper.mapTasksToTasksDto(tasks);
		
	}
	
	public  void createTask(TaskDto taskDto) {
		Task task = employeeDbMapper.mapTaskDtoToTask(taskDto);
		taskRepository.save(task);
		
	}
}
