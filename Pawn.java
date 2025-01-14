import java.util.HashMap;

public class Pawn extends Piece {

	private boolean hasMoved; // This boolean will be used to check if the pawn has moved before
	
	public Pawn(int column, int row, String imgURL, String name, boolean isWhite) {
		super(column, row, imgURL, name, isWhite);
		this.hasMoved = false;
	}

	/*
	 * This method returns a boolean for whether or not the piece can move to a certain target location
	 */
	public boolean canMove(int targetColumn, int targetRow, HashMap<String, Piece> whitePieces, HashMap<String, Piece> blackPieces) {
		String colRow = Integer.toString(targetColumn) + Integer.toString(targetRow);

		if (this.isWhite) {
			// If target location doesn't contain a piece and this piece is white
			if (!whitePieces.containsKey(colRow) && !blackPieces.containsKey(colRow)) {
				if (targetColumn == this.column && targetRow == this.row + 1 ) { // If in the same column, row is one above piece
					this.hasMoved = true;
					return true;
				}
				else if (targetColumn == this.column && targetRow == this.row + 2 && !this.hasMoved) {
					this.hasMoved = true;
					return true;
				}
			}
			else if ((targetColumn == this.column + 1 || targetColumn == this.column -1) && targetRow == this.row + 1 && blackPieces.containsKey(colRow) ){
				this.hasMoved = true;
				return true;
			}
			else {
				return false;
			}
		}
		else {
			if (!whitePieces.containsKey(colRow) && !blackPieces.containsKey(colRow)) { // If target location doesn't contain a white or black piece and is a white piece
				if (targetColumn == this.column && targetRow == this.row - 1 ) { // If in the same column, row is one above piece
					this.hasMoved = true;
					return true;
				}
				else if (targetColumn == this.column && targetRow == this.row - 2 && !this.hasMoved) {
					this.hasMoved = true;
					return true;
				}
			}
			else if ((targetColumn == this.column + 1 || targetColumn == this.column -1) && targetRow == this.row - 1 && whitePieces.containsKey(colRow)) {
				this.hasMoved = true;
				return true;
			}
			else {
				return false;
			}
		}
		return false;
	}


	// Getter for hasMoved
    public boolean hasMoved() {
        return hasMoved;
    }

    // Setter for hasMoved
    public void setHasMoved(boolean hasMoved) {
        this.hasMoved = hasMoved;
    }



}
