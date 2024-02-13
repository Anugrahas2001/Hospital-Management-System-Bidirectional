package com.hospital_app_bi.Dao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.hospital_app.Dto.Item;

public class ItemDao {

	static EntityManagerFactory enityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	static EntityManager enitityManager = enityManagerFactory.createEntityManager();
	static EntityTransaction entityTransaction = enitityManager.getTransaction();
	static Scanner s = new Scanner(System.in);
	static Item item = new Item();

	public static Item ItemOperations() {
		System.out.println("1.Update Item.\n2.Fetch Item data.");
		System.out.println("Enter your choice: ");
		int choice = s.nextInt();
		switch (choice) {
		case 1: {
			// update Item
			System.out.println("what do you want to update?");
			System.out.println("1.Medicine Name.\n2.Medicine Type.\n3.Price");
			System.out.println("Enter your wish: ");
			int wish = s.nextInt();

			switch (wish) {
			case 1: {
				// update medicine name based on medorderId
				returnItemsIds();
				updateItemBasedOnItemId();
			}
				break;
			case 2: {
				// update medicine type based on medorderId
				returnItemsIds();
				updateIMedTypeBasedOnItemId();
			}
				break;
			case 3: {
				// update price based on medorderId
				returnItemsIds();
				updateIMedPriceBasedOnItemId();
			}
				break;
			default: {
				System.out.println("Sorry... Enter a valid data.");
			}
			}
		}
			break;
		case 2: {
			// Fetch Item Data
			Query q = enitityManager.createQuery("Select i from Item i");
			List<Item> items = q.getResultList();
			for (Item itemes : items) {
				System.out.println("Medicine Name: " + itemes.getMedName());
				System.out.println("Medicine Type: " + itemes.getMedType());
				System.out.println("Medicine Price: " + itemes.getPrice());
				System.out.println("Medicine description: " + itemes.getDescription());
				System.out.println("*******************************************************");
			}

		}

		}
		return item;
	}

	// update medicine name based on ItemId

	public static Item updateItemBasedOnItemId() {
		System.out.println("Enter one id from this: ");
		int itemId = s.nextInt();

		Item item = enitityManager.find(Item.class, itemId);
		if (item != null) {
			System.out.println("Enter the new Medicine Name: ");
			String medName = s.next();

			item.setMedName(medName);

			entityTransaction.begin();
			enitityManager.merge(item);
			entityTransaction.commit(); // Commit the transaction after merging changes
		} else {
			System.out.println("MedOrder not found with the given id.");
		}
		return item;

	}

	// update medicine Type based on ItemId

	public static Item updateIMedTypeBasedOnItemId() {
		System.out.println("Enter one id from this: ");
		int itemId = s.nextInt();

		Item item = enitityManager.find(Item.class, itemId);
		if (item != null) {
			System.out.println("Enter the new Medicine Type: ");
			String medType = s.next();

			item.setMedType(medType);

			entityTransaction.begin();
			enitityManager.merge(item);
			entityTransaction.commit(); // Commit the transaction after merging changes
		} else {
			System.out.println("MedOrder not found with the given id.");
		}
		return item;

	}

	// update medicine price based onItemId

	public static Item updateIMedPriceBasedOnItemId() {
		System.out.println("Enter one id from this: ");
		int itemId = s.nextInt();

		Item item = enitityManager.find(Item.class, itemId);
		if (item != null) {
			System.out.println("Enter the new Medicine Price: ");
			int price = s.nextInt();

			item.setPrice(price);

			entityTransaction.begin();
			enitityManager.merge(item);
			entityTransaction.commit(); // Commit the transaction after merging changes
		} else {
			System.out.println("MedOrder not found with the given id.");
		}
		return item;

	}

	// Return Item ids
	public static void returnItemsIds() {
		Query q = enitityManager.createQuery("Select id from Item i");
		List<Integer> id = q.getResultList();
		for (int ItemIds : id) {
			System.out.println("Item id: " + ItemIds);
		}

	}

}
