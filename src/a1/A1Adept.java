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
			itemNames[i] = scan.next(); //scan for item name
			itemPrice[i] = scan.nextDouble(); //scan for item price
		}

		//scans number of customers

		int numCustomers = scan.nextInt();

		//String array firstNames will contain FIRST names of ALL customers

		String [] firstNames = new String [numCustomers];

		//String array lastNames will contain LAST names of ALL customers

		String [] lastNames = new String [numCustomers];

		//int array boughtItems will contain number of bought TYPES of items
		//example: If first customer bought 5 bananas, then
		//for [0] will refer to value of 5

		int [] boughtItems = new int [numCustomers];

		int itemQuantity; //integer quantity of the item bought

		String itemName; //item name of 

		double totalSpend=0;

		double totals [] = new double [numCustomers];

		for (int i =0; i<numCustomers; i++) {
			firstNames[i] = scan.next();
			lastNames[i] = scan.next();
			boughtItems[i] = scan.nextInt();

			for (int j = 0; j<boughtItems[i]; j++) {
				itemQuantity = scan.nextInt();
				itemName = scan.next();

				totalSpend += compareItems(itemName, itemQuantity, itemNames, itemPrice);
			}
			totals[i] = totalSpend;
			totalSpend = 0; //resets total spend for next iteration
		}

		int biggestSpendingIndex = indexBiggestSpending(totals);
		int smallestSpendingIndex = indexSmallestSpending(totals);
		double averageTotal = calculateAverage(totals);

		System.out.println ("Biggest: " + firstNames[biggestSpendingIndex] + " " +  lastNames[biggestSpendingIndex]
				+ " (" + String.format("%.2f", totals[biggestSpendingIndex])+ ")");

		System.out.println ("Smallest: " + firstNames[smallestSpendingIndex] + " " +  lastNames[smallestSpendingIndex]
				+ " (" + String.format("%.2f", totals[smallestSpendingIndex])+ ")");

		System.out.println ("Average: " + String.format("%.2f", averageTotal));
	}

	//assumption entered food item will match food item entered earlier
	static double compareItems (String currentItem, int itemQuantity, String [] itemNames, double [] itemPrice) {
		double price = 0;

		for (int i = 0; i< itemNames.length; i++) {
			if (currentItem.equals(itemNames[i])) {
				price = itemPrice[i]*itemQuantity;
			}
		}
		return price;
	}

	static int indexBiggestSpending (double [] totals) {
		double biggestSpending = totals[0];
		int biggestSpendingIndex = 0;
		for (int i = 0; i<totals.length; i++) {
			if (biggestSpending < totals[i]) {
				biggestSpending = totals[i];
				biggestSpendingIndex = i;
			}
		}
		return biggestSpendingIndex;
	}

	static int indexSmallestSpending(double [] totals) {
		double smallestSpending = totals[0];
		int smallestSpendingIndex = 0;

		for (int i = 0; i<totals.length; i++) {
			if (smallestSpending > totals[i]) {
				smallestSpending = totals[i];
				smallestSpendingIndex = i;
			}
		}
		return smallestSpendingIndex;
	}

	static double calculateAverage (double [] totals) {
		double averageTotal = 0;
		double sumTotal = 0;
		for (int i = 0; i<totals.length; i++) {
			sumTotal += totals[i];
		}
		return averageTotal = sumTotal/(totals.length);
	}



}
