import java.util.Scanner;

public class PrintChar {

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
		int at = 0;
		String in;
		Scanner scan = new Scanner(System.in);
		in = scan.nextLine();
		while ((at + 1) < in.length()) {
			if (in.charAt(at) == ' ')
				while (in.charAt(at) == ' ') {
					if ((at + 1) == in.length())
						break;
					at++;
				}
			else if (number(in, at))
				while (number(in, at)) {
					if ((at + 1) == in.length())
						break;
					System.out.print(in.charAt(at));
					at++;
					if (!number(in, at))
						System.out.println();
				}
			else if (letter(in, at))
				while (letter(in, at)) {
					if ((at + 1) == in.length())
						break;
					System.out.print(in.charAt(at));
					at++;
					if (!letter(in, at))
						System.out.println();
				}
			else {
				System.out.print(in.charAt(at));
				System.out.println();
				at++;
			}

		}
		System.out.print(in.charAt(at));
		System.out.println();

	}

}