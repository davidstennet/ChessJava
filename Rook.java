import java.util.HashMap;

public class Rook extends Piece {
	
	public Rook(int column, int row, String imgURL, String name, boolean isWhite) {
		super(column, row, imgURL, name, isWhite);
	}

	/*
	 * This method returns a boolean for whether or not the piece can move to a certain target location
	 */
	public boolean canMove(int targetColumn, int targetRow, HashMap<String, Piece> whitePieces, HashMap<String, Piece> blackPieces) {
		String colRow = Integer.toString(targetColumn) + Integer.toString(targetRow);

		if (this.isWhite) { // Implementation for moving White Rook
			if (whitePieces.containsKey(colRow)) { // If clicked on piece of same color then return false
				return false;
			}
			else if (targetRow == this.row) { // Checks that the target is in the same row
				if (targetColumn > this.column) {
					// This for loop will go through all of the pieces that are in front of where the user clicked to see if it is allowed to move there
					for (int i = this.column + 1; i < targetColumn; i++) {
						String testColRow = Integer.toString(i) + Integer.toString(targetRow);
						if (whitePieces.containsKey(testColRow) || blackPieces.containsKey(testColRow)) {
							return false;
						}
					}
					return true;
				}
				else if (targetColumn < this.column) { 
										// This for loop will go through all of the pieces that are in front of where the user clicked to see if it is allowed to move there

					for (int i = this.column - 1; i > targetColumn; i--) {
						String testColRow = Integer.toString(i) + Integer.toString(targetRow);
						if (whitePieces.containsKey(testColRow) || blackPieces.containsKey(testColRow)) {
							return false;
						}
					}
					return true;
				}
			}
			else if (targetColumn == this.column) {
				if (targetRow > this.row) {
					for (int i = this.row + 1; i < targetRow; i++) {
						String testColRow = Integer.toString(targetColumn) + Integer.toString(i);
						if (whitePieces.containsKey(testColRow) || blackPieces.containsKey(testColRow)) {
							return false;
						}
					}
					return true;
				}
				else if (targetRow < this.row) {
					for (int i = this.row - 1; i > targetRow; i--) {
						String testColRow = Integer.toString(targetColumn) + Integer.toString(i);
						if (whitePieces.containsKey(testColRow) || blackPieces.containsKey(testColRow)) {
							return false;
						}
					}
					return true;
				}
			}
		}
		else {
			if (blackPieces.containsKey(colRow)) {
				return false;
			}
			else if (targetRow == this.row) { // Checks that the target is in the same row
				if (targetColumn > this.column) {
					// This for loop will go through all of the pieces that are in front of where the user clicked to see if it is allowed to move there
					for (int i = this.column + 1; i < targetColumn; i++) {
						String testColRow = Integer.toString(i) + Integer.toString(targetRow);
						if (whitePieces.containsKey(testColRow) || blackPieces.containsKey(testColRow)) {
							return false;
						}
					}
					return true;
				}
				else if (targetColumn < this.column) { 
										// This for loop will go through all of the pieces that are in front of where the user clicked to see if it is allowed to move there

					for (int i = this.column - 1; i > targetColumn; i--) {
						String testColRow = Integer.toString(i) + Integer.toString(targetRow);
						if (whitePieces.containsKey(testColRow) || blackPieces.containsKey(testColRow)) {
							return false;
						}
					}
					return true;
				}
			}
			else if (targetColumn == this.column) {
				if (targetRow > this.row) {
					for (int i = this.row + 1; i < targetRow; i++) {
						String testColRow = Integer.toString(targetColumn) + Integer.toString(i);
						if (whitePieces.containsKey(testColRow) || blackPieces.containsKey(testColRow)) {
							return false;
						}
					}
					return true;
				}
				else if (targetRow < this.row) {
					for (int i = this.row - 1; i > targetRow; i--) {
						String testColRow = Integer.toString(targetColumn) + Integer.toString(i);
						if (whitePieces.containsKey(testColRow) || blackPieces.containsKey(testColRow)) {
							return false;
						}
					}
					return true;
				}
			}
		}
	

		return false;
	}
}
