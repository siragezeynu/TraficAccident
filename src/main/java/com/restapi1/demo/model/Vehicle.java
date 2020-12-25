package com.restapi1.demo.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Vehicle {
	@Id
	@GeneratedValue
private Long id;
private String make;
private String color;
private String modle;
private String vehicleidentification;

@ManyToOne
@JoinColumn(name="accident_id",nullable=false)
private Accident accident;
@OneToMany(mappedBy = "vehicle")
private Set<Moterist> moterist;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getMake() {
	return make;
}
public void setMake(String make) {
	this.make = make;
}
public String getColor() {
	return color;
}
public void setColor(String color) {
	this.color = color;
}
public String getModle() {
	return modle;
}
public void setModle(String modle) {
	this.modle = modle;
}


public String getVehicleidentification() {
	return vehicleidentification;
}
public void setVehicleidentification(String vehicleidentification) {
	this.vehicleidentification = vehicleidentification;
}
public Accident getAccident() {
	return accident;
}
public void setAccident(Accident accident) {
	this.accident = accident;
}
public Set<Moterist> getMoterist() {
	return moterist;
}
public void setMoterist(Set<Moterist> moterist) {
	this.moterist = moterist;
}

}
