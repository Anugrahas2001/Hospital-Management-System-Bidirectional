package com.hospital_app_bi.Dao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.hospital_app.Dto.Branch;
import com.hospital_app.Dto.Hospital;
import com.hospital_app_bi.Helper.HospitalHelper;

public class HospitalDao {
	static Scanner s = new Scanner(System.in);

	static EntityManagerFactory enityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	static EntityManager enitityManager = enityManagerFactory.createEntityManager();
	static EntityTransaction entityTransaction = enitityManager.getTransaction();
	static Hospital hospital = new Hospital();

	public static void hospitalOperations() {
		System.out.println(
				"1.Add a new Hospital.\n2.Updadate Hospital Datas.\n3.Fetch datas of the Hospital.\n4.Remove Hospital");
		System.out.println("Enter your wish: ");
		int choice = s.nextInt();

		switch (choice) {
		case 1: {
			// insert a hospital
			Hospital hospitalData = HospitalHelper.readHospital();
			Hospital Hospitals = saveHospitalData(hospitalData);
		}
			break;
		case 2: {
			// Update

			System.out.println("what you want to update: ");
			System.out.println("1.Name.\n2.Email.\n3.Type");
			System.out.println("Enter your wish: ");
			int wish = s.nextInt();
			switch (wish) {
			case 1: {
				// based on the name
				returnHospitalIds();
				Hospital hospital = updateHospitalName();
			}
				break;
			case 2: {
				// update baded on the Email
				returnHospitalIds();
				Hospital hospital = updateHospitalEmail();
			}
				break;
			case 3: {
				// update based on the type
				returnHospitalIds();
				Hospital hospital = updateHospitalType();
			}
				break;
			default: {
				System.out.println("Sorryyy...............");
			}
			}
		}
			break;
		case 3: {
			// fetch hospital data

			Query q = enitityManager.createQuery("Select h from Hospital h");
			List<Hospital> hospitals = q.getResultList();
			for (Hospital Hospitals : hospitals) {
				System.out.println("Hospital Name is: " + Hospitals.getName());
				System.out.println("Hospital Email is: " + Hospitals.getEmail());
				System.out.println("Hospital PhoneNumber is: " + Hospitals.getPhone());
				System.out.println("Hospital Type is: " + Hospitals.getType());
			}
		}
			break;
		case 4: {
			returnHospitalIds();
			System.out.println("enter the id you want to remove: ");
			int id = s.nextInt();
			Hospital hospitalDelete = enitityManager.find(Hospital.class, id);
			entityTransaction.begin();
			enitityManager.remove(hospitalDelete);
			entityTransaction.commit();
		}
			break;
		default: {
			System.out.println("Enter valid Option.");
		}
		}

	}

	// save Hospital
	public static Hospital saveHospitalData(Hospital hospital) {
		entityTransaction.begin();
		enitityManager.persist(hospital);
		entityTransaction.commit();
		System.out.println("Data Saved Successfully...");
		return hospital;
	}

	// update Hospital based on name
	public static Hospital updateHospitalName() {
		System.out.println("Enter your id: ");
		int id = s.nextInt();
		Hospital hospital = enitityManager.find(Hospital.class, id);

		if (hospital != null) {
			System.out.println("Enter the name: ");
			String hospitalName = s.next();
			hospital.setName(hospitalName);

			entityTransaction.begin();
			enitityManager.merge(hospital);
			entityTransaction.commit(); // Commit the transaction after merging changes
		} else {
			System.out.println("Hospital not found with the given id.");
		}

		return hospital;
	}

	// update Hospital based on Email

	public static Hospital updateHospitalEmail() {
		System.out.println("Enter your id: ");
		int id = s.nextInt();
		Hospital hospital = enitityManager.find(Hospital.class, id);

		if (hospital != null) {
			System.out.println("Enter the email: ");
			String hospitalEmail = s.next();
			hospital.setEmail(hospitalEmail);

			entityTransaction.begin();
			enitityManager.merge(hospital);
			entityTransaction.commit(); // Commit the transaction after merging changes
		} else {
			System.out.println("Hospital not found with the given id.");
		}

		return hospital;
	}

	public static Hospital updateHospitalType() {
		System.out.println("Enter your id: ");
		int id = s.nextInt();
		Hospital hospital = enitityManager.find(Hospital.class, id);

		if (hospital != null) {
			System.out.println("Enter the Type: ");
			String hospitalType = s.next();
			hospital.setType(hospitalType);

			entityTransaction.begin();
			enitityManager.merge(hospital);
			entityTransaction.commit(); // Commit the transaction after merging changes
		} else {
			System.out.println("Hospital not found with the given id.");
		}

		return hospital;
	}

	// hospital ids
	public static void returnHospitalIds() {
		Query q = enitityManager.createQuery("Select id from Hospital h");
		List<Integer> id = q.getResultList();
		for (int HospitalId : id) {
			System.out.println(" Hospital id: " + HospitalId);
		}

	}

}
