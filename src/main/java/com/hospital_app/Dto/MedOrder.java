package com.hospital_app.Dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class MedOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int medId;
	private String dosage;
	private String quantity;
	private String orderDate;
	private String paymentMode;
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="encounterId")
	private Encounter encounter;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(joinColumns = @JoinColumn(name="medOrder_id"),inverseJoinColumns = @JoinColumn(name="item_id"))
	private List<Item> items;
	public int getMedId() {
		return medId;
	}
	public void setMedId(int medId) {
		this.medId = medId;
	}
	public String getDosage() {
		return dosage;
	}
	public void setDosage(String dosage) {
		this.dosage = dosage;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	public Encounter getEncounter() {
		return encounter;
	}
	public void setEncounter(Encounter encounter) {
		this.encounter = encounter;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}

}
