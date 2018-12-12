package com.chicago.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chicago.models.PotHolesReported;

public interface PotHolesRepository extends JpaRepository<PotHolesReported, Integer>{

}
