//Sina Kamali 610394126
import java.util.Scanner;
public class PermHamilton {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		char cont = 'y';
		while (cont == 'y' || cont == 'Y') {
		System.out.println("----------------------");
			
			int n=scan.nextInt();
			int[][] graph = new int[n][n];
			while(true){
				int a=scan.nextInt()-1;
				if(a==-2)
					break;
				int b=scan.nextInt()-1;
				int tmp=scan.nextInt();
				graph[a][b]=tmp;
				graph[b][a]=tmp;
			}
			
			int[] perm = new int[n];
			for(int i=0;i<n;i++)
				perm[i]=i;
			int[] min= new int[n];
			boolean first=false;
			if(Ops.check(graph,perm)){
				Ops.copy(perm,min);
				first=true;
			}
			for(int count=1;count<Ops.fact(n);count++){
				Perm.next(perm);
				if(!first && Ops.check(graph, perm)){
					Ops.copy(perm,min);
					first=true;
				}
				if(Ops.check(graph,perm) && Ops.sum(graph,perm)<Ops.sum(graph,min))
					Ops.copy(perm,min);
			}
			
			for(int val:min)
				System.out.print(val+1+" ");
			System.out.println();
				
			
		System.out.println("----------------------Continue?");
		cont = scan.next().charAt(0);
		scan.nextLine();
		}

	}

}

class Ops{
	
	static void copy(int[] from, int[] to){
		for(int i=0;i<from.length;i++)
			to[i]=from[i];
	}
	
	static boolean check(int[][] graph, int[] perm){
		for(int i=0;i<perm.length-1;i++)
			if(graph[perm[i]][perm[i+1]]==0)
				return false;
		if(graph[perm[0]][perm[perm.length-1]]==0)
			return false;
		return true;
	}
	
	static int sum(int[][] graph, int[] perm){
		int out=0;
		for(int i=0;i<perm.length-1;i++)
			out+=graph[perm[i]][perm[i+1]];
		return out;
	}
	
	static int fact(int n){
		if(n!=1)
			return n*fact(n-1);
		return 1;
	}
	
}

class Perm{
	
	static void sort(int[] array, int k) {
		int i, j;
		int n=array.length;
		for(i=n-1;i>=k;i--)
			for(j=k;j<i;j++)
				if(array[j]>array[j+1])
					swap(array,j,j+1); 
	}
	
	static void swap(int[] arr, int i, int j){
		int tmp=arr[i];
		arr[i]=arr[j];
		arr[j]=tmp;
	}
	
	static void next(int[] array){
		int i=array.length-1;
		for(;i>0;i--)
			if(array[i-1]<array[i])
				break;
		if(i<=0)
			return;
		int min=i;
		for(int j=i;j<array.length;j++)
			if(array[i-1]<array[j] && array[j]<=array[min])
				min=j;
		swap(array,min,i-1);
		sort(array,i);
	}
	
}