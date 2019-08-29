package a1;

import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		// Your code follows here.

		//Scanner accepts number of customers.
		//Number of customers also determines size of ALL arrays

		int numCustomers = scan.nextInt();

		//String array firstNames will contain FIRST names of ALL customers

		String [] firstNames = new String [numCustomers];

		//String array lastNames will contain LAST names of ALL customers

		String [] lastNames = new String [numCustomers];

		/*
		 * String array boughtItems will contain information about
		 * how many types of items EACH customer bought
		 * */
		int [] boughtItems = new int [numCustomers];

		/*
		 * Following lines set up variables 
		 * necessary for getting information about bought items
		 * */
		int itemQuantity; //integer quantity of the item bought
		String itemName; //name of the item
		double itemPrice; //price of the item
		double totalPrice = 0; //will hold spent total by current customer

		//Double array totalPrices will hold 
		//totals of purchases of each customer
		double [] totalPrices = new double [numCustomers];

		/*
		 * Outer for-loop 
		 * 
		 * Read values in the following arrays:
		 * firstNames, lastNames and boughtItems
		 * */
		for (int i = 0; i<numCustomers; i++) {

			firstNames[i] = scan.next(); //scan for FIRST name of the customer

			lastNames [i] = scan.next(); //scan for LAST name of the customer

			//scan for NUMBER of types of bought items by current customer
			boughtItems[i] = scan.nextInt(); 

			/*
			 * Inner for-loop
			 * 
			 * Gets information about bought items and 
			 * calculates total price spent on items
			 */
			for (int j = 0; j<boughtItems[i]; j++) {
				itemQuantity = scan.nextInt(); //scan for item quantity of current type of product
				itemName = scan.next(); //scan for item name
				itemPrice = scan.nextDouble(); //scan for item's price

				totalPrice += itemQuantity*itemPrice; //total price of the purchase

			}


			// Sets total price spent on items for the current customer
			totalPrices[i] = totalPrice;

			//resets total price for the next customer
			//it prevents summation of total prices for current and next customers
			totalPrice = 0;
		}

		//calls print result method
		printResult (numCustomers, firstNames, lastNames, totalPrices);

		// All input parsed, so close scanner
		scan.close();

	}

	/**
	 * printResult
	 * 
	 * Prints out the result for each customer in the following format:
	 * F. LAST: TOTAL
	 * 
	 * Input: int of customers, String array with first names, 
	 * String with last names, Double string with totals spent by customers
	 * 
	 * Output: Null, prints out results
	 * 
	 * Preconditions: 
	 * Arrays shouldn't be empty
	 */
	static void printResult (int numCustomers, String [] firstNames, 
			String [] lastNames, double [] totalPrices) {
		for (int i = 0; i<numCustomers; i++) {
			System.out.println(firstNames[i].charAt(0) + ". " + lastNames[i] + ": " 
					+ String.format("%.2f", totalPrices[i]));
		}
	}
}

