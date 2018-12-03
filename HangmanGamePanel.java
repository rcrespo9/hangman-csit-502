package rudy_prj_src;

import java.awt.*;
//import java.awt.event.*;
import javax.swing.*;

public class HangmanGamePanel extends JPanel {
	private JLabel letterInputLabel, guessesLabel, missesLabel, guessesResultsLabel, missesResultsLabel;
	private JTextField letterInput;
	private JButton guessLetterBtn;
	private JSeparator separator;
	
	public HangmanGamePanel() {		
		letterInputLabel = new JLabel("Enter a letter:");
		guessesLabel = new JLabel("Guesses: ");
		guessesResultsLabel = new JLabel(" ");
		missesResultsLabel = new JLabel(" ");
		missesLabel = new JLabel("Misses: ");
		
		
		letterInput = new JTextField(1);
		
		guessLetterBtn = new JButton("Guess");
		
		
		add(guessesLabel);
		add(guessesResultsLabel);
		
		add(missesLabel);
		add(missesResultsLabel);
		
		add(letterInputLabel);
		add(letterInput);
		add(guessLetterBtn);
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		setBackground(Color.white);
		setPreferredSize(new Dimension(600, 337));
	}

}
