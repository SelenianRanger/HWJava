import java.util.Scanner;

public class Expon {

	public static double Expo(int x, int p) {
		int denum = 0;
		double out = 0, cur = 1;

		while (p >= 0) {
			out += cur;
			cur *= x / (denum + 1.0);
			denum++;
			p--;
		}
		return out;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int p, x;
		char cont = 'y';

		while (cont == 'y' || cont == 'Y') {
			System.out.println("----------------------");
			x = scan.nextInt();
			p = scan.nextInt();

			System.out.println(Expo(x, p));
			System.out.println("----------------------Continue?");
			cont = scan.next().charAt(0);
		}
	}

}
