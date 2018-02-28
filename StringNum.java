
//Sina Kamali 610394126
import java.util.Scanner;

public class StringNum {

	public static long toNum(String in) {
		int out = 0;
		for (int i = 0; (i + 1) <= in.length(); i++) {
			out += (in.charAt(in.length() - i - 1) - 48) * Math.pow(10, i);
		}
		return out;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		char cont = 'y';
		while (cont == 'y' || cont == 'Y') {
			System.out.println("----------------------");

			String in = scan.nextLine();
			System.out.println(toNum(in.concat(scan.nextLine())));

			System.out.println("----------------------Continue?");
			cont = scan.next().charAt(0);
		}
	}

}
