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
import com.hospital_app_bi.Helper.HospitalHelper;
import com.hospital_app_bi.Helper.PersonHelper;

public class PersonDao {
	static EntityManagerFactory enityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	static EntityManager enitityManager = enityManagerFactory.createEntityManager();
	static EntityTransaction entityTransaction = enitityManager.getTransaction();
	static Scanner s = new Scanner(System.in);
	static Person person = new Person();

	public static void personOperations() {
		System.out.println("1.Save Person.\n2.Update.\3.Fetch Person Data.");
		System.out.println("Enter your choice: ");
		int choice = s.nextInt();

		switch (choice) {
		case 1: {
			Person person = PersonHelper.readPerson();
			Person persons = savePerson(person);
		}
		case 2: {
			System.out.println("What do you want to update in Person?\n");
			System.out.println("1.Name.\n2.Age.\n3.Gender.\n4.Phone Number.\n5.Place.");
			System.out.println("Enter your wish: ");
			int wish = s.nextInt();

			switch (choice) {
			case 1: {
				returnPersonIds();
				saveNameBasedOnPersonId();
			}
				break;
			case 2: {
				returnPersonIds();
				saveAgeBasedOnPersonId();
			}
				break;
			case 3: {
				returnPersonIds();
				saveGenderBasedOnPersonId();
			}
				break;
			case 4: {
				returnPersonIds();
				saveNumberBasedOnPersonId();
			}
				break;
			case 5: {
				returnPersonIds();
				savePlaceBasedOnPersonId();
			}
				break;
			default:
				System.out.println("Person with this id doesn't exist.");
			}
		}
			break;
		case 3: {
			// fetch datas

			Query q = enitityManager.createQuery("Select p from Person p");
			List<Person> persons = q.getResultList();
			for (Person personss : persons) {
				System.out.println("Person Name is: " + personss.getName());
				System.out.println("person Age is: " + personss.getAge());
				System.out.println("Person Gender is: " + personss.getPhone());
				System.out.println("Person Place is: " + personss.getPlace());
				System.out.println("******************************************************");
				System.out.println("Successfully Retrived...");

			}
		}
			break;
		default: {
			System.out.println("Sorry Please Enter a valid Number.");
		}
		}
	}

	// save branch
	public static Person savePerson(Person person) {

		entityTransaction.begin();
		enitityManager.persist(person);
		entityTransaction.commit();

		System.out.println("Person added successfully");
		return person;
	}

	// Update person name based on the person id
	public static Person saveNameBasedOnPersonId() {
		System.out.println("Enter one PersonId: ");
		int PersonId = s.nextInt();

		Person person = enitityManager.find(Person.class, PersonId);
		if (person != null) {
			System.out.println("Enter new Name: ");
			String Name = s.next();

			person.setName(Name);

			entityTransaction.begin();
			enitityManager.merge(person);
			entityTransaction.commit(); // Commit the transaction after merging changes
		} else {
			System.out.println("Person not found with the given id.");
		}
		return person;
	}

	// Update person based on the person id
	public static Person saveAgeBasedOnPersonId() {
		System.out.println("Enter one PersonId: ");
		int PersonId = s.nextInt();

		Person person = enitityManager.find(Person.class, PersonId);
		if (person != null) {
			System.out.println("Enter new Age: ");
			int Age = s.nextInt();

			person.setAge(Age);

			entityTransaction.begin();
			enitityManager.merge(person);
			entityTransaction.commit(); // Commit the transaction after merging changes
		} else {
			System.out.println("Person not found with the given id.");
		}
		return person;
	}

	// Update person Gender based on the person id
	public static Person saveGenderBasedOnPersonId() {
		System.out.println("Enter one PersonId: ");
		int PersonId = s.nextInt();

		Person person = enitityManager.find(Person.class, PersonId);
		if (person != null) {
			System.out.println("Enter new Gender: ");
			String genger = s.next();

			person.setGender(genger);

			entityTransaction.begin();
			enitityManager.merge(person);
			entityTransaction.commit(); // Commit the transaction after merging changes
		} else {
			System.out.println("Person not found with the given id.");
		}
		return person;

	}

	// Update person Phone Number based on the person id
	public static Person saveNumberBasedOnPersonId() {
		System.out.println("Enter one PersonId: ");
		int PersonId = s.nextInt();

		Person person = enitityManager.find(Person.class, PersonId);
		if (person != null) {
			System.out.println("Enter new Phone Number: ");
			String phoneNumber = s.next();

			person.setPhone(phoneNumber);

			entityTransaction.begin();
			enitityManager.merge(person);
			entityTransaction.commit(); // Commit the transaction after merging changes
		} else {
			System.out.println("Person not found with the given id.");
		}
		return person;
	}

	// Update person Place based on the person id
	public static Person savePlaceBasedOnPersonId() {
		System.out.println("Enter one PersonId: ");
		int PersonId = s.nextInt();

		Person person = enitityManager.find(Person.class, PersonId);
		if (person != null) {
			System.out.println("Enter new Gender: ");
			String place = s.next();

			person.setPlace(place);

			entityTransaction.begin();
			enitityManager.merge(person);
			entityTransaction.commit(); // Commit the transaction after merging changes
		} else {
			System.out.println("Person not found with the given id.");
		}
		return person;

	}

	// return person Id.
	public static Person returnPersonIds() {
		Query q = enitityManager.createQuery("Select id from Person p");
		List<Integer> id = q.getResultList();
		for (int PersonId : id) {
			System.out.println("person id: " + PersonId);
		}
		return person;

	}

}
