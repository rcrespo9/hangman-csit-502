package rudy_prj_src;

import java.util.ArrayList;
import java.util.Random;

import java.io.*;

public class HangmanGame {
	private final int MAX_ATTEMPTS = 6;
	private static String gameWord = "";
	private static String randomWord;
	private static ArrayList<String> wordsArrayList = new ArrayList<String>();
	private static ArrayList<String> correctLetters = new ArrayList<String>();
	private ArrayList<String> wrongLetters = new ArrayList<String>();
	
	private static void addWords() throws IOException {
	  File file = new File("./src/rudy_prj_src/words.txt"); 
	  
	  BufferedReader br = null;
	  
		try {
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
	  
	  String word;
	  
	  while ((word = br.readLine()) != null) {
		  wordsArrayList.add(word);  
	  }
	}
	
	private static void setRandomWord() {
		int randomNum = new Random().nextInt(wordsArrayList.size());
		
		randomWord = wordsArrayList.get(randomNum);
	}
	
	private void buildGameWord(String letter) {
		StringBuilder sb = new StringBuilder();
		String[] gameWordLetters = randomWord.split("");
		
		correctLetters.add(letter);
		
		for (String gameLetter: gameWordLetters) {
			for (int j = 0; j <= correctLetters.size() - 1; j++) {
				boolean areLettersEqual = correctLetters.get(j).equalsIgnoreCase(gameLetter);
				boolean letterNotGuessed = correctLetters.stream().anyMatch(gameLetter::equalsIgnoreCase) == false;
				
				if (areLettersEqual) {
					sb.append(gameLetter + " ");
					break;
				} else if(letterNotGuessed) {
					sb.append("_ ");
					break;
				}
			}
		}
		
		gameWord = sb.toString();
	}
	
	public HangmanGame() {
		try {
			addWords();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setRandomWord();
	}
	
	public String getGameWord() {
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
	
	public boolean isGameWon() {
		String gameWordNoSpaces = gameWord.replaceAll("\\s+","");
		
		if (randomWord.equals(gameWordNoSpaces)) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isGameLost() {
		if (getWrongLettersCount() == MAX_ATTEMPTS) {
			return true;
		} else {
			return false;
		}
	}
}
