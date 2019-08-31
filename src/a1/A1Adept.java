package a1;

import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		// Your code follows here.

		//Scanner accepts number of items in the store

		int itemCount = scan.nextInt();

		//Array for item names

		String [] itemNames = new String [itemCount];

		//Array for item price

		double [] itemPrice = new double [itemCount];

		//For loop is used to get name and price of the item
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

		//integer quantity of the item bought
		
		int itemQuantity; 

		//item name of the item bought
		
		String itemName; 

		//total spend by current customers
		
		double totalSpend = 0; 

		//Double array will hold values of
		//totals of purchases of each customer
		double totals [] = new double [numCustomers];

		/**
		 * Outer for loop
		 * Iterates through each customer and records data 
		 * 
		 * Read values in the following arrays
		 * firstNames, lastNames, boughtItems
		 */
		
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
			
			for (int j = 0; j<boughtItems[i]; j++) {
				
				//scan for item quantity of current type of product
				
				itemQuantity = scan.nextInt();  
				
				//scan for item name
				
				itemName = scan.next(); 

				//Use helper method compareItems to calculate total spend on certain item
				//for loop will sum up all total purchases made by current customer

				totalSpend += compareItems(itemName, itemQuantity, itemNames, itemPrice);
			}

			// Sets total price spent on items for the current customer
			totals[i] = totalSpend;

			//resets total spend for next iteration
			//it prevents summation of total prices for current and next customers
			totalSpend = 0; 
		}

		//Use helper method to find index of the customer and his/her total 
		//who spend the most on the purchase
		int biggestSpendingIndex = indexBiggestSpending(totals);

		//Use helper method to find index of the customer and his/her total 
		//who spend the least on the purchase
		int smallestSpendingIndex = indexSmallestSpending(totals);

		//Use helper method to find average total spent on purchases
		double averageTotal = calculateAverage(totals);

		//Prints out information about the biggest spender in the following format
		//Biggest: FIRST LAST (AMOUNT)
		System.out.println ("Biggest: " + firstNames[biggestSpendingIndex] + " " +  lastNames[biggestSpendingIndex]
				+ " (" + String.format("%.2f", totals[biggestSpendingIndex])+ ")");

		//Prints out information about the smallest spender in the following format
		//Smallest: FIRST LAST (AMOUNT)
		System.out.println ("Smallest: " + firstNames[smallestSpendingIndex] + " " +  lastNames[smallestSpendingIndex]
				+ " (" + String.format("%.2f", totals[smallestSpendingIndex])+ ")");

		//Prints out information about average bill
		System.out.println ("Average: " + String.format("%.2f", averageTotal));
	}

	/**
	 * compareItems
	 * Compares current item with list of items at store
	 * and if there is match, method returns total price of the current item 
	 * 
	 * Input:
	 * 1) String name of current item
	 * 2) Int quantity of current item
	 * 3) String array with all items at the store
	 * 4) Double array with prices of all items at the store
	 *
	 * Output: total price of the current item
	 * (if there is more than one current item then method returns 
	 * item price multiplied by quantity of this item)
	 * 
	 * Preconditions:
	 * 1) Input arrays itemNames and itemPrices should not be null and 
	 * must contain at least one value
	 * 2) String currentItem and int itemQuantity should not be null 
	 * 3) Passed in String currentItem should match the String from String array itemNames 
	 */
	
	static double compareItems (String currentItem, int itemQuantity, String [] itemNames, double [] itemPrices) {
		
		//initialize variable that will hold price of current item
		
		double price = 0;

		//For loop iterates through list of items at the store
		//And searches for the match

		for (int i = 0; i< itemNames.length; i++) {
			if (currentItem.equals(itemNames[i])) { 

				//if a customer bought multiple items of the same type
				//item price is multiplied by item quantity
				
				price = itemPrices[i]*itemQuantity; 
			}
		}
		return price;
	}

	/**
	 * indexBiggestSpending
	 * Finds and return the index of the biggest total of a customer
	 * 
	 * Input: Double array of totals of all customers
	 * 
	 * Output: Index of biggest total
	 * 
	 * Precondition: Double array totals should not be null and 
	 * must contain at least one value
	 */
	
	static int indexBiggestSpending (double [] totals) {
		
		//initialize biggestSpenging to be set to first value in totals array
		
		double biggestSpending = totals[0];
		
		//this variable keeps track of the INDEX of the biggest spending
		
		int biggestSpendingIndex = 0;
		
		//Iterate through array of totals and compare each value
		//If bigger value is found, biggestSpending is replaced with bigger value
		
		for (int i = 0; i<totals.length; i++) {
			if (biggestSpending < totals[i]) {
				biggestSpending = totals[i];
				biggestSpendingIndex = i;
			}
		}
		return biggestSpendingIndex;
	}
	
	/**
	 * indexSmallestSpending
	 * Finds and return the index of the smallest total of a customer
	 * 
	 * Input: Double array of totals of all customers
	 * 
	 * Output: Index of smallest total
	 * 
	 * Precondition: Double array of totals should not be null
	 */

	static int indexSmallestSpending(double [] totals) {
		
		//initialize smallestSpenging to be set to first value in totals array
		double smallestSpending = totals[0];
		
		//this variable keeps track of the INDEX of the smallest spending
		int smallestSpendingIndex = 0;
		
		//Iterate through array of totals and compare each value
		//If smaller value is found, smallestSpending is replaced with smaller value
		
		for (int i = 0; i<totals.length; i++) {
			if (smallestSpending > totals[i]) {
				smallestSpending = totals[i];
				smallestSpendingIndex = i;
			}
		}
		return smallestSpendingIndex;
	}

	/**
	 * calculateAverage
	 * Calculates average bill from all customers' totals
	 * 
	 * Input: Double array of totals of all customers
	 * 
	 * Output: Double average total
	 * 
	 * Precondition: Double array of totals should not be null
	 */
	static double calculateAverage (double [] totals) {
		
		//initialize variable that will hold average bill
		
		double averageTotal = 0;
		
		//this variable will hold sum of all bills
		
		double sumTotal = 0;
		
		//Iterate through array of totals and sums each single one
		
		for (int i = 0; i<totals.length; i++) {
			sumTotal += totals[i];
		}
		
		//To find average bill, sum of all totals is divided by number of totals
		
		return averageTotal = sumTotal/(totals.length);
	}



}
