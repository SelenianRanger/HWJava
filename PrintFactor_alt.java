//Sina Kamali 610394126
import java.util.Scanner;
import java.util.StringTokenizer;
public class PrintFactor_alt {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		PrimeOps prm = new PrimeOps();
		
//		char cont = 'y';
//		while (cont == 'y' || cont == 'Y') {
//		System.out.println("----------------------");
			
			int num = scan.nextInt();
			
			if(num==1)
				return;
			else if(num==2){
				System.out.println("2");
				return;
			}
			else if(num==3){
				System.out.println("3");
				return;
			}
			
			int[] primegrp = prm.findPrime(num);
			
			prm.findnext(num,primegrp);
			
//		System.out.println("----------------------Continue?");
//		cont = scan.next().charAt(0);
//		scan.nextLine();
//		}
		
	}

}

class PrimeOps{
	
	boolean checkPrime(int in){
		if(in%2==0 && in!=2)
			return false;
		for(int i=3;i<=Math.sqrt(in);i+=2)
			if(in%i==0)
				return false;
		return true;
	}
	
	int[] findPrime(int num){
		StringBuffer strbuff = new StringBuffer();
		for(int i=2;i<=num;i++)
			if(checkPrime(i)){
				strbuff.append(i+" ");
			}
		StringTokenizer token = new StringTokenizer(strbuff.toString());
		int[] out = new int[token.countTokens()];
		for(int i=0;token.hasMoreTokens();i++)
			out[i]=Integer.parseInt(token.nextToken());
		return out;
	}
	
	void findnext(int num, int[] primegp){
		int sum=0;
		int[] temp = new int[primegp.length];
		while(temp[0]<2){
			sum=0;
			temp[temp.length-1]++;
			for(int i=temp.length-1;temp[i]==2 && i>0;i--){
				temp[i]=0;
				temp[i-1]++;
			}
			for(int i=0;i<temp.length;i++)
				if(temp[i]==0)
					sum+=primegp[i];
			if(sum==num){
				for(int i=0;i<temp.length;i++)
					if(temp[i]==0)
						System.out.print(primegp[i]+" ");
			System.out.println();
			}
		}
			
	}
}