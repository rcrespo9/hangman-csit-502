package rudy_prj_src;

import java.util.ArrayList;

public class HangmanGame {
	private final int MAX_ATTEMPTS = 6;
	private String randomWord;
	private ArrayList<Character> guessedLetters, wrongLetters = new ArrayList<Character>();
	
//	private static void setRandomWord() {
//		
//	}
	
	
	public String getRandomWord() {
		return this.randomWord;
	}
	
	public ArrayList<Character> getWrongLetters() {
		return this.wrongLetters;
	}
	
	public int getWrongLettersCount() {
		return this.wrongLetters.size();
	}
	
	public void guessLetter(char letter) {
		this.guessedLetters.add(letter);
		
		if (this.randomWord.indexOf(letter) < 0) {
			this.wrongLetters.add(letter);
		}
	}
}
