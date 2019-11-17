import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class InsuranceScoreWriter {
	
	public static String verdict (Members m) { //Maierhofer
		String lastname = m.getLastname();
		String name = m.getName();
		String verdict = null;
		int total = Assessor.tScore(m);
		if (total <= 20) {
			verdict = "low risk";
		}
		else if (total <= 50) {
			verdict = "moderate risk";
		}
		else if (total <= 75) {
			verdict = "high risk";
		}
		else {
			verdict = "uninsurable";
		}
		//System.out.println("Here are the insurance assessments: ");
		System.out.printf("Name: %s, %s \n", lastname, name);
		System.out.printf("Score: %d \n", total);
		System.out.printf("Verdict: %s \n",verdict);
		System.out.println();
		return verdict;
	}
	
	public static boolean writeMembersToJSON(String fname, //DeLay and Maierhofer
			ArrayList<Members> insurList) { 
		try {
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(fname)));
            // create a JSON object for each student
            JSONObject MemObj;
            JSONArray array = new JSONArray();
            for (Members in : insurList) {
                MemObj = new JSONObject();
                MemObj.put("First Name", in.getName());
                MemObj.put("Last Name", in.getLastname());
                int Score = Assessor.tScore(in);
                MemObj.put("Score", Score);
                String verdict = verdict(in);
                MemObj.put("Verdict", verdict);
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

}
