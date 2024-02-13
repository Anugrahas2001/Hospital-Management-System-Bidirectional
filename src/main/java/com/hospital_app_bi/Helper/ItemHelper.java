package com.hospital_app_bi.Helper;

import java.util.Scanner;

import com.hospital_app.Dto.Item;

public class ItemHelper {
	static Scanner s = new Scanner(System.in);
	static Item item=new Item();
	
	public static Item readItemData()
	{
		System.out.println("Enter medicine name: ");
		String medName=s.next();
		
		System.out.println("Enter medicine type: ");
		String medType=s.next();
		
		System.out.println("Enter the medicine price: ");
		int medPrice=s.nextInt();
		
		System.out.println("Enter the description of the medicine: ");
		String description=s.next();
		
		item.setMedName(medName);
		item.setMedType(medType);
		item.setPrice(medPrice);
		item.setDescription(description);
		
		return item;
		
	}

}
