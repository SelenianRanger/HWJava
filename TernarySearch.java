
//Sina Kamali 610394126
import java.util.Scanner;

public class TernarySearch {

	public static int locate(int[] array, int k) {
		int L = 0, H = array.length - 1;
		while (L <= H) {
			if (k == array[L])
				return L;
			else if (k == array[H])
				return H;
			if (k == array[(H - L) / 3 + L])
				return (H - L) / 3 + L;
			else if (k == array[(H - L) / 3 * 2 + L])
				return (H - L) / 3 * 2 + L;
			else if (k < array[(H - L) / 3 + L])
				H = (H - L) / 3 + L - 1;
			else if (k > array[(H - L) / 3 + L] && k < array[(H - L) / 3 * 2 + L]) {
				L = (H - L) / 3 + L + 1;
				H = (H - L) / 3 * 2 + L - 1;
			} else
				L = (H - L) / 3 * 2 + L + 1;
		}
		return -1;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		char cont = 'y';
		while (cont == 'y' || cont == 'Y') {
			System.out.println("----------------------");

			int[] in = new int[scan.nextInt()];
			for (int i = 0; i < in.length; i++)
				in[i] = scan.nextInt();

			int k, x = -1;
			k = scan.nextInt();
			x = locate(in, k);

			if (x == -1)
				System.out.println("No");
			else
				System.out.println("Yes");

			System.out.println("----------------------Continue?");
			cont = scan.next().charAt(0);
		}
	}

}
