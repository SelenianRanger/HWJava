
//Sina Kamali 610394126
import java.util.Scanner;

public class SignComp {

	public static void main(String[] args) {
		int A, B, C, D;
		Scanner scan = new Scanner(System.in);

		A = scan.nextInt();
		B = scan.nextInt();
		C = A;
		D = B;

		if (A >= 0 && B < 0)
			System.out.println(B + "\n" + A);
		else if (B >= 0 && A < 0)
			System.out.println(A + "\n" + B);
		else if (B < 0 && A < 0) {
			while (C != 0 && D != 0) {
				C++;
				D++;
			}
			if (C == 0)
				System.out.println(B + "\n" + A);
			else
				System.out.println(A + "\n" + B);
		} else {
			while (C != 0 && D != 0) {
				C--;
				D--;
			}
			if (C == 0)
				System.out.println(A + "\n" + B);
			else
				System.out.println(B + "\n" + A);
		}
	}

}
