import java.io.File;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.Serializable;
//
/*
 * 
 * @author emily De Lay and Mackenzie Maierhofer
 * insurence calculator
 * 
 * In this app we will be assigning 
 * penalties for various conditions related to 
 * age, bmi, blood pressure, used by points
 */
public class DeLayMaierhoferInsurance { 
public static void welcome() { 
	System.out.println("**********************************");
	System.out.println("Welcome to the Insurance App");
	System.out.println("We take information based off of things such as age, \n"
				+ "BMI, and blood pressure, in order to help determine insurance coverage.");
	System.out.println("**********************************");
}
 public static void Menu() { //the menu of options 
	 System.out.println("1. List out the names (members) to screen");
	 System.out.println("2. Add a new member ");
	 System.out.println("3. Save members"); //text, binary, or XML
	 System.out.println("4. Load members"); //text, binary, or XML
	 System.out.println("5. Assess members");
	 System.out.println("6. Save assessments as JSON");
	 System.out.println("7. Exit");
}
 // /Users/emilydelay/Desktop/insurance.txt
 /**
 * @throws Exception **********************************************************************/ //emily de lay
 public static void main(String[] args) throws Exception { //this is the main 
		Scanner sc = new Scanner(System.in); //scanner to talk with user
		int choice = 0; //for users choice
		String choice2 = null;
		welcome();
		System.out.println("Enter the name of the file: "); //user put name of file
		String fname = sc.nextLine(); //where the data for the program will come from 
		ArrayList<Members> InsurList = MemberReader.readNamesFromTextFile(fname); //reads file;
		if (InsurList == null) {
			System.out.println("Something bad happened ."); //OOF
		} else {
			
		do { 
		    System.out.println("**********************************");
			System.out.println("Here are your choices: ");
		    Menu(); //shows menu to user
		    System.out.println("Please enter your choice: ");
			choice = sc.nextInt(); //they type their number choice
			System.out.println("**********************************");
/************************************************************************/
			if (choice == 1) {  //CHOICE 1 Emily De Lay
			    System.out.println("The members:");
			    System.out.println("**********************************");
				MemberWriter.writeMembersToScreen(InsurList);
				System.out.println("**********************************");
			}
/************************************************************************/
			if (choice == 2) { //CHOICE 2 Mackenzie Maierhofer
				 System.out.println("Now adding a new member...");
				 MemberWriter.addNewMember(InsurList);
			}
/*************************************************************************/
			 // /Users/emilydelay/Desktop/insurance.txt
			if (choice == 3) {
				//save members
				System.out.println("Save in (B)inary, save in (T)ext, "
						+ "save in (X)ML ?");
				System.out.println("Enter your choice: ");
				sc.nextLine(); //needs to read over a line
				choice2 = sc.nextLine();
				
				if (choice2.equalsIgnoreCase("B")) {
					
					System.out.println("Going to save members to binary: ");
					System.out.print("Enter filename: ");
					fname = sc.nextLine();
					MemberWriter.writeMembersToBinary(fname, InsurList);
		        
				}
		        if (choice2.equalsIgnoreCase("T")) {
		        	System.out.println("Going to save members to a text file: ");
		        	System.out.print("Enter filename: ");
		        	fname = sc.nextLine();
		        	MemberWriter.writeMembersToTextFile(fname, InsurList);
		        }
		        	
		        if (choice2.equalsIgnoreCase("X")) {		
		        	System.out.println("Going to save members to XML: ");
		        	System.out.print("Enter filename: ");
		        	fname = sc.nextLine();
		        	MemberWriter.writePeopleToXML(fname, InsurList);
				}
/***********************************************************************************/
			} if (choice == 4) { 
				// /Users/emilydelay/Desktop/binary.bin
				// /Users/emilydelay/Desktop/insurance.txt
		
				System.out.println("((B)inary, (T)ext or (X)ML? ");
				sc.nextLine();
				choice2 = sc.nextLine();
				
				if (choice2.equalsIgnoreCase("B")) { //le binary woo
					///Users/emilydelay/Desktop/binary.bin
					System.out.print("Read back from binary file \n");
					System.out.print("Enter name of input file: ");
					fname = sc.next();
			        ArrayList<Members> readFromBin = MemberReader.readFromBinary(fname);
			        MemberWriter.writeMembersToScreen(readFromBin);
			        
				} if (choice2.equalsIgnoreCase("X")) { //le xml file ww
					System.out.print("Read back from XML file \n");
					System.out.print("Enter name of input file: ");
					fname = sc.next();
					ArrayList<Members> fromXML = MemberReader.readStudentsFromXML(fname);
			        MemberWriter.writeMembersToScreen(InsurList);
					
				} if (choice2.equalsIgnoreCase("T")) { //le text file woo
					System.out.print("Read back from text file \n");
					System.out.print("Enter name of input file: ");
					fname = sc.next();
					MemberReader.readNamesFromTextFile(fname);
					MemberWriter.writeMembersToScreen(InsurList);
				}
/**********************************************************************************************/
			} if (choice == 5) {

				System.out.println("Here are the insurance assessments: \n");
				for (Members m : InsurList) {
					InsuranceScoreWriter.verdict(m);
				}
/***********************************************************************************************/				
			} if (choice == 6) {
				System.out.println("Now will write to JSON. Enter file name: ");
				sc.nextLine();
		        fname = sc.nextLine();
		        if (InsuranceScoreWriter.writeMembersToJSON(fname, InsurList) == true) {
		            System.out.println("The scores were written successfully!");
		        } else {
		            System.out.println("Something went wrong. Please try again.");
		        }
				
			}
/***********************************************************************************************/		    
		}while (choice != 7);
		System.out.println("Thanks for using the Insurance App, goodbye!");
		}
 }
		}

