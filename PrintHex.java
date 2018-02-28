
//Sina Kamali 610394126
import java.util.Scanner;

public class PrintHex {

	public static char hex(int[] in, int at) {
		int val = 0;
		for (int i = 0; i < 4; i++)
			val += in[at + i] * Math.pow(2, 3 - i);
		if (val >= 10)
			val += 'A' - 10;
		else
			val += '0';
		return (char) val;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		char cont = 'y';
		while (cont == 'y' || cont == 'Y') {
			System.out.println("----------------------");

			int n = scan.nextInt();
			int[] in = new int[n];

			for (int i = 0; i < n; i++)
				in[i] = scan.nextInt();

			for (int i = 0; i < n; i += 4)
				System.out.print(hex(in, i));
			System.out.println();

			System.out.println("----------------------Continue?");
			cont = scan.next().charAt(0);
		}

	}

}
