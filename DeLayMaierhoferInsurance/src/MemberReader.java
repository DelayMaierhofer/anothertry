/*//DeLay & Maierhofer  

*Member Reader Class- Emily De Lay
 *This class is meant to read the tabbed file
 *And put it into an array list
 */
//reads the insurance file
import java.util.ArrayList;    
import java.util.Scanner;
import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
public class MemberReader {
	/************************************************************************/ //Emily De Laypublic class MemberReader {
   
	public static ArrayList<Members> readFromBinary(String fname) { //read from binary
     //   int count = 0;
    	try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fname));
            //@SuppressWarnings("unchecked")
			ArrayList<Members> result = (ArrayList<Members>)ois.readObject();
            ois.close();
   /*         for (Members r : result) {
            	count = count + 1;
            }
            //ois.close();
            System.out.printf("%d members were read.", count); */
            return result;
        } catch (Exception ex) {
        	ex.printStackTrace();
        	return null;
        }
    }
     /*@return 
     * the function returns the file writen in binary
     * if there is an error, the file returns nothing (null)
     */ 
	/************************************************************************/ //Emily De Lay
	public static ArrayList<Members> readStudentsFromXML(String fname) {
		try {
			XMLDecoder dec = new XMLDecoder(new BufferedInputStream(new 
					FileInputStream(fname)));
			ArrayList<Members> result = (ArrayList<Members>)dec.readObject();
			dec.close();
			
			return result;
		} catch (Exception ex) {
			return null;
		}
		}
	 /*@return 
	 * the function returns the xml file ,
	 * if there is an error, nothing will return (null)
	 */	
	/************************************************************************/ 
	public static ArrayList<Members> readNamesFromTextFile(String fname) { 
		try {
			ArrayList<Members> InsurList = new ArrayList<Members>();
			Scanner fsc = new Scanner(new File(fname));
			String line;
			String[] parts;
			int count = 0;
			//the variables are listed below 
			String name; String lastname; int age; int height;
			int weight; int BPSy; int BPdias; String cancer;
			String diabetes; String Alzheimers;
			/************************************************************************/ //Emily De Lay
			//breaks the tabbed file up in parts 
			count = 0;
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
			    count = count + 1;
			 /************************************************************************/
			}
			
			fsc.close(); //closing the file
			System.out.printf("%d members were read in.\n",count);
			return InsurList; //returns the array list 
			
		}catch (Exception ex){
			ex.printStackTrace();
			return null; //null if file can't be read
		}
		
	
	}
}
