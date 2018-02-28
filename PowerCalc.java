import java.util.Scanner;

public class PowerCalc {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		double limit, time;
		double price;
		char cont = 'y';
		while (cont == 'y' || cont == 'Y') {
			System.out.println("----------------------");
			time = scan.nextLong();
			price = scan.nextLong();
			limit = scan.nextLong();

			time /= 3600;
			if (time > limit)
				price *= 2;

			System.out.println((price * time));
			System.out.println("----------------------Continue?");
			cont = scan.next().charAt(0);
		}
	}

}
