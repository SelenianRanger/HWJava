
//Sina Kamali 610394126
import java.util.Scanner;

public class SignSub {

	public static void main(String[] args) {
		int A, B;
		Scanner scan = new Scanner(System.in);

		A = scan.nextInt();
		B = scan.nextInt();

		if (B > 0)
			while (B != 0) {
				B -= 1;
				A -= 1;
			}
		else
			while (B != 0) {
				B += 1;
				A += 1;
			}
		System.out.println(A);
	}

}
