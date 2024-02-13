package com.hospital_app_bi.Helper;

import java.util.Scanner;

import com.hospital_app.Dto.Address;

public class AddressHelper {
	
	static Scanner s=new Scanner(System.in);
	static Address address=new Address();
	
	public static Address readAddress()
	{
		System.out.println("Enter street Name: ");
		String streetName=s.next();
		
		System.out.println("Enter City Name: ");
		String cityName=s.next();
		
		System.out.println("Enter state Name: ");
		String stateName=s.next();
		
		System.out.println("Enter Pincode: ");
		int pincode=s.nextInt();
		
		address.setStreet(streetName);
		address.setCity(cityName);
		address.setState(stateName);
		address.setPin(stateName);
		
		return address;
		
		
	}
	

}
