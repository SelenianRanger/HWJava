//Sina Kamali 610394126
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
public class WeightedMid {

	public static void main(String[] args) throws IOException{
		Scanner filename = new Scanner(System.in);
		File file = new File(filename.nextLine());
		Scanner scan = new Scanner(file);
		Sort sort = new Sort();
		
		char cont = 'y';
		while (cont == 'y' || cont == 'Y') {
		System.out.println("----------------------");
			
			int[] num = new int[scan.nextInt()];
			for(int i=0;i<num.length;i++)
				num[i]=scan.nextInt();
			double[] weight = new double[num.length];
			for(int i=0;i<num.length;i++)
				weight[i]=scan.nextDouble();
			
			sort.sort(num,weight);
			
			for(int i=0;i<num.length;i++){
				double left=0, right=0;
				for(int j=0;j<i;j++)
					left+=weight[j];
				for(int j=i+1;j<num.length;j++)
					right+=weight[j];
				if(left<=0.5 && right<=0.5)
					System.out.println(num[i]);
			}
			
		System.out.println("----------------------Continue?");
		cont = scan.next().charAt(0);
		scan.nextLine();
		}

	}

}

class Sort{
	
	public static void swap(int[] num, double[] weight, int i, int j) {
		int temp1 = num[i];
		num[i] = num[j];
		num[j] = temp1;
		double temp2 = weight[i];
		weight[i] = weight[j];
		weight[j] = temp2;
	}

	public static void sort(int[] num, double[] weight) {
		int i, j;
		int n = num.length;
		for (i = n - 1; i >= 0; i--)
			for (j = 0; j < i; j++)
				if (num[j]>num[j + 1])
					swap(num, weight, j, j + 1); 
	}
	
}
