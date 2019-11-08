//DeLay & Maierhofer

import java.util.ArrayList;
import java.util.Scanner;

//writes the information to the screen

public class ReportWriter {

	public static void writeMembersToScreen(ArrayList<Members> InsurList) { //writes to screen
		for (Members Insur : InsurList) {
			System.out.println(Insur);
		}
	}
	//Mackenzie Maierhofer
	public static void addNewMember(ArrayList<Members> InsurList) { //adds a new member to arraylist
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter first name: ");
		String name = sc.nextLine();
		System.out.println("Enter last name: ");
		String lastname = sc.nextLine();
		System.out.println("Enter age: ");
		int age = sc.nextInt();
		System.out.println("Enter height in inches: ");
		int height = sc.nextInt();
		System.out.println("Enter weight in pounds: ");
		int weight = sc.nextInt();
		System.out.println("Enter blood pressure (sys): ");
		int BPsy = sc.nextInt();
		System.out.println("Enter blood pressure (dia): ");
		int BPdias = sc.nextInt();
		System.out.println("Has a family member ever had...");
		sc.nextLine(); //scanner needs to read over this line
		System.out.println("Cancer? ");
		String cancer = sc.nextLine();
		System.out.println("Diabetes? ");
		String diabetes = sc.nextLine();
		System.out.println("Alzheimers? ");
		String Alzheimers = sc.nextLine();
		InsurList.add(new Members(name, lastname, age, height, weight, BPsy, BPdias, cancer, diabetes, Alzheimers));
		System.out.println("The new member has been added.");
	}
}
