package com.chicago.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chicago.models.user.managment.Task;
import com.chicago.models.user.managment.User;

public interface TaskRepository  extends JpaRepository<Task, Long>{

	List<Task> findByUser(User user); 
	
}
