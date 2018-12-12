package com.chicago.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chicago.models.AbandonedVehicles;

public interface AbandonedVehicleRepository extends JpaRepository<AbandonedVehicles, Integer>{

}
