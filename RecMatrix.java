//Sina Kamali 610394126
import java.util.Scanner;
public class RecMatrix {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Ops ops = new Ops(scan);
		
		char cont = 'y';
		while (cont == 'y' || cont == 'Y') {
		System.out.println("----------------------");
			
			int n=scan.nextInt();
			int[][] matrix = new int[n][n];
			
			ops.get(matrix,n-1);
			
			System.out.println(ops.det(matrix,n-1));
			
			ops.print(matrix,n-1);
			
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

	
	void get(int[][] matrix, int j){
		if(j<0)
			return;
		else{
			get(matrix,j-1);
			get(matrix[j],matrix.length-1);
		}
	}
	
	private void get(int[] line, int i){
		if(i<0)
			return;
		get(line,i-1);
		line[i]=scan.nextInt();
	}
//---------------------------------------	
	void print(int[][] matrix, int j){
		if(j<0)
			return;
		else{
			print(matrix,j-1);
			print(matrix[j],matrix.length-1);
			System.out.println();
		}
	}
	
	private void print(int[] line, int i){
		if(i<0)
			return;
		else{
			print(line,i-1);
			System.out.print(line[i]+" ");
		}
	}

//---------------------------------------	
	int det(int[][] matrix, int i){
		if(i<0)
			return 0;
		else if(matrix.length==2)
			return matrix[0][0]*matrix[1][1]-matrix[0][1]*matrix[1][0];
		else{
			int[][] sub = new int[matrix.length-1][matrix.length-1];
			sub(matrix,matrix.length-1,0,i,sub,sub.length-1);
			return (int)Math.pow(-1,i%2)*matrix[0][i]*det(sub,matrix.length-2)+det(matrix,i-1);
		}
	}
	
	private void sub(int[][] matrix, int j, int J, int I, int[][] sub, int c){
		if(j<0)
			return;
		else
			if(j==J)
				sub(matrix,j-1,J,I,sub,c);
			else{
				sub(matrix,j-1,J,I,sub,c-1);
				sub(matrix[j],matrix.length-1,c,I,sub,sub.length-1);
			}
	}
	
	private void sub(int[] line, int i, int j, int I, int[][] sub, int c){
		if(i<0)
			return;
		else
			if(i==I)
				sub(line,i-1,j,I,sub,c);
			else{
				sub(line,i-1,j,I,sub,c-1);
				sub[j][c]=line[i];
			}
	}
	
}