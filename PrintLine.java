import java.util.Scanner;

public class PrintLine {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		char cont = 'y';

		while (cont == 'y' || cont == 'Y') {
			System.out.println("----------------------");
			int rows = 0, count = 0, c;
			String in = "*";
			char ch;

			rows = scan.nextInt();
			count = scan.nextInt();
			while (count < rows) {
				System.out.println("Count ERROR");
				rows = scan.nextInt();
				count = scan.nextInt();
			}
			in = scan.next();
			while (in.length() != 1) {
				System.out.println("Char ERROR");
				in = scan.nextLine();
			}
			ch = in.charAt(0);

			while (rows >= 1) {
				c = count;
				while (c >= 1) {
					System.out.print(ch);
					c--;
				}
				System.out.println();
				count--;
				rows--;
			}
			System.out.println("----------------------Continue?");
			cont = scan.next().charAt(0);
		}
	}

}
