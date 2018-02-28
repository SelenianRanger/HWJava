//Sina Kamali 610394126
import java.util.Scanner;
public class FullMatrixP {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		MatrixOps mtx = new MatrixOps();
		
		char cont = 'y';
		while (cont == 'y' || cont == 'Y') {
		System.out.println("----------------------");
			
			mtx.draw(scan.nextInt());
			
		System.out.println("----------------------Continue?");
		cont = scan.next().charAt(0);
		scan.nextLine();
		}
		
	}

}

class MatrixOps{
	
	void draw(int n){
		int[][] matrix = new int[n][n];
		int L=0, k=0;
		while(k<(n+1)/2){
			for(int i=k;i<n-k-1;i++){
				matrix[k][i]=L;
				matrix[i][n-1-k]=L+1;
			}
			L+=2;
			for(int i=n-k-1;i>k;i--){
				matrix[n-1-k][i]=L;
				matrix[i][k]=L+1;
			}
			L+=2;
			k++;
		}
		matrix[n/2][n/2]=L-4;
		print(matrix);
	}
	
	void print(int[][] matrix){
		for(int j=0;j<matrix.length;j++){
			for(int i=0;i<matrix.length;i++)
				System.out.print(matrix[j][i]+" ");
			System.out.println();
		}
	}
	
}
