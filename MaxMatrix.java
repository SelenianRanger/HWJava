//Sina Kamali 610394126
import java.util.Scanner;
public class MaxMatrix {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		MatrixOps mtx = new MatrixOps(scan);
		
		char cont = 'y';
		while (cont == 'y' || cont == 'Y') {
		System.out.println("----------------------");
			
			int[][] matrix = mtx.get();
			int m = scan.nextInt();
			int[][] max = mtx.subset(matrix,m,0,0);
			for(int Y=0;Y<=matrix.length-m;Y++)
				for(int X=0;X<=matrix.length-m;X++)
					if(mtx.sumElements(mtx.subset(matrix,m,X,Y))>mtx.sumElements(max))
						max=mtx.subset(matrix,m,Y,X);
			mtx.print(max);
			
		System.out.println("----------------------Continue?");
		cont = scan.next().charAt(0);
		scan.nextLine();
		}

	}

}

class MatrixOps{
	Scanner scan;
	MatrixOps(Scanner in){
		scan=in;
	}
	
	int[][] subset(int[][] src, int m, int Y, int X){
		int [][] out = new int [m][m];
		for(int j=0;j<m;j++)
			for(int i=0;i<m;i++)
				out[j][i]=src[j+Y][i+X];
		return out;
	}
	
	int sumElements(int[][] matrix){
		int sum=0;
		for(int j=0;j<matrix.length;j++)
			for(int i=0;i<matrix.length;i++)
				sum+=matrix[j][i];
		return sum;
	}
	
	int[][] get(){
		int n = scan.nextInt();
		int[][] out = new int[n][n];
		for(int j=0;j<n;j++)
			for(int i=0;i<n;i++)
				out[j][i]=scan.nextInt();
		return out;
	}
	
	void print(int[][] matrix){
		for(int j=0;j<matrix.length;j++){
			for(int i=0;i<matrix.length;i++)
				System.out.print(matrix[j][i]+" ");
			System.out.println();
		}
	}
	
}
