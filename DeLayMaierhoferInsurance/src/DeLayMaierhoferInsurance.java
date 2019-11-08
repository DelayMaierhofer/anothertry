import java.util.ArrayList;
import java.util.Scanner;
/*emily De Lay and Mackenzie Maierhofer's project
 * insurence calculator
 * 
 * In this app we will be assigning 
 * penalties for various conditions related to 
 * age, bmi, blood pressure, used by points
 */
public class DeLayMaierhoferInsurance { 

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
 /************************************************************************/ //emily de lay
 public static void main(String[] args) { //this is the main 
		Scanner sc = new Scanner(System.in); //scanner to talk with user
		int choice = 0; //for users choice
		welcome();
		System.out.println("Enter the name of the file: "); //user put name of file
		String fname = sc.nextLine(); //where the data for the program will come from 
		ArrayList<Members> InsurList = MemberReader.readNamesFromTextFile(fname); //reads file;
		if (InsurList == null) {
			System.out.println("Something bad happened ."); //OOF
		} else {
		do { 
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
			if (choice == 3) {
				
			}
			
			
		}while (choice != 7);
		
		System.out.println("thanks for using this bye");
		}	
	}

	

}