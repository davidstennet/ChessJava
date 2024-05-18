import java.util.HashMap;

public class Bishop extends Piece {
	
	public Bishop(int column, int row, String imgURL, String name, boolean isWhite) {
		super(column, row, imgURL, name, isWhite);
	}

		
	public boolean canMove(int targetColumn, int targetRow, HashMap<String, Piece> whitePieces, HashMap<String, Piece> blackPieces) {
		return false;
	}
}
