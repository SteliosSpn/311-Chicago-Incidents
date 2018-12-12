package com.chicago.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chicago.models.SanitationCodeComplaint;

public interface SanitationCodeRepository extends JpaRepository<SanitationCodeComplaint, Integer>{

}
