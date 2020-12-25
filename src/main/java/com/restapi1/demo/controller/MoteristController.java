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

import com.restapi1.demo.Exception.MoteristNotFoundException;
import com.restapi1.demo.dto.AccidentDto;
import com.restapi1.demo.dto.MoteristDto;
import com.restapi1.demo.model.Accident;
import com.restapi1.demo.model.Moterist;
import com.restapi1.demo.model.Vehicle;
import com.restapi1.demo.repository.MoteristRepository;
import com.restapi1.demo.repository.VehicleRepository;

@RestController
public class MoteristController {
@Autowired
MoteristRepository moteristRepo;
@Autowired
VehicleRepository vehicleRepo;
@GetMapping("/GetAllmoterists")
public List<Moterist> getAllMoterists(){
	return this.moteristRepo.findAll();
}
@GetMapping("/GetOneMoterist{id}")
public Moterist getOneMoterist(@PathVariable Long id)
{
	Moterist moterist=this.moteristRepo.findById(id).orElseThrow(()->
	new MoteristNotFoundException("Moterist Not Found"));
	return moterist;
	
}
@PostMapping("/Postmoterist/{Vid}")
public ResponseEntity<Object> creatMoterist(@PathVariable Long Vid,@RequestBody MoteristDto moteristdto) {
	//create a user entity object
	Vehicle vehicle = this.vehicleRepo.findById(Vid).orElse(null);
	Moterist moterist = new Moterist();
	moterist.setAge(moteristdto.getAge());
	moterist.setDriverlicense(moteristdto.getDriverlicenseDto());
	moterist.setFname(moteristdto.getFnameDto());
	moterist.setLname(moteristdto.getLnameDto());
	moterist.setVehicle(vehicle);
Moterist savedMoterist = this.moteristRepo.save(moterist);
URI Location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedMoterist.getId()).toUri();
	return ResponseEntity.created(Location).build();
				}
@DeleteMapping("/DeleteMoterists{id}")
public void DeleteOneMoterist(@PathVariable Long id) {
	this.moteristRepo.findById(id);
}
@PutMapping("/EditMoterist{id}")
public void PutOneMoterist(@PathVariable Long id,@RequestBody MoteristDto moteristdto) {
	Moterist moterist= this.moteristRepo.findById(id).orElse(null);
	moterist.setFname(moteristdto.getFnameDto());
	moterist.setLname(moteristdto.getLnameDto());
	moterist.setDriverlicense(moteristdto.getDriverlicenseDto());
	moterist.setAge(moteristdto.getAge());
}
}
