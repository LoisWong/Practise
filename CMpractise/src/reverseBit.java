import java.util.HashMap;
import java.util.Map;


public class reverseBit {
	public static void main(String[] args){
		int x = -43261596;
		System.out.println(Integer.toBinaryString(x));
		int y = reverseBits(x);
		System.out.println(y);
		System.out.println(Integer.toBinaryString(y));
	}
    /*public static int reverseBits(int n) {
    	int m=0;
        int sign = (n<0)?-1:1; 
        for (int i = 0; i < 32; i++){
        	m = (m << 1) + (n%2);
        	n = n >> 1;
        }
        return m*sign;
    }*/
	
	private final static Map<Byte, Integer> cache = new HashMap<Byte, Integer>();
	public static int reverseBits(int n) {
	    byte[] bytes = new byte[4];
	    for (int i = 0; i < 4; i++) // convert int into 4 bytes
	        bytes[i] = (byte)((n >>> 8*i) & 0xFF);
	    int result = 0;
	    for (int i = 0; i < 4; i++) {
	        result += reverseByte(bytes[i]); // reverse per byte
	        if (i < 3)
	            result <<= 8;
	    }
	    return result;
	}

	private static int reverseByte(byte b) {
	    Integer value = cache.get(b); // first look up from cache
	    if (value != null)
	        return value;
	    value = 0;
	    // reverse by bit
	    for (int i = 0; i < 8; i++) {
	        value += ((b >>> i) & 1);
	        if (i < 7)
	            value <<= 1;
	    }
	    cache.put(b, value);
	    return value;
	}
}
