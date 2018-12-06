package rudy_prj_src;

import javax.swing.JFrame;

public class Hangman {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Rudy Crespo — Hangman");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		HangmanMainPanel panel = new HangmanMainPanel();
		
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
	}

}
