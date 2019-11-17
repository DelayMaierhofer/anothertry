
public class InsuranceScoreWriter {
	public static void verdict (Members m) {
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
		System.out.printf("Name: %20s, %s \n", lastname, name);
		System.out.printf("Score: %26d \n", total);
		System.out.printf("Verdict: %26s \n",verdict);
		System.out.println();
	}

}
