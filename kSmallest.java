//Sina Kamali 610394126
import java.util.Scanner;
public class kSmallest {
	
	public static int smallest(int[] array,int k){
		int i=0;
		while(k>1){
			i++;
			if(array[i]!=array[i-1])
				k--;
		}
		return array[i];
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Sort sort = new Sort();
		
		char cont = 'y';
		while (cont == 'y' || cont == 'Y') {
		System.out.println("----------------------");
		
		int[] in = new int[scan.nextInt()];
		for(int i=0;i<in.length;i++)
			in[i]=scan.nextInt();
		
		sort.mergesrt(in,0,in.length-1);
		
		System.out.println(smallest(in,scan.nextInt()));
		
		System.out.println("----------------------Continue?");
		cont = scan.next().charAt(0);
		scan.nextLine();
		}
	}

}

class Sort{
	
	void merge(int[] array,int start, int end){
		int mid=(start+end)/2;
		int[] temp = new int[array.length];
		for(int i=0;i<array.length;i++)
			temp[i]=array[i];
		
		int i=start, j=mid, c=start;
		while(i<=mid && j<=end){
			if(temp[i]<temp[j]){
				array[c]=temp[i];
				i++;
			}
			else{
				array[c]=temp[j];
				j++;
			}
			c++;
		}
		if(i<=mid)
			for(;i<mid;i++,c++)
				array[c]=temp[i];
		else if(j<=end)
			for(;j<end;j++,c++)
				array[c]=temp[j];
	}
	
	void mergesrt(int[] array, int start, int end){
		if(start<end){
			int mid = (start + end) / 2;
			mergesrt(array,start,mid);
			mergesrt(array,mid+1,end);
			merge(array,start,end);
		}
	}
	
}