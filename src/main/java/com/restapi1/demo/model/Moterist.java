package com.restapi1.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Moterist {
	@Id
	@GeneratedValue
private Long id;
private String fname;
private String lname;
private String driverlicense;
private int age;
@ManyToOne
@JsonIgnore

private Vehicle vehicle;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getFname() {
	return fname;
}
public void setFname(String fname) {
	this.fname = fname;
}
public String getLname() {
	return lname;
}
public void setLname(String lname) {
	this.lname = lname;
}
public String getDriverlicense() {
	return driverlicense;
}
public void setDriverlicense(String driverlicense) {
	this.driverlicense = driverlicense;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public Vehicle getVehicle() {
	return vehicle;
}
public void setVehicle(Vehicle vehicle) {
	this.vehicle = vehicle;
}

}
