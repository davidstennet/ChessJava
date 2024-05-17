import java.awt.Color;
import java.awt.EventQueue;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.*;
import java.util.HashMap;

public class ChessGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private final int ROWS = 8;
	private final int COLUMNS = 8;
	private JPanel contentPane;
	private boolean firstClick = true;
	private Piece clickedPiece;
	private HashMap<String, JLabelBox> mapOfBoxes = new HashMap<String, JLabelBox>();

	/**
	 * Create the frame.
	 */
	public ChessGUI(Battle battle) {
		setTitle("Chess");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 800);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new GridLayout(ROWS, COLUMNS, 0, 0));
		
		// Initializes the board window
		initializeBoard(battle.getWhite(), battle.getBlack());
		
		
	}
	
	// Creates the Chess Board with alternating colors
	private void initializeBoard(Player white, Player black) {


		for (int row = ROWS; row > 0; row--) {
			for (int column = 1; column <= COLUMNS; column++) {

				// Creates square
				JLabelBox square = new JLabelBox(row, column);
				

				// This string is the string combination of the rows and columns so you can interact with Player hashmaps
				String xy = Integer.toString(column) + Integer.toString(row);

				// These if statements check if a square overlaps with a piece that needs to get placed, creats ImageIcon if that is the case
				if (white.getPieceLocation().containsKey(xy)) {
					ImageIcon icon = new ImageIcon(white.getPieceLocation().get(xy).getImgURL());
					square.setIcon(icon);
				}
				else if (black.getPieceLocation().containsKey(xy)) {
					ImageIcon icon = new ImageIcon(black.getPieceLocation().get(xy).getImgURL());
					square.setIcon(icon);
				}
						
				square.setBackground(getSquareColor(row, column));
				square.setOpaque(true);
				contentPane.add(square);
				mapOfBoxes.put(xy, square);

				// Mouse listener for the JLabel
				square.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						// Everything is in ColumnRow format 
						String colRow = Integer.toString(square.getColumn()) + Integer.toString(square.getRow());

						
						// if (white.getPieceLocation().containsKey(colRow)) {
						// 	System.out.println(white.getPieceLocation().get(colRow).getName());
						// }
						// else if (black.getPieceLocation().containsKey(colRow)) {
						// 	System.out.println(black.getPieceLocation().get(colRow).getName());
						// }


						if (firstClick && white.getPieceLocation().containsKey(colRow)) {
							clickedPiece = white.getPieceLocation().get(colRow);
							firstClick = false;
						}
						else if (firstClick && black.getPieceLocation().containsKey(colRow)) {
							clickedPiece = black.getPieceLocation().get(colRow);
							firstClick = false;
						}
						else if (clickedPiece.isWhite()) { // Moving piece after being clicked
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


							ImageIcon icon = new ImageIcon(clickedPiece.getImgURL());
							square.setIcon(icon);
							firstClick = true;
						}
						else {
							// Sets image of original piece to nothin
							String originalLocation = Integer.toString(clickedPiece.getColumn()) + Integer.toString(clickedPiece.getRow());
							JLabelBox originalBox = mapOfBoxes.get(originalLocation);
							originalBox.setIcon(null);
							black.getPieceLocation().remove(originalLocation);

							// Sets new locations
							clickedPiece.setColumn(square.getColumn());
							clickedPiece.setRow(square.getRow());
							String newLocation = Integer.toString(clickedPiece.getColumn()) + Integer.toString(clickedPiece.getRow());
							black.getPieceLocation().put(newLocation, clickedPiece);


							ImageIcon icon = new ImageIcon(clickedPiece.getImgURL());
							square.setIcon(icon);
							firstClick = true;

						}


					}
				});
				
			}
		}
	}
	
	// Gets the color square depending on 
	private Color getSquareColor(int row, int col) {
        return (row + col+1) % 2 == 0 ? Color.WHITE : Color.GRAY;
    }
	

}
