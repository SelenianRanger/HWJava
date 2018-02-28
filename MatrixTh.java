//Sina Kamali 610394126
import java.util.Scanner;
public class MatrixTh {
	
	public static void main(String[] args) {
		Scanner scan =  new Scanner(System.in);
		Search search = new Search();
		
		char cont = 'y';
		while (cont == 'y' || cont == 'Y') {
		System.out.println("----------------------");
			
			int[][] matrix = new int[scan.nextInt()][scan.nextInt()];
			for(int j=0;j<matrix.length;j++)
				for(int i=0;i<matrix[0].length;i++)
					matrix[j][i]=scan.nextInt();
			
			int k=scan.nextInt();
			if(search.find(matrix,k)==-1 || search.find(matrix[search.find(matrix,k)],k)==-1)
				System.out.println("not found");
			else
				System.out.println(search.find(matrix,k)+"\t"+search.find(matrix[search.find(matrix,k)],k));
			
		System.out.println("----------------------Continue?");
		cont = scan.next().charAt(0);
		scan.nextLine();
		}

	}

}

class Search{

	public static int find(int[][] matrix, int k){
		int L = 0, H = matrix.length - 1;
		while(L<=H){
			if(k<matrix[L][0] || k>matrix[H][matrix[0].length-1])
				break;
			else if(k>=matrix[(H-L)/3+L][0] && k<=matrix[(H-L)/3+L][matrix[0].length-1])
				return (H-L)/3+L;
			else if(k>=matrix[(H-L)/3*2+L][0] && k<=matrix[(H-L)/3*2+L][matrix[0].length-1])
				return (H-L)/3*2+L;
			else if(k<matrix[(H-L)/3+L][0])
				H=(H-L)/3+L-1;
			else if(k>matrix[(H-L)/3*2+L][matrix[0].length-1])
				L=(H-L)/3*2+L+1;
			else{
				H=(H-L)/3*2+L-1;
				L=(H-L)/3+L+1;
			}
		}
		return -1;
	}
	
	public static int find(int[] row, int k){
		int L = 0, H = row.length - 1;
		while (L <= H) {
			if (k == row[L])
				return L;
			else if (k == row[H])
				return H;
			if (k == row[(H - L) / 3 + L])
				return (H - L) / 3 + L;
			else if (k == row[(H - L) / 3 * 2 + L])
				return (H - L) / 3 * 2 + L;
			else if (k < row[(H - L) / 3 + L])
				H = (H - L) / 3 + L - 1;
			else if (k > row[(H - L) / 3 + L] && k < row[(H - L) / 3 * 2 + L]) {
				L = (H - L) / 3 + L + 1;
				H = (H - L) / 3 * 2 + L - 1;
			} else
				L = (H - L) / 3 * 2 + L + 1;
		}
		return -1;
	}

}
