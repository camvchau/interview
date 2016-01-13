import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solve {
	public static void main(String[] args) throws Exception {
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		String line;
		List<String> inputLines = new ArrayList<String>();
		while ((line = stdin.readLine()) != null) {
			inputLines.add(line);
		}
		SudokuBoard board = new SudokuBoard(inputLines);
		if(!board.isBoardValid()) {
			System.err.println("Invalid values entered.");
		} else {
			if (solve(0, 0, board)) board.printBoard();
		}
	}
	

	static boolean solve(int row, int col, SudokuBoard board) {		
		if (row == 9) {
			row = 0;
			
			//solved if it's the last cell
			if (++col == 9) return true; 
		}
		
		//skip if filled
		if (board.isFilled(row, col)) 
			return solve(row+1,col,board);
		
		//iterate to the first legal value then solve the rest 
		for (int val = 1; val <= 9; val++) {
			if (board.legal(row,col,val)) {  
				board.setValueAt(row, col, val);
				if (solve(row+1,col,board))  
					return true;
			}
		}
    
		// reset on backtrack
		board.setValueAt(row, col, 0);
		return false;
    }

}
