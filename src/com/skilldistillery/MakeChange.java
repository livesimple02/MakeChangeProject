package com.skilldistillery;

import java.util.Scanner;

public class MakeChange {

	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		// Initialize variables for main
		float price = 0;
		float paid = 0;
		int changeNeeded = 0;
		boolean keepGoing = true;
		
		// Do-while loop allows for multiple transactions
		do {
			String finalResultStr = "";
			
			// Get values from user
			System.out.print("Enter the total cost: ");
			price = input.nextFloat();
			System.out.print("Enter the amount paid: ");
			paid = input.nextFloat();
			
			// Convert from float to integer. + 0.001 allow for inaccuracies in float variable to avoid truncating a penny
			changeNeeded = (int)(((paid - price)+.001)*100);
			
			System.out.printf("\nAmount Due: $%.2f | Amount Tendered: $%.2f\n\n    Change Due\n------------------\n" , price, paid);
			
			// Check to see if any change is needed
			if (changeNeeded < 0) {
				System.out.println("Not enough money tendered! Please try again.\n");
			}
			
			else if (changeNeeded == 0) {
				System.out.println("$0 - Thank you for paying the exact amount!\n");
			}
			
			// If change needed, build final output string by checking each denomination and reducing change needed as applicable
			else {
				finalResultStr += getChange(changeNeeded, 2000);
				changeNeeded = changeNeeded % 2000;
				
				finalResultStr += getChange(changeNeeded, 1000);
				changeNeeded = changeNeeded % 1000;
				
				finalResultStr += getChange(changeNeeded, 500);
				changeNeeded = changeNeeded % 500;
				
				finalResultStr += getChange(changeNeeded, 100);
				changeNeeded = changeNeeded % 100;
				
				finalResultStr += getChange(changeNeeded, 25);
				changeNeeded = changeNeeded % 25;
				
				finalResultStr += getChange(changeNeeded, 10);
				changeNeeded = changeNeeded % 10;
				
				finalResultStr += getChange(changeNeeded, 5);
				changeNeeded = changeNeeded % 5;
				
				finalResultStr += getChange(changeNeeded, 1);
				
				System.out.println(finalResultStr + "------------------");
			}
			
			// Check to see if user wants to perform additional transactions
			keepGoing = anotherTransact();
			
		} while (keepGoing);
		
		input.close();
		
	} // End of Main Method

	
	
	
	// Method to determine number of bills or coins needed by denomination value passed from main.
	public static String getChange(int changeNeeded, int denomination) {
		
		int billCoinQty = changeNeeded / denomination;
		
		if (billCoinQty == 0) {
			return "";
		}
			
		else {
			return (getDenominationDesc(denomination) + billCoinQty + "  |\n");
		}
						
	} // End of getChange method
	
	
	
	// Method to return description based on denomination
	public static String getDenominationDesc(int denomination) {
		
		String denominationDesc = "";
		
		switch (denomination) {
		case 2000:
			denominationDesc = "| $20 bills : ";
			break;
		case 1000:
			denominationDesc = "| $10 bills : ";
			break;
		case 500:
			denominationDesc = "|  $5 bills : ";
			break;
		case 100:
			denominationDesc = "|  $1 bills : ";
			break;
		case 25:
			denominationDesc = "|  Quarters : ";
			break;
		case 10:
			denominationDesc = "|     Dimes : ";
			break;
		case 5:
			denominationDesc = "|   Nickels : ";
			break;
		case 1:
			denominationDesc = "|   Pennies : ";
		}
		return denominationDesc;
		
	}	// End of getDenominationDesc method
	
	
	
	// Method to check if user wants to perform another transaction
	public static boolean anotherTransact() {
		
		boolean waitForResponse = true;
		boolean keepGoing = true;
		
		System.out.print("Would you like to perform another transaction? Press 'Y' or 'N': ");
		
		while (waitForResponse) {
			
			String userResponse = input.next();
			
			if (userResponse.equalsIgnoreCase("N")) {
				System.out.println("\nGoodbye");
				waitForResponse = false;
				keepGoing = false;
			}
			
			else if (userResponse.equalsIgnoreCase("Y")) {
				System.out.println();
				waitForResponse = false;
				keepGoing = true;
			}
			
			else {
				System.out.print("\nCommand not recognized, please enter 'Y' or 'N': ");
			}
			
		}
		return keepGoing;
		
	} // End of anotherTransact method
	
	
} // End of Class
