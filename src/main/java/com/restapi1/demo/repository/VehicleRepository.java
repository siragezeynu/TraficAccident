package com.restapi1.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restapi1.demo.model.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long>{

}
