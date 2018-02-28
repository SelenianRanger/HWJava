//Sina Kamali 610394126
import java.util.Scanner;
public class EdgeColor {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Ops ops = new Ops(scan);
		
		char cont = 'y';
		while (cont == 'y' || cont == 'Y') {
		System.out.println("----------------------");
			
			int n=scan.nextInt();
			int[][] graph = new int[n][n];
			ops.get(graph);
			
			int[] counter = new int[ops.eCount()];
			for(int i=0;i<counter.length;i++)
				counter[i]=1;
			int min=ops.eCount();
			for(int i=1;i<Math.pow(ops.eCount(), 2);i++){
				if(ops.test(graph, counter) && ops.max(counter)<min)
					min=ops.max(counter);
				ops.inc(ops.eCount(),counter);
			}
			System.out.println(min);
			
		System.out.println("----------------------Continue?");
		cont = scan.next().charAt(0);
		scan.nextLine();
		}

	}

}

class Ops{
	private int C;
	Scanner scan;
	Ops(Scanner scan){
		this.scan=scan;
		C=0;
	}
	
	void get(int[][] G){
		int tmp=scan.nextInt();
		int c=1;
		while(tmp!=-1){
			int tmp2=scan.nextInt();
			G[tmp][tmp2]=c;
			G[tmp2][tmp]=c;
			C++; 
			c++;
			tmp=scan.nextInt();
		}
	}
	
	int eCount(){
		return C;
	}
	
	int max(int[] arr){
		int max=arr[0];
		for(int val:arr)
			if(val>max)
				max=val;
		return max;
	}

	void inc(int n, int[] in){
		int i=in.length-1;
		for(;i>=0 && in[i]==n;i--)
			in[i]=1;
		if(i>=0)
			in[i]++;
	}
	
	boolean test(int[][] G, int[] counter){
		for(int j=0;j<G.length;j++)
			for(int i1=0;i1<G.length-1-j;i1++)
				for(int i2=0;i2<G.length-j;i2++)
					if(i1!=i2 && G[j][i1]!=0 && G[j][i2]!=0)
						if(counter[G[j][i1]-1]==counter[G[j][i2]-1])
							return false;
		return true;
	}
	
}