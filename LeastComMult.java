
//Sina Kamali 610394126
import java.util.Scanner;

public class LeastComMult {

	public static int Abs(int A) {
		if (A < 0)
			return (-A);
		else
			return (A);
	}

	public static int GCD(int A, int B) {
		int C = A;
		while (C >= 1) {
			if (((A % C) == 0) && ((B % C) == 0))
				return Abs(C);
			C -= 1;
		}
		return (1);
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int A, B;

		A = scan.nextInt();
		B = scan.nextInt();

		System.out.println(Abs(A * B / GCD(A, B)));

	}

}
