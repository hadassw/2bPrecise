package com.exercise.hadas.domain.repositories;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.exercise.hadas.domain.entities.Employee;
import com.exercise.hadas.domain.entities.EmployeeType;
import com.exercise.hadas.web.models.EmployeeDto;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer>{
	 

	public List<Employee> findByEmployeeType(EmployeeType employee);
	
	@Query("select sum(e.numOfEmployees)/count(*) from Employee e where e.employeeType=1")
	public Float getAvarage();


	public List<Employee> findByNumOfEmployeesGreaterThan(int i);

	public Optional<Employee> findByIdAndEmployeeType(Integer id, EmployeeType employee);

}
