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
    public static boolean isNumber(String s) {
    	String n = s.replaceAll("\\s+","");
        if (n.length() > 0){
        	if (n.charAt(0) != 'e'){
        		return n.matches("[-+]?[0-9]*(.[0-9]+)?(e[-+]?[0-9]+)?");
            }else return false;
        }else return false;
    }
}