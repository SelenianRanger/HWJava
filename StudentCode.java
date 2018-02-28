
//Sina Kamali 610394126
import java.util.Scanner;

public class StudentCode {

	public static int toInt(char in) {
		return (in - 48);
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		char cont = 'y';
		while (cont == 'y' || cont == 'Y') {
			System.out.println("----------------------");
			int grade = scan.nextInt();
			long id = scan.nextInt();
			int odd = 0, even = 0, count = 0;

			while (id > 0) {
				if (count % 2 == 1)
					even += (id % 10) * Math.pow(10, count / 2);
				else
					odd += (id % 10) * Math.pow(10, count / 2);
				count++;
				id /= 10;
			}

			System.out.println((odd + (even * grade)));
			System.out.println("----------------------Continue?");
			cont = scan.next().charAt(0);
		}
	}

}
