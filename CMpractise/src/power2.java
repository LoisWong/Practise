
public class power2 {
	public static void main(String[] args){
		if(isPowerOfTwo(-2147483648)){//It is a magic number
			System.out.print("It is a power of two");
		}else System.out.print("It is not");
	} 
	 public static boolean isPowerOfTwo(int n) {
		 int sum = 0;
		 if (n < 0) return false;
		 for (int i = 0; i < 32; i++){
			 //count every bit to see if only contain a 1, others are 0
			 sum += (n>>>i)&1;   
		 }
		 if (sum == 1){
			 return true;
		 }
		 else return false;
	 }
}
