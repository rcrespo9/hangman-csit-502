package rudy_prj_src;

import java.util.ArrayList;

import javax.swing.JFrame;

public class HangmanGame {
	private final int MAX_ATTEMPTS = 6;
	private static String gameWord;
	private static String randomWord = "Baseball";
	private static ArrayList<String> correctLetters = new ArrayList<String>();
	private ArrayList<String> wrongLetters = new ArrayList<String>();
	
//	private static void setRandomWord() {
//		
//	}
	
	private static void buildGameWord(String letter) {
		StringBuilder sb = new StringBuilder();
		String[] gameWordLetters = randomWord.split("");
		
		correctLetters.add(letter);
		
		for (String gameLetter: gameWordLetters) {
			for (int j = 0; j <= correctLetters.size() - 1; j++) {
				boolean letterNotGuessed = correctLetters.stream().anyMatch(gameLetter::equalsIgnoreCase) == false;
				
				if (correctLetters.get(j).equalsIgnoreCase(gameLetter)) {
					sb.append(gameLetter + " ");
				} else if(letterNotGuessed) {
					sb.append("_ ");
					break;
				}
			}
		}
		
		gameWord = sb.toString();
	}
	
	public static String getGameWord() {
		return gameWord;
	}
	
	public String getBlankWord() {
		StringBuilder blankWord = new StringBuilder();
		String[] gameWordArr = randomWord.split("");
		
		for (int i = 0; i <= gameWordArr.length - 1; i++) {
			blankWord.append(" _ ");
		}
		
		return blankWord.toString();
	}
	
	
	public String getWrongLetters() {
		return String.join(", ", wrongLetters);
	}
	
	public int getWrongLettersCount() {
		return wrongLetters.size();
	}
	
	public boolean isCorrectLetter(String letter) {		
		if (randomWord.indexOf(letter) >= 0) {
			buildGameWord(letter);
			return true;
		} else {
			wrongLetters.add(letter);
			return false;
		}
	}
	
	public static void main(String[] args) {
		buildGameWord("b");
		
		System.out.println(getGameWord());
	}

}
