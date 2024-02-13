package com.hospital_app_bi.Helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.hospital_app.Dto.Address;
import com.hospital_app.Dto.Branch;
import com.hospital_app.Dto.Encounter;
import com.hospital_app.Dto.Hospital;
import com.hospital_app_bi.Dao.EncounterDao;


public class BranchHelper {

	static Scanner s = new Scanner(System.in);
	static Branch branch = new Branch();

	public static Branch readBranch()
	{
		System.out.println("Enter Branch Name: ");
		String name=s.next();
		
		System.out.println("Enter no.of Docters: ");
		int noOfDocters=s.nextInt();
		
		System.out.println("Enter no.of Beds: ");
		int noOfBeds=s.nextInt();
		
		branch.setName(name);
		branch.setNoOfDocters(noOfDocters);
		branch.setNoOfBeds(noOfBeds);
		
		Address address=AddressHelper.readAddress();
		branch.setAddress(address);
		
//		Hospital hospital=HospitalHelper.readHospital();
//		branch.setHospital(hospital);
		
//		Encounter encounter=EncounterHelper.readEncounter();
//		List<Encounter> encounters=new ArrayList<Encounter>();
//		encounters.add(encounter);
//		branch.setEncounters(encounters);
		
		return branch ;

	}
	

	
}
