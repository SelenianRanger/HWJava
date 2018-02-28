import java.util.Scanner;

public class PrintFact_alt {

	public static void main(String[] args) {
		int A, B, C, D;
		Scanner scan = new Scanner(System.in);

		A = scan.nextInt();
		B = scan.nextInt();
		D = scan.nextInt();

		while (A <= B) {
			C = A;
			if (C > 0) {
				if (D > 0)
					while ((C - D) >= 0)
						C -= D;
				else
					while ((C + D) >= 0)
						C += D;
			} else {
				if (D > 0) {
					while ((C + D) <= 0)
						C += D;
					if (C < 0)
						C += D;
				} else {
					while ((C - D) <= 0)
						C -= D;
					if (C < 0)
						C -= D;
				}
			}
			if (C == 0)
				System.out.println(A);
			A += 1;
		}
	}

}
