public class Battle {

    private Player white;
    private Player black;
    private boolean isWhiteTurn = true;

    public Battle(Player white, Player black) {
        this.white = white;
        this.black = black;
    }


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
}
