package com.restapi1.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restapi1.demo.model.Accident;

public interface AccidentRepository extends JpaRepository<Accident, Long>{

}
