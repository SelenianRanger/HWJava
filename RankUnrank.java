//Sina Kamali 610394126
import java.util.Scanner;
public class RankUnrank {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		SubOps op = new SubOps();
		
		char cont = 'y';
		while (cont == 'y' || cont == 'Y') {
		System.out.println("----------------------");
			
			int[] set = new int[scan.nextInt()];
			for(int i=0;i<set.length;i++)
				set[i]=scan.nextInt();
			
			if(scan.next().toLowerCase().charAt(0)=='r')
				op.rank(set,scan.nextInt());
			else{
				int[] sub = new int[scan.nextInt()];
				for(int i=0;i<sub.length;i++)
					sub[i]=scan.nextInt();
				
				System.out.println(op.unRank(sub,set));
			}
			
			
		System.out.println("----------------------Continue?");
		cont = scan.next().charAt(0);
		scan.nextLine();
		}
		
	}

}

class SubOps{
	
	void rank(int[] set, int k){
		int i=set.length;
		for(;i>0;i--)
			if(k-i<=0)
				break;
			else 
				k-=i;
		
		for(;k>0;i--,k--)
			System.out.print(set.length-i+1+" ");
		System.out.println();
			
	}
	
	int unRank(int[] sub, int[] set){
		int out=0;
		for(int i=0;sub[0]!=set[i];i++)
			out+=set.length-i;
		return out+sub.length;
	}
	
}