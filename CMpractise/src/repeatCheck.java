import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class repeatCheck {
	public static void main(String[] args){
		String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
		for (String str:findRepeatedDnaSequences(s)){
			System.out.println(str);
		}
	}
	/*public static List<String> findRepeatedDnaSequences(String s) {
		List<String> RPDNA = new ArrayList<String>();
        int length = s.length();
        for (int i = 0; i<length-10; i++){
        	
        	//Check the part behind which has same beginning
        	for (int j = i+10; j<length-10; j++){
        		if (s.charAt(i) == s.charAt(j)){
        			String checkDna = check(s,i,j);
        			if(checkDna.isEmpty()){
            			continue;
            		}else{
            			RPDNA.add(checkDna);
            		}
        		}else continue;
        	}
        }
        return RPDNA;
    }
	public static String check(String s, int beginA, int beginB){
		//If string part from A and part from B are same and length is 10, return the part
		//Otherwise, return null;
		
		String checkDNA = new String();
		int flag = 0;
		while(flag<10){
			if (s.charAt(beginA) == s.charAt(beginB)){
				beginA++;
				beginB++;
				flag++;
			}else break;
		}
		if (flag == 10){
			checkDNA = s.substring(beginA-10, beginA);
		}
		return checkDNA;
	}*/
	
	//上方的算法超时了
	/*Set<Integer> words = new HashSet<>();
    Set<Integer> doubleWords = new HashSet<>();
    List<String> rv = new ArrayList<>();
    char[] map = new char[26];
    //map['A' - 'A'] = 0;
    map['C' - 'A'] = 1;
    map['G' - 'A'] = 2;
    map['T' - 'A'] = 3;

    for(int i = 0; i < s.length() - 9; i++) {
        int v = 0;
        for(int j = i; j < i + 10; j++) {
            v <<= 2;
            v |= map[s.charAt(j) - 'A'];
        }
        if(!words.add(v) && doubleWords.add(v)) {
            rv.add(s.substring(i, i + 10));
        }
    }
    return rv;*/
	//或者这样
	public static List<String> findRepeatedDnaSequences(String s) {
	    List<String> list = new ArrayList<String>();
	    if (s == null || s.length() < 10) return list;
	    HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();

	    for (int i = 0; i + 10 <= s.length(); i++ ) {
	        int hash = stringToHash(s.substring(i, i + 10));
	        if (map.containsKey(hash)) {
	            if (!map.get(hash)) {
	                list.add(s.substring(i, i + 10));
	                map.put(hash, true);
	            }
	        } else {
	            map.put(hash, false);
	        }
	    }
	    return list;
	}

	private static int stringToHash (String s) {
	    String numberBuilder = "";
	    for (int i = 0; i < s.length(); i++) {
	        if (s.charAt(i) == 'A') numberBuilder += "0";
	        if (s.charAt(i) == 'C') numberBuilder += "1";
	        if (s.charAt(i) == 'G') numberBuilder += "2";
	        if (s.charAt(i) == 'T') numberBuilder += "3";
	    }
	    return Integer.parseInt(numberBuilder, 4);
	}
}
