import java.util.Scanner;

public class DigitAdd {

	public static int DigitAdd(int in) {
		int out = 0;
		while (in != 0) {
			out += (in % 10);
			in /= 10;
		}
		return out;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int in;
		char cont = 'y';
		while (cont == 'y' || cont == 'Y') {
			System.out.println("----------------------");
			in = scan.nextInt();

			while ((in / 10) != 0) {
				in = DigitAdd(in);
			}
			System.out.println(in);
			System.out.println("----------------------Continue?");
			cont = scan.next().charAt(0);
		}
	}

}
