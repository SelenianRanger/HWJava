
//Sina Kamali 610394126
import java.util.Scanner;

public class PrintChar_alt {

	public static boolean number(String in, int at) {
		if (in.charAt(at) >= '0' && in.charAt(at) <= '9')
			return true;
		else
			return false;
	}

	public static boolean letter(String in, int at) {
		if ((in.charAt(at) >= 'a' && in.charAt(at) <= 'z') || (in.charAt(at) >= 'A' && in.charAt(at) <= 'Z'))
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String num = new String(), letter = new String(), misc = new String(), in = new String();
		int at = 0;

		in = scan.nextLine();

		while ((at + 1) <= in.length()) {
			if (number(in, at))
				num += in.charAt(at);
			else if (letter(in, at))
				letter += in.charAt(at);
			else if (in.charAt(at) != ' ')
				misc += in.charAt(at);

			if ((at + 1) == in.length())
				break;
			at++;
		}
		System.out.println(letter + '\n' + num + '\n' + misc);

	}

}
