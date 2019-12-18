package com.exercise.hadas.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.exercise.hadas.domain.entities.Task;

@Repository
public interface TaskRepository  extends JpaRepository<Task,Integer>{


	
}
