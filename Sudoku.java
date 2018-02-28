//Sina Kamali 610394126
import java.util.Scanner;
public class Sudoku{
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		SudokuOP sudoku = new SudokuOP();
		
		char cont = 'y';
		while (cont == 'y' || cont == 'Y') {
		System.out.println("----------------------");
			
			int n=scan.nextInt();
			int[][] matrix = new int[n][n];
			for(int j=0;j<matrix.length;j++)
				for(int i=0;i<matrix[0].length;i++)
					matrix[j][i]=scan.nextInt();
			
			if(sudoku.test(matrix))
				System.out.println("Yes");
			else
				System.out.println("No");
			
		System.out.println("----------------------Continue?");
		cont = scan.next().charAt(0);
		scan.nextLine();
		}
		
	}
	
}

class SudokuOP{
	Sorting srt;
	ArrayOps arr;
	
	SudokuOP(){
		srt = new Sorting();
		arr = new ArrayOps(srt);
	}
	
	boolean test(int[][] matrix){
		
		int[] test = new int[matrix.length];
		for(int i=1;i<=matrix.length;i++)
			test[i-1]=i;
		int[] row = new int[matrix.length];
		int[] col = new int[matrix.length];
		int[][] sub = new int[(int)Math.sqrt(matrix.length)][(int)Math.sqrt(matrix.length)];
		
		for(int j=0;j<matrix.length;j++){
			for(int i=0;i<matrix.length;i++){
				row[i]=matrix[j][i];
				col[i]=matrix[i][j];
			}
			if(!arr.equals(row,test) || !arr.equals(col,test))
				return false;
		}
		for(int y=0;y<matrix.length;y+=Math.sqrt(matrix.length))
			for(int x=0;x<matrix.length;x+=Math.sqrt(matrix.length)){
				for(int j=0;j<Math.sqrt(matrix.length);j++)
					for(int i=0;i<Math.sqrt(matrix.length);i++)
						sub[j][i]=matrix[j+y][i+x];
				if(!arr.equals(arr.toArr(sub),test))
					return false;
			}
		
		return true;				
	}
	
}

class Sorting{
	
	void sort(int[] array, int n){
		
		int[] counter = new int[n+1];
		for(int val:array)
			counter[val]++;
		
		int c=0;
		for(int i=0;i<counter.length;i++)
			for(int k=0;k<counter[i];k++){
				array[c]=i;
				c++;
			}
		}
																																																					
	void sort(int[][] matrix){
		
		int[] array = new int[(int)Math.pow(matrix.length,2)];
		for(int j=0;j<matrix.length;j++)
			for(int i=0;i<matrix[0].length;i++)
				array[i+j]=matrix[j][i];
		sort(array, array.length);
		int j=0, i=0;
		while(i+j<matrix.length){
			while(i<matrix.length){
				matrix[j][i]=array[i+j];
				i++;
			}
			i=0;
			j++;
		}
		
	}
	
}

class ArrayOps{
	Sorting srt;
	ArrayOps(Sorting x){
		srt = x;
	}
	
	int[] toArr(int[][] matrix){
		int[] out = new int[(int)Math.pow(matrix.length,2)];
		int c=0;
		for(int j=0;j<matrix.length;j++)
			for(int i=0;i<matrix.length;i++){
				out[c]=matrix[j][i];
				c++;
			}
		return out;
	}
	
	boolean equals(int[] a, int[] b){
		srt.sort(a, a.length);
		srt.sort(b, b.length);
		for(int i=0;i<a.length;i++)
			if(a[i]!=b[i])
				return false;
		return true;
		
	}
	
}