package com.hospital_app_bi.Helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.hospital_app.Dto.Encounter;
import com.hospital_app.Dto.MedOrder;
import com.hospital_app.Dto.Person;
import com.hospital_app_bi.Dao.MedOrderDao;

public class EncounterHelper {

	static Scanner s = new Scanner(System.in);
	static Encounter encounter = new Encounter();

	public static Encounter readEncounter() {
		System.out.println("Disease name: ");
		String diseaseName = s.next();

		System.out.println("Enter Admit Date: ");
		String admitDate = s.next();

		System.out.println("Enter Discharge Date: ");
		String dischargeDate = s.next();

		System.out.println("Enter Doctor: ");
		String docterName = s.next();

		encounter.setDisease(diseaseName);
		encounter.setAdmitDate(admitDate);
		encounter.setDischargeDate(dischargeDate);
		encounter.setDocterName(docterName);

		Person person = PersonHelper.readPerson();
		encounter.setPersons(person);
		
//		MedOrder medorder=MedOrderHelper.readmedOrderData();
//		List<MedOrder> medOrders=new ArrayList<MedOrder>();
//		 medOrders.add(medorder);
//		encounter.setMedOrders(medOrders);
		
		return encounter;

	}

}
