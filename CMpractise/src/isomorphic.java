import java.util.HashMap;
import java.util.Scanner;

public class isomorphic {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()){
		    String s = sc.next();
		    String t = sc.next();
		    if(isIsomorphic(s,t)) System.out.println("True");
		    else System.out.println("False");
			}
	}
	static boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> mapping = new HashMap<Character, Character>();
        //For each char in string, mapping (Key:si ,Value:ti)
        if (s.length() != t.length()){
        	return false;
        }else{
        	for (int i=0; i < s.length(); i++){
        		char sc = s.charAt(i);
        		char tc = t.charAt(i);
        		if (mapping.containsKey(sc)){
        			if (mapping.get(sc) != tc){
        				return false;
        			}else continue;
        		}else {
        			if (mapping.containsValue(tc)){
        				return false;
        			}else mapping.put(sc, tc);
        		}
        	}
        	return true;
        }
        //另一种数组解法，但仅考虑ascii码范围
        /*for(var i = 0; i < s.length; i++){
            if(!obj['s' + s[i]]) obj['s' + s[i]] = t[i];
            if(!obj['t' + t[i]]) obj['t' + t[i]] = s[i];
            if(t[i] != obj['s' + s[i]] || s[i] != obj['t' + t[i]]) return false;
        }
        return true;*/
    }
}
