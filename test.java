import java.util.Scanner;
class test {
	
	public static void swap(int[] in, int i, int j){
		int tmp=in[i];
		in[i]=in[j];
		in[j]=tmp;
	}
	
	public static boolean is(int[] perm){
		int[] test = new int[perm.length];
		for(int i=0;i<test.length;i++)
			test[i]=i;
		
		for(int i=0;i<perm.length;i++)
			if(test[i]!=perm[i])
				return false;
		return true;
	}
	
	public static boolean perm(int[] perm){
		//--------------------------------
		System.out.println("i\tj\t\tperm\n------------------------------------------------");
		//--------------------------------
		for(int i=0;i<perm.length;i++)
			for(int j=0;j<perm.length;j++){
				//----------------trace---------------
				System.out.print(i+"\t"+j+"\t\t");
				for(int val:perm)
					System.out.print(val+" ");
				System.out.println();
				//------------------------------------
				if(perm[j]==i){
					swap(perm,i,j);
					break;
				}
			}
		if(is(perm))
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] perm = new int[scan.nextInt()];
		for(int i=0;i<perm.length;i++)
			perm[i]=scan.nextInt();
		System.out.println(perm(perm));
		
	}
	
}
