package rudy_prj_src;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HangmanMainPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel HangmanOutcomePanel, HangmanWordPanel, HangmanMissesPanel, HangmanActionsPanel;
	private JPanel HangmanFigurePanel = new JPanel();
	private JLabel outcomeLabel, letterInputLabel, wordLabel, missesLabel, missesResultsLabel;
	private JTextField letterInput;
	private JButton guessLetterBtn, newGameBtn;
	private HangmanGame hangman = new HangmanGame();
	private HangmanPanel hangmanPanel = new HangmanPanel();
	
	
	public HangmanMainPanel() {		
		HangmanOutcomePanel = new JPanel();
		outcomeLabel = new JLabel("");
		
		
		HangmanWordPanel = new JPanel();
		HangmanMissesPanel = new JPanel();
		
		wordLabel = new JLabel(hangman.getBlankWord());
		missesLabel = new JLabel("Misses: ");
		missesResultsLabel = new JLabel(" ");
		
		HangmanActionsPanel = new JPanel();
		letterInputLabel = new JLabel("Enter a letter:");
		letterInput = new JTextField(1);		
		guessLetterBtn = new JButton("Guess");
		guessLetterBtn.addActionListener(new GuessButtonListener());
		newGameBtn = new JButton("New Game");
		newGameBtn.addActionListener(new NewGameButtonListener());
		
		HangmanOutcomePanel.add(outcomeLabel);
		
		HangmanFigurePanel.setLayout(new BorderLayout());
		HangmanFigurePanel.add(hangmanPanel);
		
		HangmanWordPanel.add(wordLabel);
		
		HangmanMissesPanel.add(missesLabel);
		HangmanMissesPanel.add(missesResultsLabel);
		
		HangmanActionsPanel.add(letterInputLabel);
		HangmanActionsPanel.add(letterInput);
		HangmanActionsPanel.add(guessLetterBtn);
		
		this.add(HangmanOutcomePanel);
		this.add(HangmanFigurePanel);
		this.add(HangmanWordPanel);
		this.add(HangmanMissesPanel);
		this.add(HangmanActionsPanel);
		
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setPreferredSize(new Dimension(600, 337));
	}
	
	private class GuessButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if ( !letterInput.getText().equals("") ) {
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
				
				if (hangman.isGameOver()) {
					HangmanActionsPanel.removeAll();
					HangmanActionsPanel.updateUI();
					HangmanActionsPanel.add(newGameBtn);
					
					if (hangman.isGameWon()) {
						outcomeLabel.setText("You won!");
					} else if (hangman.isGameLost()) {
						outcomeLabel.setText("You lost! The correct word was: " + hangman.getRandomWord());
					}
				}
			}
		}
	}
	
	private class NewGameButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			hangman.reset();
			wordLabel.setText(hangman.getBlankWord());
			outcomeLabel.setText("");
			missesResultsLabel.setText("");
			hangmanPanel.setMistakeNum(0);
			HangmanActionsPanel.removeAll();
			HangmanActionsPanel.updateUI();
			HangmanActionsPanel.add(letterInputLabel);
			HangmanActionsPanel.add(letterInput);
			HangmanActionsPanel.add(guessLetterBtn);
		}
	}
}
