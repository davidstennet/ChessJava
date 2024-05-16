import java.util.HashMap;

public class Player {
	
	private HashMap<String, Piece> pieceLocation;
	private String name;
	
	public Player(String name, HashMap<String, Piece> pieceLocation) {
		this.name = name;
		this.pieceLocation = pieceLocation;
	}
	
	
	// Getters and setters for instance variables
	public HashMap<String, Piece> getPieceLocation() { return this.pieceLocation; }
	public String getName() { return this.name; }
	
	public void setPieceLocation(HashMap<String, Piece> pieceLocation) { this.pieceLocation = pieceLocation; }
	public void setName(String name) { this.name = name; }

}
