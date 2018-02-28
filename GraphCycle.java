//Sina Kamali 610394126
import java.util.Scanner;
public class GraphCycle {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Ops ops = new Ops(scan);
		
		char cont = 'y';
		while (cont == 'y' || cont == 'Y') {
		System.out.println("----------------------");
			
			int n=scan.nextInt();
			boolean[][] G = new boolean[n][n];
			ops.get(G,scan.nextInt());
			
			System.out.println(ops.count(G,3,0));
			
		System.out.println("----------------------Continue?");
		cont = scan.next().charAt(0);
		scan.nextLine();
		}

	}

}

class Ops{
	private Scanner scan;
	Ops(Scanner scan){
		this.scan=scan;
	}
	
	void get(boolean[][] G, int j){
		if(j<0)
			return;
		else{
			int tmp=scan.nextInt();
			G[j][tmp]=true;
			G[tmp][j]=true;
			get(G,scan.nextInt());
		}
	}
	
	int count(boolean[][] G, int n, int out){
		if(n>G.length)
			return out;
		else{
			out+=count(G,new int[n],n-1,0)/(2*n);
			return count(G,n+1,out);
		}
	}
	
	private int count(boolean[][] G, int[] arr, int i, int out){
		if(i<0)
			return out;
		else if(arr[i]>=G.length-1){
			arr[i]=0;
			return count(G,arr,i-1,out);
		}
		else{
			arr[i]++;
			if(checkRpt(G,arr,0,new int[G.length]) && check(G,arr,1))
				out++;
			return count(G,arr,arr.length-1,out);
		}
	}
	
	private boolean check(boolean[][] G, int[] arr, int i){
		if(i>=arr.length)
			if(G[arr[0]][arr[arr.length-1]])
				return true;
			else 
				return false;
		else if(!G[arr[i]][arr[i-1]])
				return false;
		else 
			return check(G,arr,i+1);
	}
	
	private boolean checkRpt(boolean[][] G, int[] arr, int i, int[] test){
		if(i>=arr.length)
			return true;
		else if(test[arr[i]]>=1)
			return false;
		else{
			test[arr[i]]++;
			return checkRpt(G,arr,i+1,test);
		}
	}
	
}