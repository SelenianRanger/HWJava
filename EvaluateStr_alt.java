//Sina Kamali 610394126
import java.util.Scanner;
public class EvaluateStr_alt {

	public static int findInt(StringBuffer in, int i){
		while(i<in.length() && in.charAt(i)>='0' && in.charAt(i)<='9')
			i++;
		i--;
		int out=0, p=0;
		while(i>=0 && in.charAt(i)>='0' && in.charAt(i)<='9'){
			out+=(in.charAt(i)-'0')*(int)Math.pow(10, p);
			p++;
			i--;
		}
		if((i-1>=0 && in.charAt(i)=='-' && !(in.charAt(i-1)>='0' && in.charAt(i-1)<='9')) || (i==0 && in.charAt(i)=='-'))
			out=0-out;
		return out;
	}
	
	public static int delete(StringBuffer in, int start, int end){
		int temp=start;
		while(end<in.length() && in.charAt(end)>='0' && in.charAt(end)<='9')
			end++;
		end--;
		while(start>=0 && in.charAt(start)>='0' && in.charAt(start)<='9')
			start--;
		if((start-1>=0 && in.charAt(start)=='-' && !(in.charAt(start-1)>='0' && in.charAt(start-1)<='9')) || (start==0 && in.charAt(start)=='-'))
			start--;
		start++;
		in.delete(start, end+1);
		return temp-start+1;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		char cont = 'y';
		while (cont == 'y' || cont == 'Y') {
		System.out.println("----------------------");
			
			StringBuffer in = new StringBuffer(scan.nextLine());
			for(int i=1;i<in.length();i++){
				if(in.charAt(i)=='*'){
					String temp = String.valueOf(findInt(in,i-1)*findInt(in,i+1));
					i-=delete(in,i-1, i+1);
					in.insert(i, temp);
				}
				else if(in.charAt(i)=='/'){
					String temp = String.valueOf(findInt(in,i-1)/findInt(in,i+1));
					i-=delete(in,i-1, i+1);
					in.insert(i, temp);
				}	
			}
			for(int i=1;i<in.length();i++){
				if(in.charAt(i)=='+'){
					String temp = String.valueOf(findInt(in,i-1)+findInt(in,i+1));
					i-=delete(in,i-1, i+1);
					in.insert(i, temp);
				}
				else if(in.charAt(i)=='-'){
					String temp = String.valueOf(findInt(in,i-1)-findInt(in,i+1));
					i-=delete(in,i-1, i+1);
					in.insert(i, temp);
				}	
			}
			System.out.println(Integer.parseInt(in.toString()));
			
		System.out.println("----------------------Continue?");
		cont = scan.next().charAt(0);
		scan.nextLine();
		}

	}

}