package com.chicago.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.chicago.models.user.managment.Role;

public interface RoleRepository  extends JpaRepository<Role, String>{
 
}
