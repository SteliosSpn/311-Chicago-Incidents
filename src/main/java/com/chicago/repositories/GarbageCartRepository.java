package com.chicago.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chicago.models.GarbageCart;

public interface GarbageCartRepository extends JpaRepository<GarbageCart, Integer>{

}
