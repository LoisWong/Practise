
public class SetZero {
	public void setZeroes(int[][] matrix) {
		int FirstRow = 1;
        int row = matrix.length;
        int col = matrix[0].length;
        //第一行是不是含有0，标记。因为之后第一行将作为标杆
        for (int j = 0; j < col; j++){
            if (matrix[0][j] == 0){
                FirstRow = 0;
                break;
            }
        }
        //标记第一行第一列标杆
        for (int i = 1; i < row; i++){
        	for (int j = 0; j < col; j++){
        		if (matrix[i][j] == 0){
        			matrix[i][0] = 0;
        			matrix[0][j] = 0;
        		}
        	}
        }
        //根据行列标杆标记置0数组项
        for (int i = row-1; i > 0; i--){
        	for (int j = col-1; j >= 0; j--){
        		if (matrix[i][0] == 0 || matrix[0][j] == 0){
        			matrix[i][j] = 0;
        		}
        	}
        }
        //最后根据起始标记决定是否置0整行
        if (FirstRow == 0){
            for (int j = 0; j < col; j++){matrix[0][j] = 0;}
        }
        //以首列标记作为标杆，简短解法
        /*int col0 = 1, rows = matrix.size(), cols = matrix[0].size();

        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) col0 = 0;
            for (int j = 1; j < cols; j++)
                if (matrix[i][j] == 0)
                    matrix[i][0] = matrix[0][j] = 0;
        }

        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 1; j--)
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            if (col0 == 0) matrix[i][0] = 0;
        }*/
    }
}
