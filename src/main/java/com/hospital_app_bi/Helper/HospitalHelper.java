package com.hospital_app_bi.Helper;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.hospital_app.Dto.Branch;
import com.hospital_app.Dto.Hospital;

public class HospitalHelper {
	static Scanner s=new Scanner(System.in);
	static Hospital hospital=new Hospital();
	
	
	public static Hospital readHospital()
	{
		System.out.println("Enter Hospital Name: ");
		String name=s.next();
		
		System.out.println("Enter phone number: ");
		String phoneNum=s.next();
		
		System.out.println("Enter email: ");
		String Email=s.next();
		
		System.out.println("Enter Hospital Type: ");
		String Type=s.next();
		
		hospital.setName(name);
		hospital.setPhone(phoneNum);
		hospital.setEmail(Email);
		hospital.setType(Type);
		
//		Branch branch=BranchHelper.readBranch();
//		List<Branch> branches=new ArrayList<Branch>();
//		
//		branches.add(branch);
//		hospital.setBranches(branches);
		
		
		return hospital;
	}
	
	

}
