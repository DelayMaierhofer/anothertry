import java.util.ArrayList;

//Maierhofer DeLay

// calculates the health insurance score

public class Assessor {
	
	public static int calcAgeRisk (ArrayList<Members> InsurList) {
		int ageScore = 0;
		int age = 0;
		for (Members m : InsurList) {
			age = m.getAge();
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
			//System.out.println(score);
		}
		return ageScore;
	}
	
	public static int calcBMIRisk (ArrayList<Members> InsurList) {
		int bScore = 0;
		int age, height, weight; 
		double weightKg;
		double heightMeters;
		double BMI;
		for (Members m : InsurList) {
			System.out.print(m.getAge());
			weight = m.getWeight();
			weightKg = weight / 2.2046;
			height = m.getHeight();
			heightMeters = height / 39.3701;
			BMI = weightKg / (heightMeters * heightMeters);
			if (BMI >= 18.5 && BMI <= 24.9) {
				bScore = bScore;
			}
			else if (BMI >= 25 && BMI <= 29.9) {
				bScore = 30;
			}
			else {
				bScore = 75;
			}
			System.out.println(bScore);
		}
		
		return bScore;
	}
	
	public static int calcBPRisk (ArrayList<Members> InsurList) {
		int BPScore = 0;
		int BPSy = 0, BPdias = 0;
		for (Members m : InsurList) {
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
			System.out.println(BPScore);
		}
		return BPScore;
	}
	
	public static int calcFamD (ArrayList<Members> InsurList) {
		String diabetes = null;
		String d = "y";
		int Dscore = 0;
		for (Members m : InsurList) {
			diabetes = m.getDiabetes();
			System.out.println(diabetes);
			if (diabetes.equals(d)) {
				Dscore = 10;
			}
			else {
				Dscore = Dscore;
			}
			
			System.out.println(Dscore);
		}
		return Dscore;
	}

}
