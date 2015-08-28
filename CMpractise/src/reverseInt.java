
public class reverseInt {
	public static void main(String[] args){
		int x = 1234567899;
		System.out.print(reverse(x));
	}
    public static int reverse(int x) {
    	long newnum = 0;
    	int sign = 1;
    	if (x < 0){
    		sign = -1;
    		x = Math.abs(x);
    	}
        while (x > 0){
        	newnum = newnum *10 + (x % 10);
        	//In case number overflow
        	if (newnum > Integer.MAX_VALUE){
        		return 0;
        	}
        	x = x/10;
        }
        return (int)newnum*sign;
    }
}
