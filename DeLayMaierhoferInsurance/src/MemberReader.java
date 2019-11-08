//DeLay & Maierhofer

//reads the insurance file 
/*
 *Member Reader Class- 
 *This class is meant to read the tabbed file
 *And put it into an array list
 */
import java.util.ArrayList;    
import java.util.Scanner;
import java.io.File;
public class MemberReader {
			/************************************************************************/ 
	public static ArrayList<Members> readNamesFromTextFile(String fname) { 
		try {
			ArrayList<Members> InsurList = new ArrayList<Members>();
			Scanner fsc = new Scanner(new File(fname));
			String line;
			String[] parts;
			//the variables are listed below 
			String name; String lastname; int age; int height;
			int weight; int BPSy; int BPdias; String cancer;
			String diabetes; String Alzheimers;
			/************************************************************************/ //Emily De Lay
			//breaks the tabbed file up in parts 
			while (fsc.hasNextLine()) {
				line = fsc.nextLine().trim();
				parts = line.split("\t"); //the file is tab 
				//System.out.println(line);
				name = parts[0].trim();  //string name
				lastname = parts[1].trim(); //string lastname
				age = Integer.parseInt(parts[2]);  //int age
			    height = Integer.parseInt(parts[3]); //int height
			    weight = Integer.parseInt(parts[4]); //int weight
			    BPSy = Integer.parseInt(parts[5]); //int BPSy
			    BPdias = Integer.parseInt(parts[6]); //int BPdias
			    cancer = parts[7].trim(); //string cancer
			    diabetes = parts[8].trim();; //string diabetes
			    Alzheimers = parts[9].trim();; //string Alzheimers
			    
			    
			    InsurList.add(new Members(name, lastname, age, height, weight, 
			    		BPSy, BPdias, cancer, diabetes, Alzheimers)); 
			 /************************************************************************/
			}
			
			fsc.close(); //closing the file
			return InsurList; //returns the array list 
			
		}catch (Exception ex){
			ex.printStackTrace();
			return null; //null if file can't be read
		}
		
	
	}
}

