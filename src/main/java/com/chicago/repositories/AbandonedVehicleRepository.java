package com.chicago.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chicago.models.AbandonedVehicles;
import com.chicago.models.AllReports;

public interface AbandonedVehicleRepository extends JpaRepository<AbandonedVehicles, Integer>{

}
