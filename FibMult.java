
//Sina Kamali 610394126
import java.util.Scanner;

public class FibMult {

	public static long Fibo(int A) {
		long pre1 = 1, pre2 = 2, B = 0;
		int Count = 2;
		if ((A == 0) || (A == 1)) {
			B = pre1;
		} else if (A == 2)
			B = pre2;
		else {
			while (Count < A) {
				B = pre1 * pre2;
				pre1 = pre2;
				pre2 = B;
				Count += 1;
			}
		}
		return (B);
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println(Fibo(scan.nextInt()));
	}
}
