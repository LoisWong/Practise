import java.util.HashMap;


public class SingleNum {
	public static void main (String[] args){
		int[] A = {1,1,1,2,2,2,4,4,3,3,4};
		System.out.print(singleNumber(A));
	}
	public static int singleNumber(int[] A) {
		//A method of using binary code. 
	    int ones = 0, twos = 0;
	    for(int i = 0; i < A.length; i++){
	        ones = (ones ^ A[i]) & ~twos;
	        twos = (twos ^ A[i]) & ~ones;
	    }
	    if (ones != 0 )return ones;
	    else return twos;
	    
		/*
        element in A is 32bit,
        sum corresponding bits from all elements and mod each by 3 then should left the single number
        */
        /*int[] sum=new int[32];
        int res=0;
        for(int i=0;i<32;i++)
        {
            for(int j=0;j<A.length;j++)
            {
                sum[i]+=((A[j]>>>i)&1);//sum every bit of all numbers
            }
            sum[i]%=3;
            res+=((sum[i]&1)<<i);// recover the single number
        }
        return res;*/
	}
}
