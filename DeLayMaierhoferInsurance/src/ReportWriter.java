//DeLay & Maierhofer

import java.io.FileOutputStream;


import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;
import java.beans.XMLEncoder;
import java.io.Serializable;
import org.json.simple.*;

//writes the information to the screen

//emily delay
public class ReportWriter {
	/*
	 * this class consists of funtions that allow the data to be written into various
	 * formats, a text file, binary, xml, JSON
	 * also can write the data to the screen
	 * 
	 */
	//I really dont know how to do this part so I will just leave this here 
	public static boolean writeMembersToJSON(String fname, 
			ArrayList<Members> insurList) {
		try {
            PrintWriter pw = new PrintWriter(new BufferedWriter(new
                FileWriter(fname)));
            // create a JSON object for each student
            JSONObject MemObj;
            JSONArray array = new JSONArray();
            for (in : insurList) {
                MemObj = new JSONObject();
                MemObj.put("customer", stu.getName());
               
                array.add(MemObj);
            }
            JSONObject outer = new JSONObject();
            outer.put("Customers", array);
            pw.println(outer.toJSONString());
            pw.close();
            return true;
        } catch (Exception ex) {
            return false;
        }
	}
 

	public static void writeMembersToScreen(ArrayList<Members> InsurList) { //writes to screen
		for (Members Insur : InsurList) {
			System.out.println(Insur);
		}
	}
	
	   public static boolean writeMembersToTextFile(String fname,   //write to txt file - Emily De Lay
			    ArrayList<Members> customer) {
			        try {
   PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(fname)));
			        for (Members m: customer) {
			                pw.println(m);
			            }
			            pw.close();
			            return true;
			        } catch (Exception ex) {
			            return false;
			        }
			    }
	   
	    public static boolean writePeopleToXML(String fname, //write to xml - Emily De Lay
	    	    ArrayList<Members> mem) {
	    	        try {
	    	        	
	    	            XMLEncoder enc = new XMLEncoder(new BufferedOutputStream(new
	    	                    FileOutputStream(fname)));
	    	            enc.writeObject(mem);
	    	            enc.close();
	    	            return true;
	    	        } catch (Exception ex) {
	    	            return false;
	    	        }
	    	    }
	   
	
	public static boolean writeMembersToBinary(String fname,  //writes to binary function - Emily De Lay
		    ArrayList<Members> customer) {
		        try {
		            ObjectOutputStream oof = new ObjectOutputStream(new FileOutputStream(fname));
		            oof.writeObject(customer);
		            oof.close();
		            return true;
		        } catch (Exception ex) {
		        		ex.printStackTrace();
		            return false;
		        }
	}
	//Mackenzie Maierhofer
	/*
	 * addnew member function allows user to enter their own data
	 */
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

