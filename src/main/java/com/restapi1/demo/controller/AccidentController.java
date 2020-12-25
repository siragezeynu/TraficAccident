package com.restapi1.demo.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import com.restapi1.demo.Exception.AccidentNotFoundException;
import com.restapi1.demo.dto.AccidentDto;
import com.restapi1.demo.model.Accident;
import com.restapi1.demo.repository.AccidentRepository;

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

@RestController
public class AccidentController {
	@Autowired
	AccidentRepository accidentRepo;
	@GetMapping("/GetAllaccidents")
	public List<Accident> getAccidents(){
		return this.accidentRepo.findAll();
		
	}
	@PostMapping("/Postaccidents")
	
    public ResponseEntity<Object> addAccident(@Valid @RequestBody Accident accident)
	{
 
    	Accident savedAccident = this.accidentRepo.save(accident);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedAccident.getId()).toUri();
        return ResponseEntity.created(location).build();

	}
	@GetMapping("/getaccidentById/{accidentId}")
	public Accident getaccidentById(@PathVariable Long accidentId) {
/*
		Accident accident = this.accRepo.findById(accidentId).orElseThrow(()->
		new RuntimeException("Resource not found") );
*/
		Accident accident = this.accidentRepo.findById(accidentId).orElseThrow(()->
		new AccidentNotFoundException("Resource not found") );
		return accident;
		
	}
@DeleteMapping("/DeleteOneAccident/{id}")
public void DeleteOneAccident(@PathVariable Long id) {
	this.accidentRepo.findById(id);
}
@PutMapping("/EditOneAccident/{id}")
public void PutOneAccident(@PathVariable Long id,@RequestBody AccidentDto accidentdto) {
	Accident accident= this.accidentRepo.findById(id).orElse(null);
	accident.setAddress(accidentdto.getAddressDto());
}
}
