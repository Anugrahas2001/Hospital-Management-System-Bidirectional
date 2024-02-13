package com.hospital_app.Dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Encounter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int encounterId;
	private String disease;
	private String admitDate;
	private String dischargeDate;
	private String docterName;
	
	@OneToMany(mappedBy = "encounter",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<MedOrder> medOrders;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "my_person_id")
	private Person persons;
	
	@ManyToOne
	@JoinColumn(name="my_branch_id")
	private Branch branch;

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public int getEncounterId() {
		return encounterId;
	}

	public void setEncounterId(int encounterId) {
		this.encounterId = encounterId;
	}

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	public String getAdmitDate() {
		return admitDate;
	}

	public void setAdmitDate(String admitDate) {
		this.admitDate = admitDate;
	}

	public String getDischargeDate() {
		return dischargeDate;
	}

	public void setDischargeDate(String dischargeDate) {
		this.dischargeDate = dischargeDate;
	}

	public String getDocterName() {
		return docterName;
	}

	public void setDocterName(String docterName) {
		this.docterName = docterName;
	}

	public List<MedOrder> getMedOrders() {
		return medOrders;
	}

	public void setMedOrders(List<MedOrder> listMedOrder) {
		this.medOrders = (List<MedOrder>) listMedOrder;
	}

	public Person getPersons() {
		return persons;
	}

	public void setPersons(Person persons) {
		this.persons = persons;
	}
	

}
