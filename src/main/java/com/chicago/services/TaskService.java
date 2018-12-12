package com.chicago.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chicago.models.user.managment.Task;
import com.chicago.models.user.managment.User;
import com.chicago.repositories.TaskRepository;

@Service
public class TaskService {
	
	@Autowired
	private TaskRepository taskRepository;
	
	public void addTask(Task task, User user) {
		task.setUser(user);
		taskRepository.save(task);
	}
	
	public List<Task>  findUserTask(User user){
		
		return taskRepository.findByUser(user);
	}

}
