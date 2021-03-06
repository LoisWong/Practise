import java.util.Scanner;

public class isNumber {
	public static void main(String[] args){
		Scanner sn = new Scanner(System.in);
		String s;
		do {
			s = sn.nextLine();
			if (isNumber(s)) {
				System.out.println("True");
			} else
				System.out.println("False");
		}while (!s.equalsIgnoreCase("exit"));
	}
    public static boolean isNumber(String n) {
    	String s = n.trim();

        boolean pointSeen = false;
        boolean eSeen = false;
        boolean numberSeen = false;
        boolean numberAfterE = true;
        for(int i=0; i<s.length(); i++) {
            if('0' <= s.charAt(i) && s.charAt(i) <= '9') {
                numberSeen = true;
                numberAfterE = true;
            } else if(s.charAt(i) == '.') {
                if(eSeen || pointSeen) {
                    return false;
                }
                pointSeen = true;
            } else if(s.charAt(i) == 'e') {
                if(eSeen || !numberSeen) {
                    return false;
                }
                numberAfterE = false;
                eSeen = true;
            } else if(s.charAt(i) == '-' || s.charAt(i) == '+') {
                if(i != 0 && s.charAt(i-1) != 'e') {
                    return false;
                }
            } else {
                return false;
            }
        }

        return numberSeen && numberAfterE;
    }
}