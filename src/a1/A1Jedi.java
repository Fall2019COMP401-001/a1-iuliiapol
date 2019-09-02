package a1;

import java.util.ArrayList;
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

		//Array for total quantities bought of particular item

		int [] totalQuantities = new int [itemTypes];

		//Array for total number of customers that bought particular item

		int [] totalCustomers = new int [itemTypes];

		//For loop is used to get name and price of the item
		for (int i = 0; i<itemTypes; i++) {

			//scan for item name

			itemNames[i] = scan.next(); 

			//scan for item price

			itemPrice[i] = scan.nextDouble();
		}

		//scan number of customers

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

		//String array of names of bought items by current customer

		String [] boughtItemNames;

		//ArrayList boughtTypes will be used
		//to store item names in the case if 
		//one type of item is bought multiple times

		ArrayList <String> boughtTypes;

		/**
		 * Outer for loop
		 * Iterates through each customer and records data 
		 * 
		 * Read values in the following arrays
		 * firstNames, lastNames, boughtItemTypes and boughtItemTypes
		 */

		for (int i =0; i<numCustomers; i++) {

			//scan for FIRST name of the customer

			firstNames[i] = scan.next(); 

			//scan for LAST name of the customer

			lastNames[i] = scan.next(); 

			//scan for number of bought TYPES of items

			boughtItemTypes[i] = scan.nextInt();

			//keeping track of bought item names to find the match

			boughtItemNames = new String [boughtItemTypes[i]];

			for (int j = 0; j< boughtItemTypes[i]; j++) {

				//scan for item quantity of current type of product

				itemQuantity = scan.nextInt();  

				//scan for item name

				itemName = scan.next(); 

				//add itemName to boughtItemNames array

				boughtItemNames[j] = itemName;

				//calculate quantities bought of current item 

				findTotalQuantities(itemName, itemQuantity, itemNames, totalQuantities);

			}

			//finds and returns ArrayList of types of items bought by current customer

			boughtTypes = findBoughtTypes(itemNames, boughtItemNames);

			//iterates through all bought types and updates
			//information about what types of items were bought by the customer

			for (int p = 0; p<boughtTypes.size(); p++) {
				findTotalCustomers(boughtTypes.get(p), itemNames, totalCustomers);
			}

		}

		//prints out information about how many times item was bought

		printResults(itemNames, totalQuantities, totalCustomers);
	}

	/**
	 * findTotalQuantities
	 * If current item name is in list of item names, 
	 * the method increases total quantity of bought item 
	 * by current item's quantity
	 * 
	 * Input:
	 * 1) String name of current item
	 * 2) int item quantity bought of current item
	 * 3) String Array of all item types in the store
	 * 4) int array of total quantities of item types in the store
	 * 
	 * Output: void
	 * 
	 * Preconditions:
	 * 1) String currentItemName should match item name in itemNames array
	 * 2) Input arrays itemNames and totalQuantities should not be null and 
	 * must contain at least one value
	 * 3) String currentItem and int itemQuantity should not be null 
	 */

	static void findTotalQuantities(String currentItemName, int itemQuantity, String [] itemNames, int [] totalQuantities) {

		//iterates through the list of item names 
		//and searches for match with current item name

		for (int i = 0; i < itemNames.length; i++) {

			if (currentItemName.equals(itemNames[i])) {

				//if current item name is found in list of items available at the store
				//quantities of total of this particular item are increased

				totalQuantities [i] += itemQuantity; 
			}

		}
	}

	/**
	 * findBoughtTypes
	 * Finds all types of items purchased by current customer.
	 * If one type of item was purchased multiple times
	 * code will list this type only once, not multiple times
	 * 
	 * Input:
	 * 1) String array with item names 
	 * 2) String array with item names bought by the customer
	 * 
	 * Output:
	 * ArrayList String with bought item types without duplicate item types
	 * 
	 * Preconditions:
	 * 1) At least one of boughtItemNames strings must match String from item names
	 * 2) Input arrays itemNames and boughtItemNames should not be null and 
	 * must contain at least one value
	 * 
	 */

	static ArrayList <String> findBoughtTypes (String [] itemNames, String [] boughtItemNames) {

		ArrayList<String> matches =new ArrayList<String>();

		//by using two for loops, we find whether 
		//the customer bought the same type of the item more than once

		for (int i = 0; i < boughtItemNames.length; i++) {

			for (int j = i+1; j<boughtItemNames.length; j++) {

				if ((boughtItemNames[i]).equals(boughtItemNames[j])) {

					//if we already found that the customer 
					//bought particular type of the item more than once
					//program breaks out for loop and 
					//type is not added to matches one more time

					if (matches.contains(boughtItemNames[i])) {
						break;
					}

					//if we find that the customer bought particular type of item
					//more than once, then this type is added to matches 

					matches.add(boughtItemNames[i]);
				}
			}

		}

		//to have complete list of purchased types of items
		//we iterate through boughtItemNames and find
		// "unique" types of items which weren't purchased multiple times

		for (int i = 0; i < boughtItemNames.length; i++) {

			//if type is not in list of the matches

			if (matches.contains(boughtItemNames[i]) == false) {

				//then type is added to the list

				matches.add(boughtItemNames[i]);
			}
		}

		//returns ArrayList of types of items bought by the customer

		return matches;
	}
	//now that's time to add count of customers
	//two methods
	//(1) to add quantities because those are different - DONE
	//(2) to add customers

	/**
	 * findTotalCustomers
	 * Finds total number of customers who purchased certain type of item
	 * from the list of matches found in the method findBoughtTypes
	 * 
	 * Input: 
	 * 1) String with name of type of item from matches ArrayList
	 * (see findBoughtTypes method)
	 * 2) String array itemNames with types of items in the store
	 * 3) int array totalCustomers which keeps track of how many customers
	 * bought certain type of item
	 * 
	 * Output: Void
	 * 
	 * Preconditions:
	 * 1) Input arrays itemNames and totalCustomers should not be null and 
	 * must contain at least one value
	 * 2) String match should match with string from itemNames array
	 * 
	 */

	static void findTotalCustomers (String match, String [] itemNames, int [] totalCustomers) {

		//iterates through the list of item names

		for (int i = 0; i<itemNames.length; i++) {

			if (match.equals(itemNames[i])) {

				//if match type is in itemNames, then total customers
				//for this particular type is increased by 1

				totalCustomers[i] += 1;
			}

		}
	}

	/**
	 * printResults
	 * Method prints out results in the following format:
	 * "NUMBER customers bought TOTAL ITEM"
	 * If some type wasn't bought, then there will following message
	 * "No customers bought ITEM"
	 * 
	 * Input:
	 * 1) String Array with itemNames
	 * 2) int array with total quantities of types of items
	 * 3) int array with total number of customers which bought
	 * particular types of items
	 * 
	 * Output: Void
	 * 
	 * Preconditions:
	 * Input arrays itemNames, totalQuantities and totalCustomers
	 * should not be null and must contain at least one value
	 * 
	 */

	static void printResults (String [] itemNames, int [] totalQuantities, int [] totalCustomers) {

		//iterates through the list of item types

		for (int i = 0; i<itemNames.length; i++) {

			//if some type wasn't bought by any customer

			if (totalQuantities[i] == 0) {

				//prints out this message

				System.out.println("No customers bought " + itemNames[i]);

			} else {

				//if some type was bought by at least one customer
				//then following message will be printed out

				System.out.println(totalCustomers[i] + " customers bought " + totalQuantities [i] + " " + itemNames[i]);
			}

		}
	}
}
