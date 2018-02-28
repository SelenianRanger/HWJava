
//Sina Kamali 610394126
import java.util.Scanner;

public class Diamond {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		char a = scan.next().charAt(0);

		for (int i = 1; i < (2 * n); i++) {
			for (int t = 1; t <= Math.abs((n - i)); t++)
				System.out.print(' ');
			for (int t = 1; t <= ((2 * n - 1) - 2 * Math.abs((n - i))); t++)
				System.out.print(a);
			System.out.println();

		}
	}
}
