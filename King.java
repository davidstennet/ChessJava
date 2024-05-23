import java.util.HashMap;

public class King extends Piece {
	
	public King(int column, int row, String imgURL, String name, boolean isWhite) {
		super(column, row, imgURL, name, isWhite);
	}

	/*
	 * This method returns a boolean for whether or not the piece can move to a certain target location
	 */
	public boolean canMove(int targetColumn, int targetRow, HashMap<String, Piece> whitePieces, HashMap<String, Piece> blackPieces) {
		return false;
	}

}
