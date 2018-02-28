
//Sina Kamali 610394126
import java.util.Scanner;

public class incString {

	public static String reverse(String in) {
		String out = "";
		for (int i = in.length() - 1; i >= 0; i--)
			out += in.charAt(i);
		return out;
	}

	public static String inc(String in) {
		String out = "";
		int i = in.length() - 1;
		for (; in.charAt(i) == '9' && i > 0; i--) {
			out += "0";
		}
		if (in.charAt(i) == '9')
			out += "01";
		else {
			out += (char) (in.charAt(i) + 1);
			i--;
			for (; i >= 0; i--)
				out += (char) in.charAt(i);
		}
		return reverse(out);
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		char cont = 'y';
		while (cont == 'y' || cont == 'Y') {
			System.out.println("----------------------");

			String num = scan.next();

			System.out.println(inc(num));

			System.out.println("----------------------Continue?");
			cont = scan.next().charAt(0);
		}
	}

}
