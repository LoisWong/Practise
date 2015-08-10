
public class RotateImage {
	public void rotate(int[][] matrix) {
        /*int n = matrix.length;
        int[][] rotate = new int[n][n];
        
        for (int i = 0; i < n; i++){
        	for (int j = 0; j < n;j++){
        		rotate[j][i] = matrix[n-i-1][j];
        	}
        }
        
        for (int i = 0; i < n; i++){
        	for (int j = 0; j < n;j++){
        		matrix[i][j] = rotate[i][j];
        	}
        }*/
		int n = matrix.length;
		//reverse array by half
        for (int i = 0; i < n/2; i++){
        	for (int j = 0; j < n;j++){
        	    int swap = matrix[i][j];
        		matrix[i][j] = matrix[n-1-i][j];
        		matrix[n-1-i][j] = swap;
        	}
        }
        
        //reverse array by x = -y line by half
        for (int i = 0; i < n; i++){
        	for (int j = i; j < n;j++){
        	    int swap = matrix[i][j];
        		matrix[i][j] = matrix[j][i];
        		matrix[j][i] = swap;
        	}
        }
    }
}
