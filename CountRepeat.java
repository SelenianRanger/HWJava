
//Sina Kamali 610394126
import java.util.Scanner;

public class CountRepeat {

	public static int[] sort(int[] in) {
		int[] out = new int[1000001];
		for (int i = 0; i < in.length; i++)
			out[in[i]]++;
		return out;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		char cont = 'y';
		while (cont == 'y' || cont == 'Y') {
			System.out.println("----------------------");

			int n = scan.nextInt();
			int[] in = new int[n];

			for (int i = 0; i < n; i++)
				in[i] = scan.nextInt();

			int[] sorted = sort(in);

			for (int i = 0; i < sorted.length; i++)
				if (sorted[i] != 0)
					System.out.println(i + "\t" + sorted[i]);

			System.out.println("----------------------Continue?");
			cont = scan.next().charAt(0);
		}

	}

}
