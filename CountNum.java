
//Sina Kamali 610394126
import java.util.Scanner;

public class CountNum {

	public static int count(int[] array, int in) {
		int count = 0;
		for (int val : array)
			count += (val == in) ? 1 : 0;
		return count;
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

			int max = in[0];
			for (int val : in) {
				if (count(in, val) > count(in, max))
					max = val;
				else if (count(in, val) == count(in, max))
					if (max > val)
						max = val;
			}
			System.out.println(max);

			System.out.println("----------------------Continue?");
			cont = scan.next().charAt(0);
		}
	}

}
