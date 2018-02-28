
//Sina Kamali 610394126
import java.util.Scanner;

public class SignRemainder {

	public static void main(String[] args) {
		int A = 0, B;
		Scanner scan = new Scanner(System.in);

		A = scan.nextInt();
		B = scan.nextInt();
		if (A > 0) {
			if (B > 0)
				while ((A - B) >= 0)
					A -= B;
			else if (B < 0)
				while ((A + B) >= 0)
					A += B;
		} else {
			if (B > 0) {
				while ((A + B) <= 0)
					A += B;
				if (A < 0)
					A += B;
			} else if (B < 0) {
				while ((A - B) <= 0)
					A -= B;
				if (A < 0)
					A -= B;
			}
		}
		System.out.println(A);
	}

}
