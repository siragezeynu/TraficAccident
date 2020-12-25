package com.restapi1.demo.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.restapi1.demo.Exception.VehicleNotFoundException;
import com.restapi1.demo.dto.VehicleDto;
import com.restapi1.demo.model.Accident;
import com.restapi1.demo.model.Vehicle;
import com.restapi1.demo.repository.AccidentRepository;
import com.restapi1.demo.repository.VehicleRepository;

@RestController
public class VehicleController {
	@Autowired
VehicleRepository vehicleRepo;
	@Autowired
	AccidentRepository accidentRepo;
@GetMapping("/GetAllvehicles")
public List<Vehicle> getAllVehicles(){
	return this.vehicleRepo.findAll();
}
@PostMapping("/Postvehicles/{accidentId}")
public ResponseEntity<Object> saveVehicles(@PathVariable Long accidentId,@RequestBody VehicleDto vehicleDto) {
	//create a user entity object
	Accident accident = this.accidentRepo.findById(accidentId).orElse(null);
	Vehicle vehicle = new Vehicle();
	vehicle.setMake(vehicleDto.getMakeDto());
	vehicle.setColor(vehicleDto.getColorDto());
	vehicle.setModle(vehicleDto.getModleDto());
vehicle.setVehicleidentification(vehicleDto.getVehicleIdentificationDto());
	vehicle.setAccident(accident);
		Vehicle SavedVehicle = this.vehicleRepo.save(vehicle);
		URI Location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(SavedVehicle.getId()).toUri();
	return ResponseEntity.created(Location).build();
}
@GetMapping("/GetOneVehicle{id}")
public Vehicle getOneVehicle(@PathVariable Long id) {
	Vehicle vehicle = this.vehicleRepo.findById(id).orElseThrow(()->
	new VehicleNotFoundException("Vehicle Not Found"));
			
	return vehicle;
}
@DeleteMapping("/DeleteVehicle/{id}")
public void DeleteOneVehicle(@PathVariable Long id) {
	this.vehicleRepo.findById(id);
}
@PutMapping("/EditOneVehicle{id}")
public void EditOneVehicle(@PathVariable Long id,@RequestBody VehicleDto vehicledto) {
	Vehicle vehicle = this.vehicleRepo.findById(id).orElse(null);
	vehicle.setMake(vehicledto.getMakeDto());
	vehicle.setColor(vehicledto.getColorDto());
	vehicle.setModle(vehicledto.getModleDto());
	vehicle.setVehicleidentification(vehicledto.getVehicleIdentificationDto());
}
}
