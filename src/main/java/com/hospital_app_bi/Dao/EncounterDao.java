package com.hospital_app_bi.Dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.hospital_app.Dto.Branch;
import com.hospital_app.Dto.Encounter;
import com.hospital_app.Dto.Hospital;
import com.hospital_app.Dto.Person;
import com.hospital_app_bi.Helper.BranchHelper;
import com.hospital_app_bi.Helper.EncounterHelper;
import com.hospital_app_bi.Helper.HospitalHelper;
import com.hospital_app_bi.Helper.PersonHelper;

public class EncounterDao {
	static EntityManagerFactory enityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	static EntityManager enitityManager = enityManagerFactory.createEntityManager();
	static EntityTransaction entityTransaction = enitityManager.getTransaction();
	static Scanner s = new Scanner(System.in);
	static Encounter encounter = new Encounter();

	public static void encounterOperations() {
		System.out.println("1.Add Encounter.\n2.Update Encounter.\n3.Fetch Encounter.\n4.Remove Encounter.");
		System.out.println("Enter Your choice: ");
		int choice = s.nextInt();

		switch (choice) {
		case 1: {
			Encounter encounter = saveEncounter();
		}
			break;
		case 2: {
			// Update Encounter
			System.out.println("What do you want to update?");
			System.out.println("1.Disease Name.\n2.Doctor Name");
			System.out.println("Enter your wish: ");
			int wish = s.nextInt();
			switch (wish) {
			case 1: {
				returnEncounterIds();
				updateDiseaseNameBasedOnEncounterId();
			}
				break;
			case 2: {
				returnEncounterIds();
				updateDocotorNameBasedOnEncounter();
			}
				break;
			default: {
				System.out.println("Sorry...please enter avlid number.");
			}
			}
		}
			break;
		case 3: {
			// Fetch Encounter datas
			fetchEncounterData();
		}
			break;
		case 4: {
			// Remove Encounter
			removeEncounterData();
		}
			break;
		default:
			System.out.println("Enter valid Number.");
		}
	}

	// Save Encounter
	public static Encounter saveEncounter() {
		BranchDao.returnBranchId();
		System.out.println("Enter BranchId: ");
		int branchId = s.nextInt();

		Branch branch = enitityManager.find(Branch.class, branchId);

		PersonDao.returnPersonIds();
		System.out.println("Enter PersonId: ");
		int personId = s.nextInt();
		Person person = enitityManager.find(Person.class, personId);

		if (branch != null) {
			if (person != null) {
				Encounter encounter = EncounterHelper.readEncounter();
				encounter.setBranch(branch);

				entityTransaction.begin();
				enitityManager.persist(encounter);
				entityTransaction.commit();

				System.out.println("Encounter added successfully");
				return encounter; // Return the saved encounter.

			} else {
				System.out.println("Person with this id does not exist. Please add a new Person.");

				Person personData = PersonHelper.readPerson();
				Person persons = PersonDao.savePerson(personData);
				System.out.println("New Person added successfully...");
			}
		} else {
			System.out.println("Branch with this id does not exist. Please add a new Branch.");
		}

		// You might want to return something here or handle it as needed.
		return null;
	}

	// update disease based on Encounter Id

	public static Encounter updateDiseaseNameBasedOnEncounterId() {
		System.out.println("Select one id from this.");
		int encounterId = s.nextInt();
		Encounter encounter = enitityManager.find(Encounter.class, encounterId);
		if (encounter != null) {
			System.out.println("Enter the updated name of the disease.");
			String diseaseName = s.next();
			encounter.setDisease(diseaseName);

			entityTransaction.begin();
			enitityManager.merge(encounter);
			entityTransaction.commit(); // Commit the transaction after merging changes
		} else {
			System.out.println("Encounter not found with the given id.");
		}
		return encounter;

	}

	// update Doctor name based on EncounterId

	public static Encounter updateDocotorNameBasedOnEncounter() {
		System.out.println("Select one id from this.");
		int encounterId = s.nextInt();

		Encounter encounter = enitityManager.find(Encounter.class,encounterId);

		if (encounter != null) {
			System.out.println("Enter the updated new Docter name.");
			String docterName = s.next();

			encounter.setDocterName(docterName);

			entityTransaction.begin();
			enitityManager.merge(encounter);
			entityTransaction.commit(); // Commit the transaction after merging changes
		} else {
			System.out.println("Person not found with the given id.");
		}
		return encounter;
	}

	// Fetch Encounter data

	public static Encounter fetchEncounterData() {
		Query q = enitityManager.createQuery("Select e from Encounter e");
		List<Encounter> encounters = q.getResultList();
		for (Encounter encountrs : encounters) {
			System.out.println("Disease: " + encountrs.getDisease());
			System.out.println("Admit Date: " + encountrs.getAdmitDate());
			System.out.println("Discharge Date: " + encountrs.getDischargeDate());
			System.out.println("Docter Name: " + encountrs.getDocterName());
			System.out.println("*****************************************");
			System.out.println("data retrived successfully...");
		}
		return encounter;
	}

	// Remove Encounter
	public static void removeEncounterData() {
		returnEncounterIds();
		System.out.println("enter the id you want to remove: ");
		int id = s.nextInt();
		Encounter encounterDelete = enitityManager.find(Encounter.class, id);
		entityTransaction.begin();
		enitityManager.remove(encounterDelete);
		entityTransaction.commit();
		System.out.println("Successfully Removed...");
	}

	// Return encounter ids
	public static void returnEncounterIds() {
		Query q = enitityManager.createQuery("Select id from Encounter e");
		List<Integer> id = q.getResultList();
		for (int EncounterId : id) {
			System.out.println("Encounter id: " + EncounterId);
		}

	}
}
