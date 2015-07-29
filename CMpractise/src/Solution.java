public class Solution {
	public static void main(String[] args){
		System.out.println(titleToNumber("AAB"));
	}
	
	public static int titleToNumber(String s) {
        int num = 0;
        s.toUpperCase();
        for (int i=0; i<s.length(); i++){
            num = num * 26 + (s.charAt(i)-64);
        }
        return num;
    }
	
    public int HWeight (int n){
    	return Integer.bitCount(n);
    }
}

