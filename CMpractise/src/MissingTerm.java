import java.io.*;
import java.util.Scanner;
public class MissingTerm {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int array[] = new int[2500];
        int d = 0;
        for (int t = 0; t < n; t++){
            array[t] = sc.nextInt();
            if (t < 2)continue;
            if (t == 2){
                int a = array[1]-array[0];
                int b = array[2]-array[1];
                if(a>b){
                    System.out.println(array[1]-b);
                    break;
                }if(a<b){
                    System.out.println(array[2]-a);
                    break;
                }else d = a;
            }
            if(array[t] - array[t-1] != d){
                System.out.println(array[t-1]+d);
            }
        }
    }
}
