
public class Ugly {
	//最大质因数为2，3，5则最后剩下的质数不能被2，3，5中任意一个除尽
	public boolean isUgly(int num) {
        if (num <= 0) 
        	return false;
        else if (num == 1)
        	return true;
        else {
        	if (num % 2 == 0)
        		return isUgly(num/2);
        	else if (num % 3 == 0)
        		return isUgly(num/3);
        	else if (num % 5 == 0)
        		return isUgly(num/5);
        	else return false;
        }
    }
}
