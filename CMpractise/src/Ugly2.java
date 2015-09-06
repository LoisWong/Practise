//We can find that every subsequence is the ugly-sequence itself (1, 2, 3, 4, 5, É) 
//multiply 2, 3, 5.

//Then we use similar merge method as merge sort, to get every ugly number from the 
//three subsequence.

//Every step we choose the smallest one, and move one step after,including nums with 
//same value.
public class Ugly2 {
	public int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        ugly[0]=1;
        int factor2 = 2, factor3 = 3, factor5 = 5;
        int index2 = 0, index3 = 0, index5 = 0;
        for (int i = 1; i < n; i++){
        	int min = Math.min(Math.min(factor2, factor3), factor5);
        	ugly[i] = min;
        	if (factor2 == min){
        		index2++;
        		factor2 = 2*ugly[index2];
        	}
            if(factor3 == min){
            	index3++;
                factor3 = 3*ugly[index3];
            }
            if(factor5 == min){
            	index5++;
                factor5 = 5*ugly[index5];
            }
        }
        return ugly[n-1];
    }
}
