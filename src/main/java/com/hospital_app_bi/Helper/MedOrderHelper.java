package com.hospital_app_bi.Helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.hospital_app.Dto.Item;
import com.hospital_app.Dto.MedOrder;

public class MedOrderHelper {
	static Scanner s = new Scanner(System.in);
	static MedOrder medorder=new MedOrder();
	
	
	public static MedOrder readmedOrderData()
	{
		System.out.println("Enter the dosage of the medicine: ");
		String medDosage=s.next();
		
		System.out.println("Enter the quantity: ");
		String medQuantity=s.next();
		
		System.out.println("Enter the Order Data: ");
		String orderDate=s.next();
		
		System.out.println("Enter the payment mode: ");
		String paymentMode=s.next();
		
		Item items=ItemHelper.readItemData();
		List<Item>itemes=new ArrayList<Item>();
		itemes.add(items);
		
		medorder.setDosage(medDosage);
		medorder.setQuantity(medQuantity);
		medorder.setOrderDate(orderDate);
		medorder.setPaymentMode(paymentMode);
		medorder.setItems(itemes);
		
		return medorder;
		
		
	}
}
