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
	private JPanel HangmanFigurePanel = new JPanel();
	private JLabel outcomeLabel, letterInputLabel, wordLabel, missesLabel, missesResultsLabel;
	private JTextField letterInput;
	private JButton guessLetterBtn;
	private HangmanGame hangman = new HangmanGame();
	private HangmanPanel hangmanPanel = new HangmanPanel();
	
	
	public HangmanMainPanel() {		
		HangmanOutcomePanel = new JPanel();
		outcomeLabel = new JLabel("");
		
		
		HangmanScoreboardPanel = new JPanel();
		wordLabel = new JLabel(hangman.getBlankWord());
		missesLabel = new JLabel("Misses: ");
		missesResultsLabel = new JLabel(" ");
		
		HangmanActionsPanel = new JPanel();
		letterInputLabel = new JLabel("Enter a letter:");
		letterInput = new JTextField(1);
		guessLetterBtn = new JButton("Guess");
		guessLetterBtn.addActionListener(new ButtonListener());
		
		HangmanOutcomePanel.add(outcomeLabel);
		
		HangmanFigurePanel.setLayout(new BorderLayout());
		HangmanFigurePanel.add(hangmanPanel);
		
		HangmanScoreboardPanel.add(wordLabel);
		HangmanScoreboardPanel.add(missesLabel);
		HangmanScoreboardPanel.add(missesResultsLabel);
		
		HangmanActionsPanel.add(letterInputLabel);
		HangmanActionsPanel.add(letterInput);
		HangmanActionsPanel.add(guessLetterBtn);
		
		this.add(HangmanOutcomePanel);
		this.add(HangmanFigurePanel);
		this.add(HangmanScoreboardPanel);
		this.add(HangmanActionsPanel);
		
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setPreferredSize(new Dimension(600, 337));
	}
	
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {			
			if( hangman.isCorrectLetter(letterInput.getText()) ) {
				wordLabel.setText(hangman.getGameWord());
			} else {
				HangmanFigurePanel.removeAll();
				HangmanFigurePanel.updateUI();
				HangmanFigurePanel.add(hangmanPanel);
				hangmanPanel.setMistakeNum(hangman.getWrongLettersCount());
				missesResultsLabel.setText(hangman.getWrongLetters());
			}
			
			letterInput.setText("");
		}
	}

}
