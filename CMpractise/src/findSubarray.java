import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class findSubarray {
	/*
	 * Complete the function below.
	 */
	    static int findArray(int[] array, int[] subArray) {
	    	int len = array.length;
			int sublen = subArray.length;
			int flag = -1;
		    if (len == 0 && sublen > len){return flag;}
			for (int i=len-1; i>=0; i--){
			    if (array[i] != subArray[sublen-1]){
			        continue;
			    }else{
	                int test = i;
			        for (int j=sublen-1; j>=0;j--){
			            if (array[i] == subArray[j] && i>=0){
			            	i--;
			            }
			            if (j == 0){
	                        flag = i+1;
	                        return flag;
	                    }
			        }
	                i = test;
			    }
			}
			return flag;

	    }
	    public static void main(String[] args) throws IOException{
	        Scanner in = new Scanner(System.in);
	        final String fileName = System.getenv("OUTPUT_PATH");
	        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
	        int res;
	        
	        int _array_size = 0;
	        _array_size = Integer.parseInt(in.nextLine());
	        int[] _array = new int[_array_size];
	        int _array_item;
	        for(int _array_i = 0; _array_i < _array_size; _array_i++) {
	            _array_item = Integer.parseInt(in.nextLine());
	            _array[_array_i] = _array_item;
	        }
	        
	        
	        int _subArray_size = 0;
	        _subArray_size = Integer.parseInt(in.nextLine());
	        int[] _subArray = new int[_subArray_size];
	        int _subArray_item;
	        for(int _subArray_i = 0; _subArray_i < _subArray_size; _subArray_i++) {
	            _subArray_item = Integer.parseInt(in.nextLine());
	            _subArray[_subArray_i] = _subArray_item;
	        }
	        
	        res = findArray(_array, _subArray);
	        bw.write(String.valueOf(res));
	        bw.newLine();
	        
	        bw.close();
	    }
}

