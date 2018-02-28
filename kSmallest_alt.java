//Sina Kamali 610394126
import java.util.Scanner;
public class kSmallest_alt {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		char cont = 'y';
		while (cont == 'y' || cont == 'Y') {
		System.out.println("----------------------");
		
		int[] in = new int[scan.nextInt()];
		int k=scan.nextInt();
		for(int i=0;i<in.length;i++)
			in[i]=scan.nextInt();
		int min=0;
		for(int t=0;t<k;t++){
			min=t;
			for(int i=t;i<in.length;i++)
				if(in[i]<in[min])
					min=i;
			int tmp=in[min];
			in[min]=in[t];
			in[t]=tmp;
		}
		System.out.println(in[k-1]);
		
		System.out.println("----------------------Continue?");
		cont = scan.next().charAt(0);
		scan.nextLine();
		}
	}

}