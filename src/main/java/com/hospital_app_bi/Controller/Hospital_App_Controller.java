package com.hospital_app_bi.Controller;

import java.util.Scanner;

import com.hospital_app_bi.Dao.AddressDao;
import com.hospital_app_bi.Dao.BranchDao;
import com.hospital_app_bi.Dao.EncounterDao;
import com.hospital_app_bi.Dao.HospitalDao;
import com.hospital_app_bi.Dao.ItemDao;
import com.hospital_app_bi.Dao.MedOrderDao;
import com.hospital_app_bi.Dao.PersonDao;

public class Hospital_App_Controller {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("________________HOSPITAL_______________");
		System.out.println(
				"1.Hospital Operations.\n2.Branch Operations.\n3.Address Operations.\n4.Encounter Operations.\n5.MedOrer Operations.\n6.Item Operations.\n7.Person Details.");
		System.out.println("Enter your choice: ");
		int choice = s.nextInt();

		switch (choice) {
		case 1: {
			HospitalDao.hospitalOperations();
		}
			break;
		case 2: {
			BranchDao.branchOperations();
		}
			break;
		case 3: {
			AddressDao.AddressOperation();
		}

			break;
		case 4: {
			EncounterDao.encounterOperations();
		}
			break;
		case 5: {
			MedOrderDao.medOrderOperations();
		}
			break;
		case 6: {
			ItemDao.ItemOperations();
		}
			break;
		case 7: {
			PersonDao.personOperations();
		}
			break;
		default: {
			System.out.println("Enter a valid Option.");
		}
		}

	}

}
