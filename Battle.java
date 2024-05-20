import javax.swing.*;
import java.util.HashMap;

public class Battle {

    private Player white;
    private Player black;
    private boolean isWhiteTurn = true;
    private boolean firstClick = true;
    private Piece clickedPiece;


    public Battle(Player white, Player black) {
        this.white = white;
        this.black = black;
    }

    public void clickedOnPiece(String colRow, JLabelBox square, HashMap<String, JLabelBox> mapOfBoxes) {
        
        // First two if statements checks whether this is the first time it has been clicked or not and adds what the piece that has been clicked to 
        // Piece clickedPiece
        if (firstClick && white.getPieceLocation().containsKey(colRow) && this.isWhiteTurn) {
            clickedPiece = white.getPieceLocation().get(colRow);
            firstClick = false;
        }
        else if (firstClick && black.getPieceLocation().containsKey(colRow) && !this.isWhiteTurn) {
            clickedPiece = black.getPieceLocation().get(colRow);
            firstClick = false;
        }
        else if (clickedPiece != null) {
            if (clickedPiece.getName() == "Pawn") {
                clickedOnPawn(colRow, square, mapOfBoxes);
            }
            else if (clickedPiece.getName() == "Rook") {
                clickedOnRook(colRow, square, mapOfBoxes);
            }
            else if (clickedPiece.getName() == "Knight") {
                clickedOnKnight(colRow, square, mapOfBoxes);
            }
            else if (clickedPiece.getName() == "Bishop") {
                clickedOnBishop(colRow, square, mapOfBoxes);
            }
            else if (clickedPiece.getName() == "Queen") {
                clickedOnQueen(colRow, square, mapOfBoxes);
            }
            else {
                clickedOnKing(colRow, square, mapOfBoxes);
            }
        }
        


        // else if (clickedPiece.isWhite() && clickedPiece.canMove()) { // Moving piece after being clicked
        //     // Sets image of original piece to nothin
        //     String originalLocation = Integer.toString(clickedPiece.getColumn()) + Integer.toString(clickedPiece.getRow());
        //     JLabelBox originalBox = mapOfBoxes.get(originalLocation);
        //     originalBox.setIcon(null);
        //     white.getPieceLocation().remove(originalLocation);

        //     // Sets new locations
        //     clickedPiece.setColumn(square.getColumn());
        //     clickedPiece.setRow(square.getRow());
        //     String newLocation = Integer.toString(clickedPiece.getColumn()) + Integer.toString(clickedPiece.getRow());
        //     white.getPieceLocation().put(newLocation, clickedPiece);


        //     ImageIcon icon = new ImageIcon(clickedPiece.getImgURL());
        //     square.setIcon(icon);
        //     firstClick = true;
        //     clickedPiece = null;
        // }
        // else {
        //     // Sets image of original piece to nothin
        //     String originalLocation = Integer.toString(clickedPiece.getColumn()) + Integer.toString(clickedPiece.getRow());
        //     JLabelBox originalBox = mapOfBoxes.get(originalLocation);
        //     originalBox.setIcon(null);        clickedPiece.getName();

        //     black.getPieceLocation().remove(originalLocation);

        //     // Sets new locations
        //     clickedPiece.setColumn(square.getColumn());
        //     clickedPiece.setRow(square.getRow());
        //     String newLocation = Integer.toString(clickedPiece.getColumn()) + Integer.toString(clickedPiece.getRow());
        //     black.getPieceLocation().put(newLocation, clickedPiece);


        //     ImageIcon icon = new ImageIcon(clickedPiece.getImgURL());
        //     square.setIcon(icon);
        //     firstClick = true;
        //     clickedPiece = null;
        // }
    }

    private void clickedOnPawn(String colRow, JLabelBox square, HashMap<String, JLabelBox> mapOfBoxes) {
        Pawn clickedPawn = (Pawn)clickedPiece; // Downcasts the pawn
        // boolean for whether the spot they are moving to is valid
        boolean canMove = clickedPawn.canMove(square.getColumn(), square.getRow(), this.white.getPieceLocation(), this.black.getPieceLocation()); 

        if (clickedPawn.isWhite() && canMove && this.isWhiteTurn) { // Moving piece after being clicked
            // Sets image of original piece to nothin
            String originalLocation = Integer.toString(clickedPiece.getColumn()) + Integer.toString(clickedPiece.getRow());
            JLabelBox originalBox = mapOfBoxes.get(originalLocation);
            originalBox.setIcon(null);
            white.getPieceLocation().remove(originalLocation);

            // Sets new locations
            clickedPiece.setColumn(square.getColumn());
            clickedPiece.setRow(square.getRow());
            String newLocation = Integer.toString(clickedPiece.getColumn()) + Integer.toString(clickedPiece.getRow());
            white.getPieceLocation().put(newLocation, clickedPiece);
            if (this.black.getPieceLocation().containsKey(newLocation)) { // Gets rid of piece in opponent hashmap if this is an attacking move
                this.black.getPieceLocation().remove(newLocation);
            }


            ImageIcon icon = new ImageIcon(clickedPiece.getImgURL());
            square.setIcon(icon);

            firstClick = true;
            clickedPiece = null;
            this.isWhiteTurn = false;
        }
        else if (!clickedPawn.isWhite() && canMove && !this.isWhiteTurn) {
            // Sets image of original piece to nothin
            String originalLocation = Integer.toString(clickedPiece.getColumn()) + Integer.toString(clickedPiece.getRow());
            JLabelBox originalBox = mapOfBoxes.get(originalLocation);
            originalBox.setIcon(null);        clickedPiece.getName();

            black.getPieceLocation().remove(originalLocation);

            // Sets new locations
            clickedPiece.setColumn(square.getColumn());
            clickedPiece.setRow(square.getRow());
            String newLocation = Integer.toString(clickedPiece.getColumn()) + Integer.toString(clickedPiece.getRow());
            black.getPieceLocation().put(newLocation, clickedPiece);
            if (this.white.getPieceLocation().containsKey(newLocation)) { // Gets rid of piece in opponent hashmap if this is an attacking move
                this.white.getPieceLocation().remove(newLocation);
            }


            ImageIcon icon = new ImageIcon(clickedPiece.getImgURL());
            square.setIcon(icon);
            

            firstClick = true;
            clickedPiece = null;
            this.isWhiteTurn = true;
        }
        else {
            clickedPiece = null;
            firstClick = true;
        }
    }

    private void clickedOnRook(String colRow, JLabelBox square, HashMap<String, JLabelBox> mapOfBoxes) {
        Rook clickedRook = (Rook)clickedPiece; // Downcasts the pawn
        // boolean for whether the spot they are moving to is valid
        boolean canMove = clickedRook.canMove(square.getColumn(), square.getRow(), this.white.getPieceLocation(), this.black.getPieceLocation()); 

        if (clickedRook.isWhite() && canMove && this.isWhiteTurn) { // Moving piece after being clicked
            // Sets image of original piece to nothin
            String originalLocation = Integer.toString(clickedPiece.getColumn()) + Integer.toString(clickedPiece.getRow());
            JLabelBox originalBox = mapOfBoxes.get(originalLocation);
            originalBox.setIcon(null);
            white.getPieceLocation().remove(originalLocation);

            // Sets new locations
            clickedPiece.setColumn(square.getColumn());
            clickedPiece.setRow(square.getRow());
            String newLocation = Integer.toString(clickedPiece.getColumn()) + Integer.toString(clickedPiece.getRow());
            white.getPieceLocation().put(newLocation, clickedPiece);
            if (this.black.getPieceLocation().containsKey(newLocation)) { // Gets rid of piece in opponent hashmap if this is an attacking move
                this.black.getPieceLocation().remove(newLocation);
            }


            ImageIcon icon = new ImageIcon(clickedPiece.getImgURL());
            square.setIcon(icon);

            firstClick = true;
            clickedPiece = null;
            this.isWhiteTurn = false;
        }
        else if (!clickedRook.isWhite() && canMove && !this.isWhiteTurn) {
            // Sets image of original piece to nothin
            String originalLocation = Integer.toString(clickedPiece.getColumn()) + Integer.toString(clickedPiece.getRow());
            JLabelBox originalBox = mapOfBoxes.get(originalLocation);
            originalBox.setIcon(null);        clickedPiece.getName();

            black.getPieceLocation().remove(originalLocation);

            // Sets new locations
            clickedPiece.setColumn(square.getColumn());
            clickedPiece.setRow(square.getRow());
            String newLocation = Integer.toString(clickedPiece.getColumn()) + Integer.toString(clickedPiece.getRow());
            black.getPieceLocation().put(newLocation, clickedPiece);
            if (this.white.getPieceLocation().containsKey(newLocation)) { // Gets rid of piece in opponent hashmap if this is an attacking move
                this.white.getPieceLocation().remove(newLocation);
            }


            ImageIcon icon = new ImageIcon(clickedPiece.getImgURL());
            square.setIcon(icon);


            firstClick = true;
            clickedPiece = null;
            this.isWhiteTurn = true;
        }
        else {
            clickedPiece = null;
            firstClick = true;
        }
    }
    
    private void clickedOnKnight(String colRow, JLabelBox square, HashMap<String, JLabelBox> mapOfBoxes) {

    }

    private void clickedOnBishop(String colRow, JLabelBox square, HashMap<String, JLabelBox> mapOfBoxes) {

    }
    
    private void clickedOnQueen(String colRow, JLabelBox square, HashMap<String, JLabelBox> mapOfBoxes) {

    }
    
    private void clickedOnKing(String colRow, JLabelBox square, HashMap<String, JLabelBox> mapOfBoxes) {

    }

    // Downcasts Piece according to its name so that it can get is methods
    // private void downCastPiece() {
    //     if (clickedPiece.getName() == "Pawn") {
    //         Pawn clickedPawn = (Pawn)clickedPiece;
    //     }
    //     else if (clickedPiece.getName() == "Rook") {
    //         Rook clickedRook = (Rook)clickedPiece;
    //     }
    //     else if (clickedPiece.getName() == "Knight") {
    //         Knight clickedKnight = (Knight)clickedPiece;
    //     }
    //     else if (clickedPiece.getName() == "Bishop") {
    //         Bishop clickedBishop = (Bishop)clickedPiece;
    //     }
    //     else if (clickedPiece.getName() == "Queen") {
    //         Queen clickedQueen = (Queen)clickedPiece;
    //     }
    //     else {
    //         King clickedKing = (King)clickedPiece;
    //     }

    // }


    // Getters and setters
    // Getter for white player
    public Player getWhite() {
        return white;
    }

    // Setter for white player
    public void setWhite(Player white) {
        this.white = white;
    }

    // Getter for black player
    public Player getBlack() {
        return black;
    }

    // Setter for black player
    public void setBlack(Player black) {
        this.black = black;
    }

    // Getter for isWhiteTurn
    public boolean isWhiteTurn() {
        return isWhiteTurn;
    }

    // Setter for isWhiteTurn
    public void setWhiteTurn(boolean isWhiteTurn) {
        this.isWhiteTurn = isWhiteTurn;
    }

    // Getter for firstClick
    public boolean isFirstClick() {
        return firstClick;
    }

    // Setter for firstClick
    public void setFirstClick(boolean firstClick) {
        this.firstClick = firstClick;
    }

    // Getter for clickedPiece
    public Piece getClickedPiece() {
        return clickedPiece;
    }

    // Setter for clickedPiece
    public void setClickedPiece(Piece clickedPiece) {
        this.clickedPiece = clickedPiece;
    }
}
