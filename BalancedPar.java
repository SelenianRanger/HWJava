//Sina Kamali 610394126
import java.util.Scanner;
public class BalancedPar {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		RecOps op = new RecOps();
		
		char cont = 'y';
		while (cont == 'y' || cont == 'Y') {
		System.out.println("----------------------");	
			
			boolean[] set = new boolean[2*scan.nextInt()];
			int[] pos = new int[set.length/2];
			op.init(set,pos,set.length-1);
			op.print(set,set.length-1);
			System.out.println();

			op.balPar(set,pos,0);
			
		System.out.println("----------------------Continue?");
		cont = scan.next().charAt(0);
		scan.nextLine();
		}

	}

}

class RecOps{
	
	void init(boolean[] set, int[] pos, int i){
		if(i<0)
			return;
		else{
			init(set,pos,i-1);
			if(i>(set.length-1)/2){
				set[i]=true;
				pos[i-pos.length]=i;
			}
		}
	}
	
	void print(boolean[] set, int i){
		if(i<0)
			return;
		else{
			print(set,i-1);
			System.out.print((set[i])?")":"(");
		}
	}

	void balPar(boolean[] set, int[] pos, int i){
		if(set[pos[i]-1] || pos[i]==2*i+1)
			return;
		else{
			set[pos[i]]=!set[pos[i]];
			set[pos[i]-1]=!set[pos[i]-1];
			pos[i]--;
			balPar(set,pos,i+1);
			print(set,set.length-1);
			System.out.println();
			balPar(set,pos,i);
			pos[i]++;
			set[pos[i]-1]=!set[pos[i]-1];
			set[pos[i]]=!set[pos[i]];
		}
	}
	
}