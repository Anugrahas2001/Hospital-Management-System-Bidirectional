package com.hospital_app_bi.Helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.hospital_app.Dto.Encounter;
import com.hospital_app.Dto.Person;

public class PersonHelper {
	static Scanner s = new Scanner(System.in);
	static Person person = new Person();

	public static Person readPerson() {
		System.out.println("Enter Person name: ");
		String personName = s.next();

		System.out.println("Enter Person age: ");
		int personAge = s.nextInt();

		System.out.println("Enter person gender: ");
		String personGender = s.next();

		System.out.println("Enter Person Phone number: ");
		String personPhone = s.next();

		System.out.println("Enter Person place: ");
		String personPlace = s.next();
		person.setName(personName);
		person.setAge(personAge);
		person.setGender(personGender);
		person.setPhone(personPhone);
		person.setPlace(personPlace);
		
//		Encounter encounter=EncounterHelper.readEncounter();
		List<Encounter>encounters=new ArrayList<Encounter>();
//		encounters.add(encounter);
		person.setEncounters(encounters);
		
		return person;

	}

}
