import java.util.HashMap;
import java.lang.Math;

public class Bishop extends Piece {
	
	public Bishop(int column, int row, String imgURL, String name, boolean isWhite) {
		super(column, row, imgURL, name, isWhite);
	}

	/*
	 * This method returns a boolean for whether or not the piece can move to a certain target location
	 */
	public boolean canMove(int targetColumn, int targetRow, HashMap<String, Piece> whitePieces, HashMap<String, Piece> blackPieces) {
		String colRow = Integer.toString(targetColumn) + Integer.toString(targetRow);
		int rowDif = targetRow - this.row;
		int colDif = targetColumn - this.column;

		if (this.isWhite) {
			if (whitePieces.containsKey(colRow)) {
				return false;
			}
			else if (Math.abs(rowDif) == Math.abs(colDif)) {
				if (rowDif > 0 && colDif > 0) {
					int j = 1;
					for (int i = this.row + 1; i < targetRow; i++) {
						String testColRow = Integer.toString(this.column + j) + Integer.toString(i);
						if (whitePieces.containsKey(testColRow) || blackPieces.containsKey(testColRow)) {
							return false;
						}
						j++;
					}
				}
				else if (rowDif < 0 && colDif > 0) {
					int j = 1;
					for (int i = this.row - 1; i > targetRow; i--) {
						String testColRow = Integer.toString(this.column + j) + Integer.toString(i);
						if (whitePieces.containsKey(testColRow) || blackPieces.containsKey(testColRow)) {
							return false;
						}
						j++;
					}
				}
				else if (rowDif > 0 && colDif < 0) {
					int j = 1;
					for (int i = this.row + 1; i < targetRow; i++) {
						String testColRow = Integer.toString(this.column - j) + Integer.toString(i);
						if (whitePieces.containsKey(testColRow) || blackPieces.containsKey(testColRow)) {
							return false;
						}
						j++;
					}
				}
				else if (rowDif < 0 && colDif < 0) {
					int j = 1;
					for (int i = this.row - 1; i > targetRow; i--) {
						String testColRow = Integer.toString(this.column - j) + Integer.toString(i);
						if (whitePieces.containsKey(testColRow) || blackPieces.containsKey(testColRow)) {
							return false;
						}
						j++;
					}
				}
				return true;
			}
			
		}
		else {
			if (blackPieces.containsKey(colRow)) {
				return false;
			}
			else if (Math.abs(rowDif) == Math.abs(colDif)) {
				if (rowDif > 0 && colDif > 0) {
					int j = 1;
					for (int i = this.row + 1; i < targetRow; i++) {
						String testColRow = Integer.toString(this.column + j) + Integer.toString(i);
						if (whitePieces.containsKey(testColRow) || blackPieces.containsKey(testColRow)) {
							return false;
						}
						j++;
					}
				}
				else if (rowDif < 0 && colDif > 0) {
					int j = 1;
					for (int i = this.row - 1; i > targetRow; i--) {
						String testColRow = Integer.toString(this.column + j) + Integer.toString(i);
						if (whitePieces.containsKey(testColRow) || blackPieces.containsKey(testColRow)) {
							return false;
						}
						j++;
					}
				}
				else if (rowDif > 0 && colDif < 0) {
					int j = 1;
					for (int i = this.row + 1; i < targetRow; i++) {
						String testColRow = Integer.toString(this.column - j) + Integer.toString(i);
						if (whitePieces.containsKey(testColRow) || blackPieces.containsKey(testColRow)) {
							return false;
						}
						j++;
					}
				}
				else if (rowDif < 0 && colDif < 0) {
					int j = 1;
					for (int i = this.row - 1; i > targetRow; i--) {
						String testColRow = Integer.toString(this.column - j) + Integer.toString(i);
						if (whitePieces.containsKey(testColRow) || blackPieces.containsKey(testColRow)) {
							return false;
						}
						j++;
					}
				}
				return true;
			}
			
		}

		return false;
	}
}
