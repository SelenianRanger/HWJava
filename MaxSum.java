//Sina Kamali 610394126
import java.util.Scanner ;
public class MaxSum
{

   public static void main ( String[] args )
   {

       Scanner scan = new Scanner( System.in );
       SeqOps S= new SeqOps() ;
       
       int n,i;
       Seq max;
       	       
       n = scan.nextInt();

       int[] A = new int[n];
       
       for(i=0; i<n; i++) 
           A[i]=scan.nextInt();
       
       max=S.maxSum(A,0,A.length-1) ;
       System.out.println(max.val + " " + (max.start+1) + " " + max.end) ;
       for(i=max.start+1; i<=max.end; i++) 
           System.out.print(A[i] + " ");

    }
}

class SeqOps
{
     int start, end;

     Seq max3(Seq a, Seq b, Seq c)
     {
	      Seq max =a;
		  if(max.val<b.val)
        	  max=b;
		  if(max.val<c.val)
              max=c;
          return (max) ;
      }

      Seq maxSum(int[] a, int Left, int Right)
      {
          int Center=(Left+Right) /2 ;
          Seq maxLeftBorderSum=new Seq(Center,Center,0), maxRightBorderSum=new Seq(Center,Center,0) ;
          Seq LeftBorderSum=new Seq(Center,Center,0), RightBorderSum=new Seq(Center,Center,0);
          if(Left==Right)
            return new Seq(Left,Left,a[Left]);
          Seq maxLeftSum=maxSum(a, Left, Center) ;
          Seq maxRightSum=maxSum(a, Center+1, Right) ;
          for(int i=Center; i>=Left; i--) {
              LeftBorderSum.val +=a[i] ;
              LeftBorderSum.start--;
              if(LeftBorderSum.val>maxLeftBorderSum.val){
                 maxLeftBorderSum.val=LeftBorderSum.val;
                 maxLeftBorderSum.start=LeftBorderSum.start;
              }
          }
          for(int j=Center+1; j<=Right; j++) {
              RightBorderSum.val +=a[j] ;
              RightBorderSum.end++;
              if(RightBorderSum.val>maxRightBorderSum.val){
                 maxRightBorderSum.val=RightBorderSum.val;
                 maxRightBorderSum.end=RightBorderSum.end;
              }
          }
          Seq tmp = new Seq(maxLeftBorderSum.start,maxRightBorderSum.end,maxLeftBorderSum.val+maxRightBorderSum.val);
          return max3(maxLeftSum, maxRightSum, tmp) ;
      } 
}

class Seq{
	int start, end;
	int val;
	Seq(int s, int e, int v){
		start=s;
		end=e;
		val=v;
	}
}
//----------------------------------------------------