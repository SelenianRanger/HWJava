//Sina Kamali 610394126
import java.util.Scanner;
import java.util.StringTokenizer;
public class EvaluateStr {
	
	public static String next(StringTokenizer token){
		String temp = token.nextToken();
		if(temp.equals(" ") || temp.equals("(") || temp.equals(")"))
			while((temp.equals(" ") || temp.equals("(") || temp.equals(")")) && token.hasMoreElements())
				temp = token.nextToken();
		return temp;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		char cont = 'y';
		while (cont == 'y' || cont == 'Y') {
		System.out.println("----------------------");
			
			StringTokenizer token = new StringTokenizer(scan.nextLine()," ()+-*/",true);
			int sofar = 0;
			do{
				String temp = next(token);
				if(temp.equals("+"))
					sofar+=Integer.parseInt(next(token));
				else if(temp.equals("-"))
					sofar-=Integer.parseInt(next(token));
				else if(temp.equals("*"))
					sofar*=Integer.parseInt(next(token));
				else if(temp.equals("/"))
					sofar/=Integer.parseInt(next(token));
				else
					sofar=Integer.parseInt(temp);
			}while(token.hasMoreTokens());
			System.out.println(sofar);
			
		System.out.println("----------------------Continue?");
		cont = scan.next().charAt(0);
		scan.nextLine();
		}

	}

}
