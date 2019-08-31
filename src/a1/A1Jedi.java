package a1;

import java.util.Scanner;

public class A1Jedi {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		// Your code follows here.
		
		//Scanner accepts number of items in the store

				int itemCount = scan.nextInt();

				//Array for item names

				String [] itemNames = new String [itemCount]; //IMPORTANT!!!

				//Array for item price

				double [] itemPrice = new double [itemCount];

				//For loop is used to get name and price of the item
				
				//(1) IMPORTANT!!!!!! 
				for (int i = 0; i<itemCount; i++) {
					
					//scan for item name
					
					itemNames[i] = scan.next(); 
					
					//scan for item price
					
					itemPrice[i] = scan.nextDouble();
				}

				//scans number of customers

				int numCustomers = scan.nextInt();

				//String array firstNames will contain FIRST names of ALL customers

				String [] firstNames = new String [numCustomers];

				//String array lastNames will contain LAST names of ALL customers

				String [] lastNames = new String [numCustomers];

				/*
				 * int array boughtItems will contain number of bought TYPES of items
				 * 
				 * example: If first customer bought 5 bananas, then
				 * for [0] will refer to value of 5
				 * */

				int [] boughtItems = new int [numCustomers];

				//to keep track number of items bought of particular item
				int [] customersBought = new int [itemCount]; //IMPORTANT! CUSTOMER COUNT
				
				int [] typesBought = new int [itemCount]; //IMPORTANT! Types bought count
				
				//integer quantity of the item bought
				
				int itemQuantity; 

				//item name of the item bought
				
				String itemName; 

				//total spend by current customers
				
				double totalSpend = 0; 
				
				for (int i =0; i<numCustomers; i++) {
					
					//scan for FIRST name of the customer
					
					firstNames[i] = scan.next(); 

					//scan for LAST name of the customer
					
					lastNames[i] = scan.next(); 

					//scan for number of bought TYPES of items
					
					boughtItems[i] = scan.nextInt();
					
					/**
					 * Inner for loop
					 * 
					 * Gets information about bought items 
					 * by iterating through types of items
					 * Calculates total spend on the purchase by current customer
					 */
					
					//IMPORTANT
					
					for (int j = 0; j<boughtItems[i]; j++) {
						
						//scan for item quantity of current type of product
						
						itemQuantity = scan.nextInt();  
						
						//scan for item name
						
						itemName = scan.next(); 
						
						updateTypesCustomerCount(itemName, itemQuantity, itemNames, customersBought, typesBought);
					}
					
				}
				
				printResults(itemNames, customersBought, typesBought);
	}
	
	//Check whether name of item matches. 
	//If yes ==> Increase count of customers, 
	//Increase count of item
	static void updateTypesCustomerCount(String itemName, int itemQuanity, String [] itemNames, int [] customersBought, int [] typesBought) {
		for (int i = 0; i < itemNames.length; i++) {
			if (itemName.equals(itemNames[i])) {
				customersBought[i] += 1;
				typesBought [i] += itemQuanity;
			}
		}
	}
	
	static void printResults(String [] itemNames, int [] customersBought, int [] typesBought) {
		for (int i = 0; i<itemNames.length; i++) {
			if (customersBought[i] == 0) {
				System.out.println("No customers bought " + itemNames[i]);
			} else {
				System.out.println(customersBought[i] + " customers bought " + typesBought[i] + " " + itemNames[i]);
			}
		}
	}
}
