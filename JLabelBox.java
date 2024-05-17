import javax.swing.*;

/*
 * I made this class so that I could use the JLabel but also give it variables (int row, int column) so that I could assing specifc values to a JLabel 
 * of where their location is within Chess GUI. It inherits from JLabel.
 */
public class JLabelBox extends JLabel {

    private int row;
    private int column;

    public JLabelBox(int row, int column) {
        super();
        this.row = row;
        this.column = column;
    }

    public JLabelBox(Icon image, int row, int column) {
        super(image);
        this.row = row;
        this.column = column;
    }

    public JLabelBox(Icon image, int horizontalAlignment, int row, int column) {
        super(image, horizontalAlignment);
        this.row = row;
        this.column = column;
    }

    public JLabelBox(String text, int row, int column) {
        super(text);
        this.row = row;
        this.column = column;
    }

    public JLabelBox(String text, Icon icon, int horizontalAlignment, int row, int column) {
        super(text, icon, horizontalAlignment);
        this.row = row;
        this.column = column;
    }

    public JLabelBox(String text, int horizontalAlignment, int row, int column) {
        super(text, horizontalAlignment);
        this.row = row;
        this.column = column;
    }


    // Getter for row
    public int getRow() {
        return row;
    }

    // Setter for row
    public void setRow(int row) {
        this.row = row;
    }

    // Getter for column
    public int getColumn() {
        return column;
    }

    // Setter for column
    public void setColumn(int column) {
        this.column = column;
    }
}
