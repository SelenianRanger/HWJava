
//Sina Kamali 610394126
import java.util.Scanner;

public class PatternMatching {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		char cont = 'y';
		while (cont == 'y' || cont == 'Y') {
			System.out.println("----------------------");

			char[] source = scan.next().toUpperCase().toCharArray();
			char[] pattern = scan.next().toUpperCase().toCharArray();
			boolean out = false;

			for (int i = 0; i <= source.length - pattern.length; i++)
				if (source[i] == pattern[0])
					for (int j = 0; j < pattern.length; j++) {
						if (source[i] != pattern[j]) {
							i--;
							out = false;
							break;
						}
						if (out)
							break;
						i++;
						out = true;
					}
			if (out)
				System.out.println("found");
			else
				System.out.println("not found");

			System.out.println("----------------------Continue?");
			cont = scan.next().charAt(0);
		}
	}

}
