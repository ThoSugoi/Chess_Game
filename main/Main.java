package main;

import java.awt.Color;
import javax.swing.JFrame;

public class Main {
	public void startGame() {

		public static void main(String[] args) {
			JFrame frame = new JFrame();
			frame.setSize(654, 678);
			frame.setBackground(new Color(100, 100, 100));
			//frame.getContentPane().setBackground(new Color(200, 200, 200));
			//frame.setLayout(new GridBagLayout());
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setResizable(true);

			Board board = new Board();
			frame.add(board);
			frame.setVisible(true);
		}
		
	}
	public static void main(String[] args) {
		Main chessGame = new Main();
		chessGame.startGame();
}}

