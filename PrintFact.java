
//Sina Kamali 610394126
import java.util.Scanner;

public class PrintFact {

	public static void main(String[] args) {
		int A, B, C;
		Scanner scan = new Scanner(System.in);

		A = scan.nextInt();
		B = scan.nextInt();
		C = scan.nextInt();
		A++;

		while (A < B) {
			if ((A % C) == 0) // If the operator '%' is allowed
				System.out.println(A);
			A += 1;
		}
	}

}
