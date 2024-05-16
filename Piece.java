public abstract class Piece {
	
	protected int column;
	protected int row;
	protected String imgURL;
	protected String name;
	
	public Piece(int column, int row, String imgURL, String name) {
		this.column = column;
		this.row = row;
		this.imgURL = imgURL;
	}

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

}
