package com.hospital_app_bi.Dao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.hospital_app.Dto.Address;
import com.hospital_app.Dto.Branch;

public class AddressDao {

	static EntityManagerFactory enityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	static EntityManager enitityManager = enityManagerFactory.createEntityManager();
	static EntityTransaction entityTransaction = enitityManager.getTransaction();
	static Scanner s = new Scanner(System.in);
	static Address address = new Address();

	public static void AddressOperation() {
		System.out.println("1.update Address.\n2.Fetch Data.\n3.Delete Address");
		System.out.println("Enter your choice: ");
		int choice = s.nextInt();

		switch (choice) {
		case 1:
			System.out.println("what do you want to update in the Address?\n");
			System.out.println("1.street Name.\n2.City name.\n3.Pincode");
			System.out.println("Enter your wish: ");
			int wish = s.nextInt();

			switch (wish) {
			case 1: {
				returnAddressId();
				Address address = updateStreetNameAddressId();
			}
				break;
			case 2: {
				returnAddressId();
				Address address = updateCityNameAddressId();
			}
				break;
			case 3: {
				returnAddressId();
				Address address = updatePinCodeAddressId();
			}
				break;
			default:
				System.out.println("Sorry...Enter a valid Id.");
			}
		case 2: {
			// Fetch datas from Address
			Query q = enitityManager.createQuery("Select a from Address a");
			List<Address> addresses = q.getResultList();
			for (Address addresss : addresses) {
				System.out.println("Enter street Name: " + addresss.getStreet());
				System.out.println("Enter City Name: " + addresss.getCity());
				System.out.println("Enter State name: " + addresss.getState());
				System.out.println("Enter Pin code: " + addresss.getPin());
				System.out.println("******************************************************");
				System.out.println("Successfully Retrived...");

			}
		}
			break;
		case 3: {
			// Remove Address
			returnAddressId();
			System.out.println("enter the id you want to remove: ");
			int id = s.nextInt();
			Address addressDelete = enitityManager.find(Address.class, id);

			if (addressDelete != null) {
				
				entityTransaction.begin();
				enitityManager.remove(addressDelete);
				entityTransaction.commit();
				System.out.println("Successfully Removed...");
			} else {
				System.out.println("Address with id " + id + " not found.");
			}
		}
		}
	}

	// Update Street Name Based on AddressId
	public static Address updateStreetNameAddressId() {
		System.out.println("Enter one address Id: ");
		int addressId = s.nextInt();

		Address address = enitityManager.find(Address.class, addressId);

		if (address != null) {
			System.out.println("Enter New street Name: ");
			String streetName = s.next();

			address.setStreet(streetName);

			entityTransaction.begin();
			enitityManager.merge(address);
			entityTransaction.commit();
		} else {
			System.out.println("Address with this id not found.");
		}
		return address;
	}

	// Update City Name Based on AddressId
	public static Address updateCityNameAddressId() {
		System.out.println("Enter one address Id: ");
		int addressId = s.nextInt();

		Address address = enitityManager.find(Address.class, addressId);

		if (address != null) {
			System.out.println("Enter New City Name: ");
			String CityName = s.next();

			address.setCity(CityName);
			entityTransaction.begin();
			enitityManager.merge(address);
			entityTransaction.commit();
		} else {
			System.out.println("Address with this id not found.");
		}
		return address;
	}

	// Update PinCode Based on AddressId
	public static Address updatePinCodeAddressId() {
		System.out.println("Enter one address Id: ");
		int addressId = s.nextInt();

		Address address = enitityManager.find(Address.class, addressId);

		if (address != null) {
			System.out.println("Enter New Pincode: ");
			String PinCode = s.next();

			address.setPin(PinCode);

			entityTransaction.begin();
			enitityManager.merge(address);
			entityTransaction.commit();
		} else {
			System.out.println("Address with this id not found.");
		}
		return address;
	}

	// Return AddressId

	public static void returnAddressId() {
		Query q = enitityManager.createQuery("Select id from Address a");
		List<Integer> id = q.getResultList();
		for (int AddressId : id) {
			System.out.println("Address id: " + AddressId);
		}
	}

}
