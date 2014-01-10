package LeetCodeSolutions;

import java.util.ArrayList;
import java.util.HashMap;

public class SolveSudoku {
	private ArrayList<HashMap<Integer, Boolean[]>> comp;
    
    public void solveSudoku(char[][] board) {
        initialize(board);
        
        sudokuSolver(board, 0, 0);
    }
    
    private boolean sudokuSolver(char[][] board, int i, int j){
        if(i > 8){
            return true;
        }
        
        if(board[i][j] != '.'){
            return sudokuSolver(board, i + (j + 1) / 9, (j + 1) % 9);
        }else{
            for(int k = 1; k < 10; k++){
                if(isValid(board, i, j, k) && sudokuSolver(board, i + (j + 1) / 9, (j + 1) % 9)){
                    return true;
                }else{
                    clear(board, i, j);
                }
            }
            
            return false;
        }
    }
    
    private void initialize(char[][] board){
        comp = new ArrayList<HashMap<Integer, Boolean[]>>();
        for(int i = 0; i < 3; i++){
            comp.add(new HashMap<Integer, Boolean[]>());
            for(int j = 0; j < 9; j++){
            	Boolean[] bs = {false, false, false, false, false, false, false, false, false, false};
                comp.get(i).put(j, bs);
            }
        }
        
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] != '.'){
                    comp.get(0).get(i)[board[i][j] - '0'] = true;
                    comp.get(1).get(j)[board[i][j] - '0'] = true;
                    comp.get(2).get(i / 3 * 3 + j / 3)[board[i][j] - '0'] = true;
                }
            }
        }
    }
    
    private void set(char[][] board, int i, int j, int num){
        board[i][j] = String.valueOf(num).charAt(0);
        comp.get(0).get(i)[num] = true;
        comp.get(1).get(j)[num] = true;
        comp.get(2).get(i / 3 * 3 + j / 3)[num] = true;
    }
    
    private void clear(char[][] board, int i, int j){
    	if(board[i][j] != '.'){
    		int num = board[i][j] - '0';
            board[i][j] = '.';
            comp.get(0).get(i)[num] = false;
            comp.get(1).get(j)[num] = false;
            comp.get(2).get(i / 3 * 3 + j / 3)[num] = false;
    	}
    }
    
    private boolean isValid(char[][] board, int i, int j, int num){
        if(!comp.get(0).get(i)[num] && !comp.get(1).get(j)[num] && !comp.get(2).get(i / 3 * 3 + j / 3)[num]){
        	set(board, i, j, num);
        	return true;
        }
        
        return false;
    }
    
    public static void main(String[] args){
    	SolveSudoku ss = new SolveSudoku();
    	
    	char[][] board = {"..9748...".toCharArray(),
    			"7........".toCharArray(),
    			".2.1.9...".toCharArray(),
    			"..7...24.".toCharArray(),
    			".64.1.59.".toCharArray(),
    			".98...3..".toCharArray(),
    			"...8.3.2.".toCharArray(),
    			"........6".toCharArray(),
    			"...2759..".toCharArray()};
    	
    	ss.solveSudoku(board);
    	
    	for(int i = 0; i < board.length; i++){
        	Printer.printCharArray(board[i]);
    	}
    }
    
    
}
