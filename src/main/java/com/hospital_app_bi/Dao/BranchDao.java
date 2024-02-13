package com.hospital_app_bi.Dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.hospital_app.Dto.Address;
import com.hospital_app.Dto.Branch;
import com.hospital_app.Dto.Hospital;
import com.hospital_app_bi.Helper.BranchHelper;
import com.hospital_app_bi.Helper.HospitalHelper;

public class BranchDao {

	static EntityManagerFactory enityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	static EntityManager enitityManager = enityManagerFactory.createEntityManager();
	static EntityTransaction entityTransaction = enitityManager.getTransaction();
	static Scanner s = new Scanner(System.in);
	static Branch branch = new Branch();

	public static void branchOperations() {
		System.out.println("1.Add a new Branch.\n2.Updadate Address.\n3.Fetch datas of the Branch.\n4.Remove Branch");
		System.out.println("Enter your wish: ");
		int choice = s.nextInt();

		switch (choice) {
		case 1: {
			HospitalDao.returnHospitalIds();
			Branch branch = saveBranch();
		}
			break;
		case 2: {

			System.out.println("What do you want to update in the Address?");
			System.out.println("1.StreetName.\n2.City Name.\n3.Pincode");
			System.out.println("Enter your choice: ");
			int wish = s.nextInt();

			switch (wish) {
			case 1: {
				returnBranchId();
				Branch branch = updateStreetNameBasedOnBranchId();
			}
				break;
			case 2: {
				returnBranchId();
				Branch branch = updateCityNameBasedOnBranchId();
			}
				break;
			case 3: {
				returnBranchId();
				Branch branch = updatePinCodeBasedOnBranchId();
			}
				break;
			default: {
				System.out.println("Sorryyy...");
			}
			}
		}
			break;

		case 3: {
			// fetch Branch data

			Query q = enitityManager.createQuery("Select b from Branch b");
			List<Branch> branches = q.getResultList();
			for (Branch branchs : branches) {
				System.out.println("Branch Name is: " + branchs.getName());
				System.out.println("Number of Beds: " + branchs.getNoOfBeds());
				System.out.println("Number of Docters: " + branchs.getNoOfDocters());
				System.out.println("******************************************************");
				System.out.println("Successfully Retrived...");

			}
		}
			break;
		case 4: {
			// Remove Branch
			returnBranchId();
			System.out.println("enter the id you want to remove: ");
			int id = s.nextInt();
			Branch branchDelete = enitityManager.find(Branch.class, id);
			entityTransaction.begin();
			enitityManager.remove(branchDelete);
			entityTransaction.commit();
			System.out.println("Successfully Removed...");
		}

		}
	}

	// save branch
	public static Branch saveBranch() {
		System.out.println("Enter one hospitalId from this: ");
		int hospitalId = s.nextInt();

		Hospital hospital = enitityManager.find(Hospital.class, hospitalId);

		if (hospital != null) {
			Branch branch = BranchHelper.readBranch();
			List<Branch> branches = new ArrayList<>();
			branches.add(branch);
			branch.setHospital(hospital);
			hospital.setBranches(branches);
			

			entityTransaction.begin();
			enitityManager.persist(branch);
			enitityManager.merge(hospital);
			entityTransaction.commit();

			System.out.println("Branch added successfully");
			return branch; // Return the saved branch

		} else {
			System.out.println("Hospital not found with the given id.");
			System.out.println("Please add a new Hospital.\n");
			Hospital hospitalData = HospitalHelper.readHospital();
			Hospital savedHospital = HospitalDao.saveHospitalData(hospitalData);

			// Assuming HospitalDao.saveHospitalData returns the saved hospital
			if (savedHospital != null) {
				// Recursive call to retry adding the branch
				return saveBranch();
			} else {
				System.out.println("Failed to save the hospital. Cannot add the branch.");
				return null;
			}
		}
	}

	// Update StreetName based on the branchId

	public static Branch updateStreetNameBasedOnBranchId() {
		System.out.println("Enter one Branch Id: ");
		int BranchId = s.nextInt();

		Branch branch = enitityManager.find(Branch.class, BranchId);
		if (branch != null) {
			System.out.println("Enter new Street name: ");
			String StreetNames = s.next();

			branch.getAddress().setStreet(StreetNames);

			entityTransaction.begin();
			enitityManager.merge(branch);
			entityTransaction.commit(); // Commit the transaction after merging changes
		} else {
			System.out.println("Branch not found with the given id.");
		}
		return branch;
	}

	// update City Name based on the Brach Id


	public static Branch updateCityNameBasedOnBranchId() {
		System.out.println("Enter one Branch Id: ");
		int BranchId = s.nextInt();

		Branch branch = enitityManager.find(Branch.class, BranchId);
		if (branch != null) {
			System.out.println("Enter new City name: ");
			String CityNames = s.next();

			branch.getAddress().setCity(CityNames);

			entityTransaction.begin();
			enitityManager.merge(branch);
			entityTransaction.commit(); // Commit the transaction after merging changes
		} else {
			System.out.println("Branch not found with the given id.");
		}
		return branch;
	}

	// update Pincode based on AddressId

	public static Branch updatePinCodeBasedOnBranchId() {
		System.out.println("Enter one Branch Id: ");
		int BranchId = s.nextInt();

		Branch branch = enitityManager.find(Branch.class, BranchId);
		if (branch != null) {
			System.out.println("Enter new Pincode: ");
			String PinCode = s.next();

			branch.getAddress().setPin(PinCode);

			entityTransaction.begin();
			enitityManager.merge(branch);
			entityTransaction.commit(); // Commit the transaction after merging changes
		} else {
			System.out.println("Branch not found with the given id.");
		}
		return branch;
	}

	// display Address ids;
	public static Branch returnBranchId() {
		Query q = enitityManager.createQuery("Select id from Branch b");
		List<Integer> id = q.getResultList();
		for (int AddressId : id) {
			System.out.println("Branch id: " + AddressId);
		}
		return branch;

	}
}
