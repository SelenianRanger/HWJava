
//Sina Kamali 610394126
import java.util.Scanner;

public class BinReverse {

	public static void PrintBin(int num) {
		int rm = 0;
		while (num >= 1) {
			rm = num % 2;
			num /= 2;
			System.out.print(rm);
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int in = scan.nextInt();
		if (in == 0)
			System.out.println(0);
		else
			PrintBin(in);

	}

}