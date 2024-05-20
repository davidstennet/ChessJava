import java.util.HashMap;

public class Knight extends Piece {
	
	public Knight(int column, int row, String imgURL, String name, boolean isWhite) {
		super(column, row, imgURL, name, isWhite);
	}

	public boolean canMove(int targetColumn, int targetRow, HashMap<String, Piece> whitePieces, HashMap<String, Piece> blackPieces) {
		String colRow = Integer.toString(targetColumn) + Integer.toString(targetRow);

		// Checks whether the Piece is white
		if (isWhite) {
			if (whitePieces.containsKey(colRow)) { // Checks the target location for whether the locations contains a white piece
				return false;
			}
			int j = 2;
			for (int i = 1; i < 3; i++) {
				if (targetRow == this.row + i) {
					if (targetColumn == this.column + j) {
						return true;
					}
					else if (targetColumn == this.column - j) {
						return true;
					}
				}
				else if (targetRow == this.row - i) {
					if (targetColumn == this.column + j) {
						return true;
					}
					else if (targetColumn == this.column - j) {
						return true;
					}
				}
				j--;
			}
		}
		// This section is for when the Piece is black
		else {
			if (blackPieces.containsKey(colRow)) { // Checks the target location for whether the locations contains a black piece
				return false;
			}
			int j = 2;
			for (int i = 1; i < 3; i++) {
				if (targetRow == this.row + i) {
					if (targetColumn == this.column + j) {
						return true;
					}
					else if (targetColumn == this.column - j) {
						return true;
					}
				}
				else if (targetRow == this.row - i) {
					if (targetColumn == this.column + j) {
						return true;
					}
					else if (targetColumn == this.column - j) {
						return true;
					}
				}
				j--;
			}
		}


		return false;
	}
}
