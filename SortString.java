
//Sina Kamali 610394126
import java.util.Scanner;

public class SortString {
	// ----------------------------------------------------------
	public static boolean first(String source, int at) {
		for (int i = 0; i < at; i++)
			if (source.charAt(i) == source.charAt(at))
				return false;
		return true;
	}

	// ----------------------------------------------------------(char)
	public static char[] typecount(String source) { 
		int n = 0, j = 0; 
		for (int i = 0; i < source.length(); i++) 
			n += (first(source, i)) ? 1 : 0; 
		char[] out = new char[n]; 
		for (int i = 0; i < source.length(); i++) 
			if (first(source, i)) { 
				out[j] = source.charAt(i); 
				if (i != source.length() - 1) 
					j++; 
			} 
		return out; 
					
	} 
		

	public static int[] charcount(char[] in, String source) { 
		int[] count = new int[in.length]; 
		for (int i = 0; i < in.length; i++) 
			for (int j = 0; j < source.length(); j++) 
				count[i] += (in[i] == source.charAt(j)) ? 1 : 0; 
		return count; 
	} 
	// ----------------------------------------------------------(Sort)

	public static void swap(char[] in, int i, int j) {			
		char temp = in[i]; 								
		in[i] = in[j];									
		in[j] = temp; 											
	} 															
																
																
	public static char[] sort(char[] in) { 						
		int i, j; 												
		int n = in.length; 
		for (i = n - 1; i >= 0; i--) 
			for (j = 0; j < i; j++) 
				if (in[j] > in[j + 1]) 
					swap(in, j, j + 1); 
		return in; 
	} 
	// ----------------------------------------------------------

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		char cont = 'y';
		while (cont == 'y' || cont == 'Y') {
			System.out.println("----------------------");

			String in = scan.next();
			in = in.toUpperCase();

			char[] chararr = sort(typecount(in));
			int[] countarr = charcount(chararr, in);

			for (int i = 0; i < chararr.length; i++)
				System.out.println(chararr[i] + "\t" + countarr[i]);

			System.out.println("----------------------Continue?");
			cont = scan.next().charAt(0);
		}
	}

}
