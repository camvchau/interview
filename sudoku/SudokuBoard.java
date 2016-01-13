import java.util.List;

public class SudokuBoard {
	private int[][] board;
	private boolean isValid;
	
	public SudokuBoard(List<String> inputs){
		this.board = new int[9][9];
		this.isValid = true;
		
		int col = 0;
		int row = 0;
		for(String line : inputs) {
			for(String element : line.split(",")){
				if(element.equals("-")) {
					this.board[row][col%9] = 0;
				} else {
					try{
						int a = Integer.valueOf(element);
						this.board[row][col%9] = a;
						if(a > 9 || a < 0) this.isValid = false;
					} catch (NumberFormatException e){
						this.isValid = false;
					}
				}
				col++;
			}
			row++;
		}
	}

	public boolean legal(int row, int col, int value){
		for (int k = 0; k < 9; k++)  // col
		    if (value == this.board[k][col])
			return false;
		
		for (int k = 0; k < 9; k++) // row
		    if (value == this.board[row][k])
			return false;
		

		int boxRowOffset = (row/ 3)*3;
		int boxColOffset = (col/ 3)*3;
		for (int k = 0; k < 3; k++) // box
		    for (int m = 0; m < 3; m++)
			if (value == this.board[boxRowOffset+k][boxColOffset+m])
			    return false;

		return true;
	}
	
	public int getValueAt(int row, int col){
		return this.board[row][col];
	}
	
	public void setValueAt(int row, int col, int value){
		this.board[row][col] = value;
	}

	public boolean isFilled(int row, int col){
		return this.board[row][col] != 0;
	}
	
	public void printBoard(){
		for (int i = 0; i < 9; i++) {
		    for (int j = 0; j < 9; j++) {
		    	System.out.print(this.board[i][j] == 0
					 ? "-"
					 : Integer.toString(this.board[i][j]));
			
		    	if(j < 8) System.out.print(',');
		    }
		    System.out.println("");
		}

	}
	
	public boolean isBoardValid(){
		return this.isValid;
	}
}
