import java.awt.EventQueue;
import java.util.HashMap;

public class Main {
	
	public static void main(String[] args) {
		
		HashMap<String, Piece> whiteLocations = new HashMap<String, Piece>();
		HashMap<String, Piece> blackLocations = new HashMap<String, Piece>();
		
		// Creation of all the white objects and putting them into whiteLocations
		Piece whitePawn1 = new Pawn(1, 2,"PieceIMGs/white-pawn.png", "Pawn");
		Piece whitePawn2 = new Pawn(2, 2,"PieceIMGs/white-pawn.png", "Pawn");
		Piece whitePawn3 = new Pawn(3, 2,"PieceIMGs/white-pawn.png", "Pawn");
		Piece whitePawn4 = new Pawn(4, 2,"PieceIMGs/white-pawn.png", "Pawn");
		Piece whitePawn5 = new Pawn(5, 2,"PieceIMGs/white-pawn.png", "Pawn");
		Piece whitePawn6 = new Pawn(6, 2,"PieceIMGs/white-pawn.png", "Pawn");
		Piece whitePawn7 = new Pawn(7, 2,"PieceIMGs/white-pawn.png", "Pawn");
		Piece whitePawn8 = new Pawn(8, 2,"PieceIMGs/white-pawn.png", "Pawn");
		Piece whiteRook1 = new Rook(1, 1,"PieceIMGs/white-rook.png", "Pawn");
		Piece whiteRook2 = new Rook(8, 1,"PieceIMGs/white-rook.png", "Pawn");
		Piece whiteKnight1 = new Knight(2, 1,"PieceIMGs/white-knight.png", "Knight");
		Piece whiteKnight2 = new Knight(7, 1,"PieceIMGs/white-knight.png", "Knight");
		Piece whiteBishop1 = new Bishop(3, 1, "PieceIMGs/white-bishop.png", "Bishop");
		Piece whiteBishop2 = new Bishop(6, 1, "PieceIMGs/white-bishop.png", "Bishop");
		Piece whiteQueen = new Queen(4, 1, "PieceIMGs/white-queen.png", "Queen");
		Piece whiteKing = new King(5, 1, "PieceIMGs/white-king.png", "King");

		whiteLocations.put("12", whitePawn1);
		whiteLocations.put("22", whitePawn2);
		whiteLocations.put("32", whitePawn3);
		whiteLocations.put("42", whitePawn4);
		whiteLocations.put("52", whitePawn5);
		whiteLocations.put("62", whitePawn6);
		whiteLocations.put("72", whitePawn7);
		whiteLocations.put("82", whitePawn8);
		whiteLocations.put("11", whiteRook1);
		whiteLocations.put("81", whiteRook2);
		whiteLocations.put("21", whiteKnight1);
		whiteLocations.put("71", whiteKnight2);
		whiteLocations.put("31", whiteBishop1);
		whiteLocations.put("61", whiteBishop2);
		whiteLocations.put("41", whiteQueen);
		whiteLocations.put("51", whiteKing);

		// Creation of black objects and putting them into blackLocations
		Piece blackPawn1 = new Pawn(1, 7,"PieceIMGs/black-pawn.png", "Pawn");
		Piece blackPawn2 = new Pawn(2, 7,"PieceIMGs/black-pawn.png", "Pawn");
		Piece blackPawn3 = new Pawn(3, 7,"PieceIMGs/black-pawn.png", "Pawn");
		Piece blackPawn4 = new Pawn(4, 7,"PieceIMGs/black-pawn.png", "Pawn");
		Piece blackPawn5 = new Pawn(5, 7,"PieceIMGs/black-pawn.png", "Pawn");
		Piece blackPawn6 = new Pawn(6, 7,"PieceIMGs/black-pawn.png", "Pawn");
		Piece blackPawn7 = new Pawn(7, 7,"PieceIMGs/black-pawn.png", "Pawn");
		Piece blackPawn8 = new Pawn(8, 7,"PieceIMGs/black-pawn.png", "Pawn");
		Piece blackRook1 = new Rook(1, 8,"PieceIMGs/black-rook.png", "Rook");
		Piece blackRook2 = new Rook(8, 8,"PieceIMGs/black-rook.png", "Rook");
		Piece blackKnight1 = new Knight(2, 8,"PieceIMGs/black-knight.png", "Knight");
		Piece blackKnight2 = new Knight(7, 8,"PieceIMGs/black-knight.png", "Knight");
		Piece blackBishop1 = new Bishop(3, 8,"PieceIMGs/black-bishop.png", "Bishop");
		Piece blackBishop2 = new Bishop(6, 8,"PieceIMGs/black-bishop.png", "Bishop");
		Piece blackQueen = new Queen(4, 8,"PieceIMGs/black-queen.png", "Queen");
		Piece blackKing = new King(5, 8,"PieceIMGs/black-king.png", "King");

		blackLocations.put("17", blackPawn1);
		blackLocations.put("27", blackPawn2);
		blackLocations.put("37", blackPawn3);
		blackLocations.put("47", blackPawn4);
		blackLocations.put("57", blackPawn5);
		blackLocations.put("67", blackPawn6);
		blackLocations.put("77", blackPawn7);
		blackLocations.put("87", blackPawn8);
		blackLocations.put("18", blackRook1);
		blackLocations.put("88", blackRook2);
		blackLocations.put("28", blackKnight1);
		blackLocations.put("78", blackKnight2);
		blackLocations.put("38", blackBishop1);
		blackLocations.put("68", blackBishop2);
		blackLocations.put("48", blackQueen);
		blackLocations.put("58", blackKing);

		// Creation of players and the battle objects
		Player white = new Player("White", whiteLocations);
		Player black = new Player("Black", blackLocations);

		Battle battle = new Battle(white, black);
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChessGUI frame = new ChessGUI(battle);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
		
	}

}
