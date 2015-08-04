import java.util.Scanner;


public class RomeToInt {
	public static void main(String[] args){
		Scanner keyboard = new Scanner(System.in);
		String s = keyboard.next();
		System.out.print(romanToInt(s));
	}
	//Read from right to left.
	public static int romanToInt(String s) {
        char c[] = s.toCharArray();
        int l = s.length();
        int num=0;
        while (l>0){
        	--l;
        	char ch = c[l];
        	switch(ch){
        	case 'I':
        		if(num >= 5){
        			num = num - 1;
        		}else num = num + 1;
        		break;
        	case 'V':
        		num += 5;
        		break;
        	case 'X':
        		if(num >= 50){
        			num = num - 10;
        		}else num = num + 10;
        		break;
        	case 'L':
        		num += 50;
        		break;
        	case 'C':
        		if(num >= 500){
        			num = num - 100;
        		}else num = num + 100;
        		break;
        	case 'D':
        		num += 500;
        		break;
        	case 'M':
        		if(num >= 5000){
        			num = num - 1000;
        		}else num = num + 1000;
        		break;
        	}
        }
        return num;
    }
	
}
