//Sina Kamali 610394126
import java.util.Scanner;
import java.util.StringTokenizer;
public class PrintFactor {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		PrimeOps prm = new PrimeOps();
		
		char cont = 'y';
		while (cont == 'y' || cont == 'Y') {
		System.out.println("----------------------");
			
			int num = scan.nextInt();
			
			int[] primegrp = prm.findPrime(num);
			
			for(int k=1;k<=prm.maxCount(num,primegrp);k++){
					prm.findnext(num,primegrp,k);
			}
			
		System.out.println("----------------------Continue?");
		cont = scan.next().charAt(0);
		scan.nextLine();
		}
		
	}

}

class PrimeOps{
	
	boolean checkPrime(int in){
		for(int i=2;i<=Math.sqrt(in);i++)
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
	
	int maxCount(int num, int[] primegp){
		int sum=0;
		int i=0;
		for(;i<primegp.length && sum<=num;i++){
			sum+=primegp[i];
			if(sum>=num)
				break;
		}
		if(sum>=num)
			return i+1;	
		else
			return 0;
	}
	
	void findnext(int num, int[] primegp, int k){
		int sum=0;
		int[] temp = new int[k];
		for(int i=0;i<k;i++)
			temp[i]=i+1;
		for(int val:temp)
			sum+=primegp[val-1];
		if(sum==num){
			for(int val:temp)
				System.out.print(primegp[val-1]+" ");
		System.out.println();
		}
		int i=k-1;
		while(i>=0){
			sum=0;
			for(;i>=0 && temp[i]==primegp.length-k+i+1;i--){}
			if(i<0)
				break;
			temp[i]++;
			for(;i<k-1;i++)
				temp[i+1]=temp[i]+1;
			for(int val:temp)
				sum+=primegp[val-1];
			if(sum==num){
				for(int val:temp)
					System.out.print(primegp[val-1]+" ");
			System.out.println();
			}
		}
	}
			
}