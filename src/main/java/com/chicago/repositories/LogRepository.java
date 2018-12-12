package com.chicago.repositories;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chicago.models.Log;

public interface LogRepository extends JpaRepository<Log, Timestamp>{
	List<Log> findByActivityLike(String activity); 
}
