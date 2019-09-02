package a1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class A1Jedi {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		// Your code follows here.
		
		//Scanner accepts number of types of items available at the store
		
		int itemTypes = scan.nextInt();
		
		//Array for item names
		
		String [] itemNames = new String [itemTypes];
		
		//Array for item price
		
		double [] itemPrice = new double [itemTypes];
		
		//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		//(1)
	    //WILLL BE USED TO FIND TOTAL QUANTITIES OF ITEMS
		//WILL BE USED FOR FINAL OUTPUT
		int [] totalQuantities = new int [itemTypes];
		
		//WILL BE USED TO FIND TOTAL NUMBER OF CUSTOMERS WHICH BOUGHT THE ITEM
		//WILL BE USED FOR FINAL OUTPUT
		int [] totalCustomers = new int [itemTypes];
		
		//For loop is used to get name and price of the item
		
		for (int i = 0; i<itemTypes; i++) {
			
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
		 * int array boughtItemTypes will contain number of bought TYPES of items
		 * 
		 * example: If Carrie Brownestein 
		 * bought 3 types of products (Banana, Orange, Milk)
		 * Array will have value of 3 for these 3 types
		 * */

		int [] boughtItemTypes = new int [numCustomers];
		
		//integer quantity of the item bought
		
		int itemQuantity; 

		//item name of the item bought
		
		String itemName; 
		
	    String [] boughtItemNames;
		//names of items bought by current customer
		
		//ArrayList boughtItemNames;
	    ArrayList <String> boughtTypes;
		
		/**
		 * Outer for loop
		 * Iterates through each customer and records data 
		 * 
		 * Read values in the following arrays
		 * firstNames, lastNames, boughtItemTypes
		 */
		
		for (int i =0; i<numCustomers; i++) {
			
			//scan for FIRST name of the customer
			
			firstNames[i] = scan.next(); 

			//scan for LAST name of the customer
			
			lastNames[i] = scan.next(); 

			//scan for number of bought TYPES of items
			
			boughtItemTypes[i] = scan.nextInt();
			
			//keeping track of bought item names to find the match
			boughtItemNames = new String [ boughtItemTypes[i] ];
			
			for (int j = 0; j< boughtItemTypes[i]; j++) {
				//scan for item quantity of current type of product
				
				itemQuantity = scan.nextInt();  
				
				//boughtItemQuantities[i] = itemQuantity;
				
				//scan for item name
				
				itemName = scan.next(); 
				
				boughtItemNames[j] = itemName;
				
				findTotalQuantities(itemName, itemQuantity, itemNames, totalQuantities);
				
			}
			
			//System.out.println (firstNames[i]);
			
			boughtTypes = findBoughtTypes(itemNames, boughtItemNames);
			
			for (int p = 0; p<boughtTypes.size(); p++) {
				findTotalCustomers(boughtTypes.get(p), itemNames, totalCustomers);
				
			}
			
			//System.out.printf("%n");
			//hello
		}
		
		printResults(itemNames, totalQuantities, totalCustomers);
}
	
	//Find matching index to put information about purchase in correct location in the arrays
	//int [] totalQuantities and int [] totalCustomers
	static void findTotalQuantities(String currentItemName, int itemQuantity, String [] itemNames, int [] totalQuantities) {
		for (int i = 0; i < itemNames.length; i++) {
			if (currentItemName.equals(itemNames[i])) {
				totalQuantities [i] += itemQuantity;
			}
		}
	}
	
	static ArrayList <String> findBoughtTypes (String [] itemNames, String [] boughtItemNames) {
		ArrayList<String> matches =new ArrayList<String>();
		
		for (int i = 0; i < boughtItemNames.length; i++) {
			
			for (int j = i+1; j<boughtItemNames.length; j++) {

				if ((boughtItemNames[i]).equals(boughtItemNames[j])) {
					
					if (matches.contains(boughtItemNames[i])) {
						break;
					}
					
					matches.add(boughtItemNames[i]);
			    }
		}
		
	}
		//EVERYTHING ABOVE WORKS CORRECTLY
		for (int i = 0; i < boughtItemNames.length; i++) {
			if (matches.contains(boughtItemNames[i]) == false) {
				matches.add(boughtItemNames[i]);
			}
		}
		
		//delete later
//		for (int i =0; i<matches.size(); i++) {
//			System.out.println(matches.get(i));
//		}
		
		return matches;
	}
	//now that's time to add count of customers
	//two methods
	//(1) to add quantities because those are different - DONE
	//(2) to add customers
	
	static void findTotalCustomers (String match, String [] itemNames, int [] totalCustomers) {
		for (int i = 0; i<itemNames.length; i++) {
			if (match.equals(itemNames[i])) {
				totalCustomers[i] += 1;
			}
		}
	}
	
	static void printResults (String [] itemNames, int [] totalQuantities, int [] totalCustomers) {
		for (int i = 0; i<itemNames.length; i++) {
			
			if (totalQuantities[i] == 0) {
				System.out.println("No customers bought " + itemNames[i]);
			} else {
				System.out.println(totalCustomers[i] + " customers bought " + totalQuantities [i] + " " + itemNames[i]);
			}
			
		}
	}
}
