//Sina kamali 610394126
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.Scanner;
public class GraphCenter {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Ops ops = new Ops(scan);
		
		char cont = 'y';
		while (cont == 'y' || cont == 'Y') {
		System.out.println("----------------------");
			
			int n=scan.nextInt();
			int[][] G = new int[n][n];
			
			ops.get(G,scan.nextInt());
			System.out.println(ops.findCenter(G,0,0));
			
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

	void get(int[][] G, int j){
		if(j<0)
			return;
		else{
			int i=scan.nextInt();
			G[j][i]=scan.nextInt();
			G[i][j]=G[j][i];
			get(G,scan.nextInt());
		}
	}
	
	int findCenter(int[][] G, int ver, int min){
		if(ver>=G.length)
			return min;
		else
			if(maxDis(G,ver,0,0)<maxDis(G,min,0,0))
				return findCenter(G,ver+1,ver);
			else
				return findCenter(G,ver+1,min);
	}
	
	private int maxDis(int[][] G, int ver, int ver2, int max){
		if(ver2>=G.length)
			return max;
		else{
			int tmp=minPath(G,ver,ver2,0,0);
			if(tmp>max)
				return maxDis(G,ver,ver2+1,tmp);
			else
				return maxDis(G,ver,ver2+1,max);
		}
	}
	
	private int minPath(int[][] G, int ver1, int ver2, int n, int min){
		if(n>G.length-2)
			return min;
		else{
			int tmp=count(G,new int[n],n-1,0,ver1,ver2);
			if((tmp<min && tmp!=0) || min==0)
				return minPath(G,ver1,ver2,n+1,tmp);
			else
				return minPath(G,ver1,ver2,n+1,min);
		}
	}
	
	private int count(int[][] G, int[] arr, int i, int min, int ver1, int ver2){
		if(arr.length==0)
			return G[ver1][ver2];
		else if(i<0)
			return min;
		else if(arr[i]>=G.length-1){
			arr[i]=0;
			return count(G,arr,i-1,min,ver1,ver2);
		}
		else{
			arr[i]++;
			int tmp=checkPath(G,arr,1,0,ver1,ver2);
			if(checkRpt(G,arr,0,new int[G.length],ver1,ver2) && tmp!=0 && (tmp<min || min==0))
				return count(G,arr,arr.length-1,tmp,ver1,ver2);
			else
				return count(G,arr,arr.length-1,min,ver1,ver2);
		}
	}
	
	private boolean checkRpt(int[][] G, int[] arr, int i, int[] test, int ver1, int ver2){
		if(i>=arr.length)
			return true;
		else if(test[arr[i]]>=1 || arr[i]==ver1 || arr[i]==ver2 || ver1==ver2)
			return false;
		else{
			test[arr[i]]++;
			return checkRpt(G,arr,i+1,test,ver1,ver2);
		}
	}

	private int checkPath(int[][] G, int[] arr, int i, int dis, int ver1, int ver2){
		if(arr.length==0)
			return G[ver1][ver2];
		else if(G[ver1][arr[0]]==0 || G[ver2][arr[arr.length-1]]==0)
			return 0;
		else if(arr.length==1)
			return G[ver1][arr[0]]+G[ver2][arr[0]];
		else if(i>=arr.length)
			return dis+G[ver1][arr[0]]+G[ver2][arr[arr.length-1]];
		else if(G[arr[i]][arr[i-1]]==0)
			return 0;
		else{
			return checkPath(G,arr,i+1,dis+G[arr[i]][arr[i-1]],ver1,ver2);
		}
	}
	
}