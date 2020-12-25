package com.restapi1.demo.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity

public class Accident {
	@Id
    @GeneratedValue
    private Long id;
    @NotNull
    @Size(min=2)
    @NotEmpty(message="address cannot be empty")
    private String address;
    @OneToMany(mappedBy="accident")
    @JsonIgnore
private Set<Vehicle> vehicle;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public Set<Vehicle> getVehicle() {
	return vehicle;
}
public void setVehicle(Set<Vehicle> vehicle) {
	this.vehicle = vehicle;
}

}
