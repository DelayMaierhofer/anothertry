import java.util.ArrayList;

//Maierhofer DeLay

// calculates the health insurance score

public class Assessor {
	
	public static int calcAgeRisk (ArrayList<Members> InsurList) {
		int score = 0;
		int age = 0;
		for (Members m : InsurList) {
			age = m.getAge();
			//System.out.println(age);
			if (age <= 29) {
				score = 0;
			}
			else if (age >= 30 && age < 45) {
				score = 10;
			}
			else if (age >= 45 && age < 60) {
				score = 20;
			}
			else {
				score = 30;
			}
			//System.out.println(score);
		}
		return score;
	}
	
	public static int calcBMIRisk (ArrayList<Members> InsurList) {
		int score = 0;
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
			score = calcAgeRisk(InsurList);
			if (BMI >= 18.5 && BMI <= 24.9) {
				score = score;
			}
			if (BMI >= 25 && BMI <= 29.9) {
				score = score + 30;
			}
			else {
				score = score + 75;
			}
			System.out.println(score);
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
