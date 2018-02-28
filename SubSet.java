//Sina Kamali 610394126
import java.util.Scanner;
public class SubSet {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		char cont = 'y';
		while (cont == 'y' || cont == 'Y') {
		System.out.println("----------------------");
			
			int[] array = new int[scan.nextInt()];
			for(int i=0;i<array.length;i++)
				array[i]=scan.nextInt();
			
			boolean[] check = new boolean[array.length];
			int i=0;
			while(i>=0){
				i=check.length-1;
				for(;i>=0 && check[i]==true;i--)
					check[i]=false;
				if(i>=0){
					check[i]=true;
				
					for(int t=0;t<array.length;t++)
						if(check[t])
							System.out.print(array[t]+" ");
					System.out.println();
				}
			}
			
		System.out.println("----------------------Continue?");
		cont = scan.next().charAt(0);
		scan.nextLine();
		}

	}

}
