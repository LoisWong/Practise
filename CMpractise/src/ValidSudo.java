import java.util.HashSet;


public class ValidSudo {
	public boolean isValidSudoku(char[][] board) {
    	//定义检查区域，column and row
        for (int i=0; i<9; i++){
        	if (!check(board,i,i+1,0,9))return false;
        	if (!check(board,0,9,i,i+1))return false;
        }
        //定义检查block区域
        for (int i=0; i<3; i++){
        	for (int j=0; j<3; j++){
        		if (!check(board, i*3, i*3+3, j*3, j*3+3))return false;
        	}
        }
        return true;
    }
    public boolean check(char[][] board, int xstart, int xend, int ystart, int yend) {
    	//检查该区域内是否有重复数字
    	HashSet<Character> sudo = new HashSet<Character>();
    	for (int x=xstart; x<xend; x++){
    		for (int y=ystart; y<yend; y++){
    			if (board[x][y] == '.'){continue;}
    			if (!sudo.add(board[x][y])){return false;}
    		}
    	}
    	return true;
    }
}
