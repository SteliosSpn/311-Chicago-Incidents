package com.chicago.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chicago.models.Log;
import com.chicago.models.user.managment.User;

public interface UserRepository  extends JpaRepository<User, String> {

	List<User> findByNameLike(String name); 

}
