import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class anagram {
	public static void main(String[] args){
		Scanner keyboard = new Scanner(System.in);
		String s = keyboard.next();
		String t = keyboard.next();
		if (isAnagram(s,t)){
			System.out.println("They are anagram.");
		}
	}
    public static boolean isAnagram(String s, String t) {
        /*HashMap<Integer, Character> cache = new HashMap<Integer, Character>();
        if (s.length() != t.length()) return false;
        else{
        for (int i = 0; i < s.length(); i++){
        	cache.put(i, s.charAt(i));
        	
        }
        for (int j = 0; j < t.length();j++){
        	if(!cache.containsValue(t.charAt(j))){
        		return false;
        	}
        }
        if (cache.isEmpty()) return true;
        else return false;
        }*/
    	char[] ss = s.toCharArray();
    	char[] ts = t.toCharArray();
    	
    	Arrays.sort(ss);
    	Arrays.sort(ts);
    	
    	String ssorted = String.valueOf(ss);
    	String tsorted = String.valueOf(ts);
    	
    	return ssorted.equalsIgnoreCase(tsorted);
    }
}