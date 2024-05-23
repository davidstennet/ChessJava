import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.Scanner;

import javax.swing.*;

public class MainMenuGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String name = null;

	/**
	 * Create the frame.
	 */
	public MainMenuGUI(Battle battle) {
		try {
			readFromFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		setName();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 250, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));

		JLabel welcomeText = new JLabel("Welcome to Java Chess " + name, SwingConstants.CENTER);
		contentPane.add(welcomeText);

		// JButton to start the Chess Game
		JButton startGameButton = new JButton("Start Chess Game");
		contentPane.add(startGameButton);
		startGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		});

		JButton changeName = new JButton("Change Name");
		contentPane.add(changeName);
		changeName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				name = null;
				setName();
				welcomeText.setText("Welcome to Java Chess " + name);
			}
		});
	}

	// Prompts the user to enter their name if it is not already set
	public void setName() {
		if (name == null) {
			name = JOptionPane.showInputDialog(null, "Enter your name");
			try {
				writeToFile(name);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// Reads from Name.txt file and sets name to the value in the file
	public void readFromFile() throws IOException {
		FileReader myReader = new FileReader("Name.txt");
		Scanner scanner = new Scanner(myReader);
		if (scanner.hasNextLine()) {
			name = scanner.nextLine();
		}
		scanner.close();
	}

	// Writes the name to the Name.txt file when it is changed
	public void writeToFile(String name) throws IOException {
		FileWriter myWriter = new FileWriter("Name.txt");
		myWriter.write(name);
		myWriter.close();
	}

}
