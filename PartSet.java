//Sina Kamali 610394126
import java.util.Scanner;
public class PartSet {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		char cont = 'y';
		while (cont == 'y' || cont == 'Y') {
		System.out.println("----------------------");
			
			int[] array = new int[scan.nextInt()];
			for(int i=0;i<array.length;i++)
				array[i]=scan.nextInt();
			
			for(int i=0;i<=array.length/2;i++){
				ArrayOps.chooseTest(array,i);
			}
			
			
			
		System.out.println("----------------------Continue?");
		cont = scan.next().charAt(0);
		scan.nextLine();
		}
	}

}

class ArrayOps{
	
	static void chooseTest(int[] array, int k){
		int[] sub1 = new int[k], sub2;
		int[] temp = new int[k];
		for(int i=0;i<k;i++)
			temp[i]=i+1;
		for(int t=0;t<k;t++)
			sub1[t]=array[temp[t]-1];
		sub2=rest(array,sub1);
		if(sum(sub1)==sum(sub2)){
			for(int val:sub1)	
				System.out.print(val+" ");
			System.out.println();
			for(int val:sub2)
				System.out.print(val+" ");
			System.out.println("\n");
		}
		int i=k-1;
		while(i>=0){
			for(;i>=0 && temp[i]==array.length-k+i+1;i--){}
			if(i<0)
				break;
			temp[i]++;
			for(;i<k-1;i++)
				temp[i+1]=temp[i]+1;
			for(int t=0;t<k;t++)
				sub1[t]=array[temp[t]-1];
			sub2=rest(array,sub1);
			if(sum(sub1)==sum(sub2)){
				for(int val:sub1)	
					System.out.print(val+" ");
				System.out.println();
				for(int val:sub2)
					System.out.print(val+" ");
				System.out.println("\n");
			}
				
		}
	}
			
	
	static int[] rest(int[] array, int[] sub){
		int[] out = new int[array.length-sub.length];
		int t=0;
		for(int i=0;t<out.length;i++){
			for(int j=0;j<sub.length && i<array.length;j++)
				if(array[i]==sub[j]){
					i++;
					j=-1;
				}
			if(i>=array.length)
				break;
			out[t]=array[i];
			t++;
		}
		return out;
	}
	
	static int sum(int[] array){
		int sum=0;
		for(int val:array)
			sum+=val;
		return sum;
	}
	
}
