import java.util.ArrayList;

//Maierhofer DeLay

// calculates the health insurance score

public class Assessor {
	
	public static int calcAgeRisk (Members m) {
		int score = 0;
		int height, weight, BPSy, BPdias;
		String cancer, diabetes, Alzheimers;
		int age = m.getAge();
		if (age <= 29) {
			score = score;
		}
		if (age <= 44) {
			score = score + 10;
		}
		if (age <= 59) {
			score = score + 20;
		}
		else {
			score = score + 30;
		}
		System.out.println(score);
		return score;
	}
	
	public static int calcBMIRisk (ArrayList<Members> InsurList) {
		int score = calcAgeRisk(InsurList);
		int age, height, weight, BPsy, BPdias;
		String cancer, diabetes, Alzheimers;
		double weightKg;
		double heightMeters;
		double BMI;
		weightKg = weight / 2.2046;
		heightMeters = height / 39.3701;
		BMI = weightKg / (heightMeters * heightMeters);
		if (BMI >= 18.5 && BMI <= 24.9) {
			score = score;
		}
		if (BMI >= 25 && BMI <= 29.9) {
			score = score + 30;
		}
		else {
			score = score + 75;
		}
		return score;
	}
	
	public static int calcRiskScore (ArrayList<Members> InsurList) {
		int age;
		for (Members m : InsurList) {
			age = ((ArrayList<Members>) InsurList).getAge();
		}
	}

}
