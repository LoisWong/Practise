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
    public static boolean isNumber(String old) {
        String s = old.replaceAll("\\s+","");
        int lenth = s.length();
        char c;
        boolean flag = false;
        int dFlag = 0;
        int eFlag = 0;
        
        for (int i = 0; i < lenth; i++){
            c = s.charAt(i);
            if (c>=48 && c<=57){
                flag = true;
            }else if (c == '.' && i >= 0){
                dFlag++;
                if (dFlag <= 1 && (i+1) < lenth){
                    flag = true;
                }else {
                    flag = false;
                    return false;
                }
            }else if (c == 'e' && i > 0){
                eFlag++;
                if (eFlag <= 1){
                    flag = true;
                }else {
                    flag = false;
                    return false;
                }
            }else if (c == '-'){
                if (i == 0 && lenth >1){
                    flag = true;
                }else {
                    flag = false;
                    return false;
                }
            }else return false;
        }
        return flag;
    }
}