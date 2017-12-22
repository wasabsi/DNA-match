package edu.cofc.csci230;

import java.util.Scanner;

public class DNA {

	public static void main(String[] args) {
		//variables for the upper and lower strands
		String upperS;
		String lowerS;
		
		Scanner input = new Scanner( System.in );
		
		//get upper strand entered
		System.out.print("Enter upper DNA strand: ");
		upperS = input.nextLine();
		//get lower strand entered
		System.out.print("Enter lower DNA strand: ");
		lowerS = input.nextLine();
		
		//make both strands UPPERCASE
		upperS = upperS.toUpperCase();
		lowerS = lowerS.toUpperCase();
		
		//check for empty input from the user
		if ( upperS.isEmpty() || lowerS.isEmpty() ) {
			
			System.out.println("The entered upper or lower strand is not defined...Exiting program");
		
		//check  for same number of chemical bases in both strands
		} else if ( upperS.length() == lowerS.length() ) {
			
			// check if upper and lower strand only have ATCG chemicals
			if ( upperS.matches("[ATCG]+") && lowerS.matches("[ATCG]+") ) {
				
				char[] lowerS_array = lowerS.toCharArray();
				
				// check for base-pair errors and correct
				for ( int i=0; i< upperS.length(); i++ ) {
					
					if ( upperS.charAt(i) == 'A' && lowerS_array[i] != 'T' ) {
						
						lowerS_array[i] = 't';
						
					} else if ( upperS.charAt(i) == 'T' && lowerS_array[i] != 'A' ) {
						
						lowerS_array[i] = 'a';
						
					} else if ( upperS.charAt(i) == 'C' && lowerS_array[i] != 'G' ) {
						
						lowerS_array[i] = 'g';
						
					} else if ( upperS.charAt(i) == 'G' && lowerS_array[i] != 'C' ) {
						
						lowerS_array[i] = 'c';
						
					}
					
				}
				
				if ( !String.valueOf( lowerS_array ).matches("[ATCG]+") ) {
					
					System.out.printf("The entered double-strand DNA pattern has base-pair errors that have been corrected: %s %s\n", upperS, String.valueOf( lowerS_array ) );
					System.out.println("...Exiting program");
					
				} else {
					
					System.out.println("The entered double-strand DNA pattern is correct...Exiting program");
					
				}
					
			} else {
				
				System.out.println("The entered upper and lower strands must only contain combinations of A, G, C, or T...Exiting program");
				
			}
			
		} else {
			
			System.out.println("The entered upper and lower strands do not have the same number of chemical bases...Exiting program");

		}

		//this closes the scanner object
		input.close();
		
	}//end main method

}//end DNA class

