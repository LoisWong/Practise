//calculate the number of unique binary search tree
//G(n) = F(1, n) + F(2, n) + ... + F(n, n). 
//G(0)=1, G(1)=1
//F(i,n)都能分解为(i-1)个左子树的BST乘以（n-i）个右子树的BST
//F(i,n) = G(i-1)*G(n-i);
//G(n) =  G(0)*G(n-1) + G(1)*G(n-2) + ... + G(n-1)*G(0)

public class BST {
	public int number(int n){
		int result[]=new int [n+1];
	    result[0]=1;
	    result[1]=1;
	    if(n<2){
	    	return result[n];
	    }
	    for(int i=2;i<=n;i++){
	        for(int k=1;k<=i;++k){
	        	result[i] += result[k-1]*result[i-k];
	        }
	    }
	    return result[n];
	    }    
}
