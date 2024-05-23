import java.util.HashMap;

public abstract class Piece {
	
	protected int column;
	protected int row;
	protected String imgURL;
	protected String name;
    protected boolean isWhite;
	
	public Piece(int column, int row, String imgURL, String name, boolean isWhite) {
		this.column = column;
		this.row = row;
		this.imgURL = imgURL;
        this.name = name;
        this.isWhite = isWhite;
	}

    /*
	 * This method returns a boolean for whether or not the piece can move to a certain target location
	 */
    abstract boolean canMove(int targetColumn, int targetRow, HashMap<String, Piece> whitePieces, HashMap<String, Piece> blackPieces);

	// Getter for xPos
    public int getColumn() {
        return this.column;
    }

    // Setter for xPos
    public void setColumn(int column) {
        this.column = column;
    }

    // Getter for yPos
    public int getRow() {
        return this.row;
    }

    // Setter for yPos
    public void setRow(int row) {
        this.row = row;
    }

    // Getter for imgURL
    public String getImgURL() {
        return imgURL;
    }

    // Setter for imgURL
    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

	// Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for isWhite
    public boolean isWhite() {
        return isWhite;
    }

    // Setter for isWhite
    public void setWhite(boolean isWhite) {
        this.isWhite = isWhite;
    }

}
