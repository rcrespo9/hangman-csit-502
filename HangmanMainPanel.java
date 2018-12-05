package rudy_prj_src;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HangmanMainPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel HangmanOutcomePanel, HangmanScoreboardPanel, HangmanActionsPanel;
	private JLabel outcomeLabel, letterInputLabel, wordLabel, missesLabel, missesResultsLabel;
	private JTextField letterInput;
	private JButton guessLetterBtn;
	private HangmanGame hangman = new HangmanGame();
	private int mistakeNum = 0;
	private HangmanFigurePanel figurePanel = new HangmanFigurePanel();
	
	public HangmanMainPanel() {
		figurePanel.setMistakeNum(mistakeNum);
		
		HangmanOutcomePanel = new JPanel();
		outcomeLabel = new JLabel();
		
		HangmanScoreboardPanel = new JPanel();
		wordLabel = new JLabel(hangman.getBlankWord());
		missesLabel = new JLabel("Misses: ");
		missesResultsLabel = new JLabel(" ");
		
		HangmanActionsPanel = new JPanel();
		letterInputLabel = new JLabel("Enter a letter:");
		letterInput = new JTextField(1);
		guessLetterBtn = new JButton("Guess");
		guessLetterBtn.addActionListener(new ButtonListener());
		
		HangmanScoreboardPanel.add(wordLabel);
		HangmanScoreboardPanel.add(missesLabel);
		HangmanScoreboardPanel.add(missesResultsLabel);
		
		HangmanActionsPanel.add(letterInputLabel);
		HangmanActionsPanel.add(letterInput);
		HangmanActionsPanel.add(guessLetterBtn);
		
		this.add(HangmanOutcomePanel);
		this.add(figurePanel);
		this.add(HangmanScoreboardPanel);
		this.add(HangmanActionsPanel);
		
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBackground(Color.white);
		this.setPreferredSize(new Dimension(600, 337));
	}
	
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {			
			if( hangman.isCorrectLetter(letterInput.getText()) ) {
				wordLabel.setText(hangman.getGameWord());
			} else {
				missesResultsLabel.setText(hangman.getWrongLetters());
			}
			
			letterInput.setText("");
		}
	}

}
