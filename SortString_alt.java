//Sina Kamali 610394126
import java.util.Scanner;

public class SortString_alt {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		char cont = 'y';
		while (cont == 'y' || cont == 'Y') {
			System.out.println("----------------------");

			String in = scan.nextLine();
			int[] charArr = new int[256];
			for(int i=0;i<in.length();i++)
				charArr[in.charAt(i)]++;
			
			for(int i=0;i<'A';i++)
				if(charArr[i]!=0)
					System.out.println((char)i+"\t"+charArr[i]);
				
			for(int i='A';i<='Z';i++){
				if(charArr[i]!=0)
					System.out.println((char)i+"\t"+charArr[i]);
				if(charArr[i+'a'-'A']!=0)
					System.out.println((char)(i+'a'-'A')+"\t"+charArr[i+'a'-'A']);
			}
			
			for(int t='Z'+1;t<'a';t++)
				if(charArr[t]!=0)
					System.out.println((char)t+"\t"+charArr[t]);
				
			for(int t='z'+1;t<charArr.length;t++)
				if(charArr[t]!=0)
					System.out.println((char)t+"\t"+charArr[t]);

			System.out.println("----------------------Continue?");
			cont = scan.next().charAt(0);
		}
	}

}