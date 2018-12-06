package rudy_prj_src;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HangmanMainPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel HangmanOutcomePanel, HangmanWordPanel, HangmanMissesPanel, HangmanActionsPanel, HangmanWarningsPanel;
	private JPanel HangmanFigurePanel = new JPanel();
	private JLabel outcomeLabel, letterInputLabel, wordLabel, missesLabel, missesResultsLabel, warningsLabel;
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
		
		HangmanWarningsPanel = new JPanel();
		warningsLabel = new JLabel("");
		HangmanWarningsPanel.add(warningsLabel);
		
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
		this.add(HangmanWarningsPanel);
		
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setPreferredSize(new Dimension(600, 337));
	}
	
	private class GuessButtonListener implements ActionListener {		
		public void actionPerformed(ActionEvent event) {
			boolean inputNotEmpty = !letterInput.getText().equals("");
			boolean inputOnlyOneLetter = letterInput.getText().length() == 1;
			
			if ( inputNotEmpty && inputOnlyOneLetter) {
				warningsLabel.setText("");
				
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
			} else if (letterInput.getText().equals("")) {
				warningsLabel.setText("Please enter at least one letter");
			} else if (letterInput.getText().length() > 1) {
				warningsLabel.setText("Please enter only one letter");
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
