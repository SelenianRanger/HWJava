
//Sina Kamali 610394126
import java.util.Scanner;

public class MergeStr {

	public static String[] merge(String[] in1, String[] in2) {
		int i = 0, j = 0;
		String[] out = new String[in1.length + in2.length];
		while (i < in1.length && j < in2.length) {
			if (in1[i].compareTo(in2[j]) < 0) {
				out[i + j] = in1[i];
				i++;
			} else {
				out[i + j] = in2[j];
				j++;
			}
		}
		if (i < in1.length)
			while (i < in1.length) {
				out[j + i] = in1[i];
				i++;
			}
		else if (j < in2.length)
			while (j < in2.length) {
				out[i + j] = in2[j];
				j++;
			}
		return out;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Sorting sort = new Sorting();
		char cont = 'y';
		while (cont == 'y' || cont == 'Y') {
			System.out.println("----------------------");

			String[] in1 = new String[scan.nextInt()];
			for (int i = 0; i < in1.length; i++)
				in1[i] = scan.next();
			String[] in2 = new String[scan.nextInt()];
			for (int i = 0; i < in2.length; i++)
				in2[i] = scan.next();

			sort.sort(in1);
			sort.sort(in2);

			String[] out = merge(in1, in2);
			for (String val : out)
				System.out.println(val);

			System.out.println("----------------------Continue?");
			cont = scan.next().charAt(0);
		}
	}

}

class Sorting {

	public static void swap(String[] in, int i, int j) {
		String temp = in[i];
		in[i] = in[j];
		in[j] = temp;
	}

	public static void sort(String[] in) {
		int i, j;
		int n = in.length;
		for (i = n - 1; i >= 0; i--)
			for (j = 0; j < i; j++)
				if (in[j].compareTo(in[j + 1]) > 0)
					swap(in, j, j + 1); //
	}

}
