import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class FindingDigit {
	static void findingDigits(int[] foo) {
		int size = foo.length;
		if (size == 0){
			System.out.println("0");
		}
		for (int i = 0; i < size; i++){
			int count=0;
			int devide = foo[i];
			while (devide > 0){
				int mod = devide%10;
				if (mod != 0 && foo[i]%mod == 0){
					count++;
				}
				devide = devide/10;
			}
			System.out.println(count);
		}

    }
	public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        
        int _foo_size = 0;
        _foo_size = Integer.parseInt(in.nextLine());
        int[] _foo = new int[_foo_size];
        int _foo_item;
        for(int _foo_i = 0; _foo_i < _foo_size; _foo_i++) {
            _foo_item = Integer.parseInt(in.nextLine());
            _foo[_foo_i] = _foo_item;
        }
        
        findingDigits(_foo);
        
    }
}
