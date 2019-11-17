import java.util.ArrayList;
//Maierhofer DeLay
// calculates the health insurance score
public class Assessor { //Mackenzie
	
	public static int calcAgeRisk (Members m) { //accounts for the factor of age
		int ageScore = 0;
		int age = 0;
		age = m.getAge(); //get the age for this specific member
		//System.out.println(age);
		if (age <= 29) {
			ageScore = 0;
		}
		else if (age >= 30 && age < 45) {
			ageScore = 10;
		}
		else if (age >= 45 && age < 60) {
			ageScore = 20;
		}
		else {
			ageScore = 30;
		}
		//System.out.println(ageScore);
		return ageScore;
	}
	
	public static int calcBMIRisk (Members m) { //account for the factor of BMI
		int bScore = 0;
		int age, height, weight; 
		double weightKg; //weight converted into Kg.
		double heightMeters; //height converted into meters.
		double BMI;
		//System.out.println(m.getAge());
		weight = m.getWeight();
		weightKg = weight / 2.2046;
		height = m.getHeight();
		heightMeters = height / 39.3701;
		BMI = weightKg / (heightMeters * heightMeters); //BMI equation 
		if (BMI >= 18.5 && BMI <= 24.9) {
			bScore = bScore;
		}
		else if (BMI >= 25 && BMI <= 29.9) {
			bScore = 30;
		}
		else {
			bScore = 75;
		}
		//System.out.println(bScore);
		return bScore;
	}
	
	public static int calcBPRisk (Members m) { //accounts for the factor of BP
		int BPScore = 0;
		int BPSy = 0, BPdias = 0;
		BPSy = m.getBPSy();
		BPdias = m.getBPdias();
		if (BPSy < 120 && BPdias < 80) { //normal
			BPScore = BPScore;
		}
		else if (BPSy <= 129 && BPdias < 80) { //elevated
			BPScore = 15;
		}
		else if (BPSy <= 139 || BPdias < 89) { //stage 1
			BPScore = 30;
		}
		else if (BPSy >= 140 || BPdias >= 90) { //stage 2
			BPScore = 75;
		}
		else if (BPSy > 180 || BPdias > 120) { //crisis
			BPScore = 100;
		}
		//System.out.println(BPScore);
		return BPScore;
	}
	
	public static int calcFamD (Members m) { //accounts for the factor of diabetes
		String diabetes = null;
		int Dscore = 0;
		diabetes = m.getDiabetes();
		//System.out.println(diabetes);
		if (diabetes.equalsIgnoreCase("y")) { //if theres a history, their score will be 10 
			Dscore = 10;
		}
		else {
			Dscore = Dscore;
		}		
		//System.out.println(Dscore);
		return Dscore;
	}
	
	public static int calcFamC (Members m) { //accounts for the factor of cancer
		String cancer = null;
		int CScore = 0;
		cancer = m.getCancer();
		//System.out.println(cancer);
		if (cancer.equalsIgnoreCase("y")) {
			CScore = 10;
		} else {
			CScore = CScore;
		}
		//System.out.println(CScore);
		return CScore;
	}
	
	public static int calcFamA (Members m) { //accounts for the factor of alzheimers
		String Alzheimers = null;
		int AScore = 0;
		Alzheimers = m.getAlzheimers();
		//System.out.println(Alzheimers);
		if (Alzheimers.equalsIgnoreCase("y")) {
			AScore = 10;
		} else {
			AScore = AScore;
		}
		//System.out.println(AScore);
		return AScore;
	}
	
	public static int tScore (Members m) { //creates a total assessment score and prints it out
		int ageScore=0, bScore=0, BPScore=0,
				Dscore=0, CScore=0, AScore=0;
		ageScore = calcAgeRisk(m);
		bScore = calcBMIRisk(m);
		BPScore = calcBPRisk(m);
		Dscore = calcFamD(m);
		CScore = calcFamC(m);
		AScore = calcFamA(m);
		int total = ageScore + bScore + BPScore + Dscore + CScore + AScore;
		//System.out.println(total);
		return total;
	}
}
