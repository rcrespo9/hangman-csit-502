package rudy_prj_src;

import java.util.ArrayList;

public class HangmanGame {
	private final int MAX_ATTEMPTS = 6;
	private static String randomWord = "Baseball";
	private static ArrayList<String> correctLetters = new ArrayList<String>();
	private ArrayList<String> wrongLetters = new ArrayList<String>();
	
//	private static void setRandomWord() {
//		
//	}
	
	public String getGameWord() {
		StringBuilder gameWord = new StringBuilder();
		String[] gameWordArr = randomWord.split("");
		
		for (int i = 0; i <= gameWordArr.length; i++) {
			inner: for (int j = 0; j <= correctLetters.size(); j++) {				
				if (gameWordArr[i] == correctLetters.get(j)) {
					gameWord.append(correctLetters.get(j));
				} else {
					gameWord.append(" _ ");
				}
			}
		}
		
		return gameWord.toString();
	}
	
	public String getBlankWord() {
		StringBuilder blankWord = new StringBuilder();
		String[] gameWordArr = randomWord.split("");
		
		for (int i = 0; i <= gameWordArr.length; i++) {
			blankWord.append(" _ ");
		}
		
		return blankWord.toString();
	}
	
	
	public String getWrongLetters() {
		return  String.join(", ", wrongLetters);
	}
	
	public int getWrongLettersCount() {
		return wrongLetters.size();
	}
	
	public boolean isCorrectLetter(String letter) {		
		if (randomWord.indexOf(letter) >= 0) {
			correctLetters.add(letter);
			return true;
		} else {
			wrongLetters.add(letter);
			return false;
		}
	}
}
