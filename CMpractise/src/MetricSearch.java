
public class MetricSearch {
	public static void main(String[] args){
		int[][] matrix = {{1},{3}};//{{1,3,5,7},{10,11,16,20},{23,30,34,50}};
		int target = 3;
		if(searchMatrix(matrix, target)){
			System.out.print("true");
		}else System.out.print("false");
	}
	public static boolean searchMatrix(int[][] matrix, int target) {
        int up = 0;
        int left = 0;
        int down = matrix.length-1;
        int right = matrix[0].length-1;
        if (matrix[0][0] == target) return true;
        while (up != down-1 && up < down){
        	if (target >= matrix[(up+down)/2][0]){
        		up = (up + down)/2;
        		if (target == matrix[up][0]) return true;
        	}else down = (up + down)/2;
        }
        while (left != right-1 && left < right){
        	if (target >= matrix[up][(left+right)/2]){
        		left = (left+right)/2;
        		if (target == matrix[up][left]) return true;
        	}else right = (left+right)/2;
        }
        
        return false;
    }
}
