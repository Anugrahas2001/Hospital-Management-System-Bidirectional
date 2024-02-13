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
import com.hospital_app.Dto.MedOrder;

import com.hospital_app_bi.Helper.MedOrderHelper;

public class MedOrderDao {
	static EntityManagerFactory enityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	static EntityManager enitityManager = enityManagerFactory.createEntityManager();
	static EntityTransaction entityTransaction = enitityManager.getTransaction();
	static Scanner s = new Scanner(System.in);
	static MedOrder medorder = new MedOrder();

	public static MedOrder medOrderOperations() {
		System.out.println("1.Add MedOrder.\n2.Update MedOrder.\n3.Fetch MedOder deatails.\n4.Remove medOrder");
		System.out.println("Enter your choice: ");
		int choice = s.nextInt();

		switch (choice) {
		case 1: {
			// add med oder based on encounter id
			saveMedOrderData();

		}
			break;
		case 2: {
			// update medorder based on Encounter Id.
			System.out.println("What do you want to update?");
			System.out.println("1.Dosage.\n2.Quantity.\n3.Payment Mode");
			System.out.println("Enter your wish: ");
			int wish = s.nextInt();
			switch (wish) {
			case 1: {
				// update Dosage
				returnMedOderIds();
				updateDosageBasedOnMedOrderId();
			}
				break;
			case 2: {
				// Update quantity
				returnMedOderIds();
				updateQuantityBasedOnMedOrderId();
			}
				break;
			case 3: {
				// Update paymentMode
				returnMedOderIds();
				updatePaymentModeBasedOnMedOrderId();
			}
				break;
			default: {
				System.out.println("Enter valid number.");
			}
			}
		}
			break;
		case 3: {
			// fetch medorder
			Query q = enitityManager.createQuery("Select m from MedOrder m");
			List<MedOrder> medorders = q.getResultList();
			for (MedOrder medorderss : medorders) {
				System.out.println("Dosage is: " + medorderss.getDosage());
				System.out.println("Quantity is: " + medorderss.getQuantity());
				System.out.println("Payment mode is: " + medorderss.getPaymentMode());
				System.out.println("******************************************************");
				System.out.println("Successfully Retrived...");

			}
		}
			break;
		case 4: {
			// Remove data
			returnMedOderIds();
			System.out.println("enter the id you want to remove: ");
			int id = s.nextInt();
			MedOrder medorderDelete = enitityManager.find(MedOrder.class, id);
			entityTransaction.begin();
			enitityManager.remove(medorderDelete);
			entityTransaction.commit();
			System.out.println("Successfully Removed...");
		}
			break;
		default: {
			System.out.println("sorry...please enter a valid data.");
		}
		}
		return medorder;
	}

	// Save MedOrder Data
	public static MedOrder saveMedOrderData() {
	    EncounterDao.returnEncounterIds();
	    System.out.println("Enter Encounter id from this: ");
	    int encounterId = s.nextInt();
	    Encounter encounter = enitityManager.find(Encounter.class, encounterId);

	    if (encounter != null) {
	        MedOrder medorder = MedOrderHelper.readmedOrderData();
	        medorder.setEncounter(encounter); // Set encounterId in MedOrder

	        List<MedOrder> medorders = encounter.getMedOrders();
	        medorders.add(medorder);    
	        medorder.setEncounter(encounter);
	        encounter.setMedOrders(medorders);

	        entityTransaction.begin();
	        enitityManager.persist(medorder);
	        entityTransaction.commit();

	        entityTransaction.begin();
	        enitityManager.merge(encounter);
	        entityTransaction.commit();

	        System.out.println("Medorder datas are successfully...");
	    } else {
	        System.out.println("Encounter with this id doesn't exist.");
	    }
	    return medorder;
	}


	
	// update Dosage based on medorder id

	public static MedOrder updateDosageBasedOnMedOrderId() {
		System.out.println("Select one id from this.");
		int medOrderId = s.nextInt();

		MedOrder medorder = enitityManager.find(MedOrder.class,medOrderId );

		if (medorder != null) {
			System.out.println("Enter the updated new Dosage.");
			String dosage = s.next();
			medorder.setDosage(dosage);
			
			entityTransaction.begin();
			enitityManager.merge(medorder);
			entityTransaction.commit(); // Commit the transaction after merging changes
		} else {
			System.out.println("Encounter not found with the given id.");
		}
		return medorder;
		

	}

	// update Quantity based on medorder id

	public static MedOrder updateQuantityBasedOnMedOrderId() {
		System.out.println("Select one id from this.");
		int medOrderId = s.nextInt();

		MedOrder medorder = enitityManager.find(MedOrder.class,medOrderId );

		if (medorder != null) {
			System.out.println("Enter the updated new Quantity.");
			String quantity = s.next();

			medorder.setQuantity(quantity);

			entityTransaction.begin();
			enitityManager.merge(medorder);
			entityTransaction.commit(); // Commit the transaction after merging changes
		} else {
			System.out.println("Encounter not found with the given id.");
		}
		return medorder;
	

	}

	// update Payment Mode based on medorder id

	public static MedOrder updatePaymentModeBasedOnMedOrderId() {
		System.out.println("Select one id from this.");
		int medOrderId = s.nextInt();

		MedOrder medorder = enitityManager.find(MedOrder.class,medOrderId );

		if (medorder != null) {
			System.out.println("Enter the updated new payment mode.");
			String paymentMode = s.next();

			medorder.setPaymentMode(paymentMode);

			entityTransaction.begin();
			enitityManager.merge(medorder);
			entityTransaction.commit(); // Commit the transaction after merging changes
		} else {
			System.out.println("Encounter not found with the given id.");
		}
		return medorder;

	}

	// Return medorder ids
	public static void returnMedOderIds() {
		Query q = enitityManager.createQuery("Select id from MedOrder m");
		List<Integer> id = q.getResultList();
		for (int MedOrderId : id) {
			System.out.println("MedOrder id: " + MedOrderId);
		}

	}

}
