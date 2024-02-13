package com.hospital_app.Dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int itemId;
	private String medName;
	private String medType;
	@ManyToMany(mappedBy = "items")
	List<MedOrder> medorders;
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getMedName() {
		return medName;
	}
	public void setMedName(String medName) {
		this.medName = medName;
	}
	public String getMedType() {
		return medType;
	}
	public void setMedType(String medType) {
		this.medType = medType;
	}
	public List<MedOrder> getMedorders() {
		return medorders;
	}
	public void setMedorders(List<MedOrder> medorders) {
		this.medorders = medorders;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	private int price;
	private String description;
	
	

}
