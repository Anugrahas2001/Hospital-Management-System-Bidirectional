package com.hospital_app.Dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Branch {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int branchId;
	private String name;
	private int noOfDocters;
	private int noOfBeds;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "my_address_id")
	private Address address;
	
	@ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
	@JoinColumn(name = "my_hospital_id")
	private Hospital hospital;
	
	@OneToMany(mappedBy = "branch",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Encounter> encounters;
	public int getBranchId() {
		return branchId;
	}
	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNoOfDocters() {
		return noOfDocters;
	}
	public void setNoOfDocters(int noOfDocters) {
		this.noOfDocters = noOfDocters;
	}
	public int getNoOfBeds() {
		return noOfBeds;
	}
	public void setNoOfBeds(int noOfBeds) {
		this.noOfBeds = noOfBeds;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Hospital getHospital() {
		return hospital;
	}
	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}
	public List<Encounter> getEncounters() {
		return encounters;
	}
	public void setEncounters(List<Encounter> encounters) {
		this.encounters = encounters;
	}



}
