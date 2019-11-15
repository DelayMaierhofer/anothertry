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
//static int count = 0;
public static void welcome() { 
	System.out.println("**********************************");
	System.out.println("Welcome to the insurance app");
	System.out.println("We take information based off of things such as age,"
				+ " bmi, and blood pressure, in order to help determine insurance");
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
 public static void countmembers(String fname) throws Exception{
	 int membercounter = 0;
	  FileReader fr = new FileReader(fname);
	  //needs to read file
	  String member = "This is the number of members found: ";
	    LineNumberReader count = new LineNumberReader(fr);
	    
	    
          while (count.readLine() != null){
        	  //since each member is on 1 line, 
        	  //we will count each line of the file.
      	membercounter++;
          }

          System.out.println(member + membercounter);
          //prints output

          count.close();
	
 }
 
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
		    //try {
				//countmembers(fname);
			//} catch (IOException e) {
				// TODO Auto-generated catch block
				
			//}
			System.out.println("Here are your choices: ");
		    Menu(); //shows menu to user
		    System.out.println("Please enter your choice: ");
			choice = sc.nextInt(); //they type their number choice
			System.out.println("**********************************");
/************************************************************************/
			if (choice == 1) {  //CHOICE 1 Emily De Lay
			    System.out.println("The members:");

			    System.out.println("**********************************");
				ReportWriter.writeMembersToScreen(InsurList);
				System.out.println("**********************************");
			}
/************************************************************************/
			if (choice == 2) { //CHOICE 2 Mackenzie Maierhofer
				 System.out.println("Now adding a new member...");
				 ReportWriter.addNewMember(InsurList);
			}
			 // /Users/emilydelay/Desktop/insurance.txt
			if (choice == 3) {
				
				//save members
				System.out.println("save in binary (B) Save in text (T) "
						+ "save in xml (X)");
				System.out.println("enter your choice: ");
				sc.nextLine(); //needs to read over a line
				choice2 = sc.nextLine();
				
				if (choice2.equalsIgnoreCase("B")) {
					
					System.out.println("Going to write members in binary: ");
					System.out.print("Enter filename: ");
					fname = sc.nextLine();
					ReportWriter.writeMembersToBinary(fname, InsurList);
		        
		        //System.out.println("Now will read them back in.");
		        //ArrayList<Members> readFromBin = MemberReader.readFromBinary(fname);
		        //ReportWriter.writeMembersToScreen(readFromBin);
				}
		        if (choice2.equalsIgnoreCase("T")) {
		        	System.out.println("Going to write members in a text file: ");
		        	System.out.print("Enter filename: ");
		        	fname = sc.nextLine();
		        	ReportWriter.writeMembersToTextFile(fname, InsurList);
		        }
		        	
		        if (choice2.equalsIgnoreCase("X")) {		
		        	System.out.println("Going to write members to xml: ");
		        	System.out.print("Enter filename: ");
		        	fname = sc.nextLine();
		        	ReportWriter.writePeopleToXML(fname, InsurList);
				}
		        /************************************************************************/
			} if (choice == 4) { 
				// /Users/emilydelay/Desktop/binary.bin
				// /Users/emilydelay/Desktop/insurance.txt
		
				System.out.println("(T)ext (B)inary, or (X)ML? ");
				sc.nextLine();
				choice2 = sc.nextLine();
				
				if (choice2.equalsIgnoreCase("B")) { //le binary woo
					///Users/emilydelay/Desktop/binary.bin
					System.out.print("read back from binary file \n");
					System.out.print("Enter name of input file: ");
					fname = sc.next();
					System.out.println("Now will read them back in.");
			        ArrayList<Members> readFromBin = MemberReader.readFromBinary(fname);
			        ReportWriter.writeMembersToScreen(readFromBin);
				} if (choice2.equalsIgnoreCase("X")) { //le xml file ww
					System.out.print("read back from xml file \n");
					System.out.print("Enter name of input file: ");
					fname = sc.next();
					ArrayList<Members> fromXML = MemberReader.readStudentsFromXML(fname);
			        ReportWriter.writeMembersToScreen(InsurList);
					
				} if (choice2.equalsIgnoreCase("T")) { //le text file woo
					System.out.print("read back from text file \n");
					System.out.print("Enter name of input file: ");
					fname = sc.next();
					ArrayList<Members> fromTxtFile = MemberReader.readNamesFromTextFile(fname);
					ReportWriter.writeMembersToScreen(InsurList);
				}
				/************************************************************************/
			} if (choice == 5) {
				for (Members m : InsurList) {
					//Assessor.calcAgeRisk(m);
					//Assessor.calcBMIRisk(m);
					//Assessor.calcBPRisk(m);
					//Assessor.calcFamD(m);
					//Assessor.calcFamC(m);
					//Assessor.calcFamA(m);
					Assessor.verdict(m);
				}
				
			} if (choice == 6) {
				System.out.print("Now will write to JSON. Enter file name: ");
		        fname = sc.nextLine();
		        if (ReportWriter.writeMembersToJSON(fname, InsurList)) {
		            System.out.println("Yay");
		        } else {
		            System.out.println("Boo");
		        }
				
			}
			/************************************************************************/		    
		}while (choice != 7);
		
		System.out.println("thanks for using this bye");
		}
 }
		}
 
		

		
