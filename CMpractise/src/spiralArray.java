
public class spiralArray {
	public static void main(String[] args){
		int[][] spiral = generateMatrix(3);
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				System.out.print(spiral[i][j]);
			}
			System.out.println();
		}
	}
	public static int[][] generateMatrix(int n) {
        int[][] Matrix = new int[n][n];
        int count = 0;
        int move = 0;
        int eright = n-1;
        int edown = n-1;
        int eleft = 0;
        int eup = 0;
        while (count <= n*n && eleft <= eright && eup <= edown){
        	//move to right direction
            while (move <= eright){
            	Matrix[eup][move] = ++count;
            	move++;
            }
            eup++;
            move = eup;
            //move to down direction
            while (move <= edown){
            	Matrix[move][eright] = ++count;
            	move++;
            }
            eright--;
            move = eright;
            //move to left direction
            while (move >= eleft){
            	Matrix[edown][move] = ++count;
            	move--;
            }
            edown--;
            move = edown;
            //move to up direction
            while (move >= eup){
            	Matrix[move][eleft] = ++count;
            	move--;
            }
            eleft++;
            move = eleft;
        }
        return Matrix;
    }
}
