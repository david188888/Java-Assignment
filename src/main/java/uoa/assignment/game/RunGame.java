package uoa.assignment.game;

import java.util.Scanner;

public class RunGame {

	private static boolean gameOver = false;

	public static void main(String[] arg) {
		int height = arg.length >= 2 ? Integer.parseInt(arg[0]) : 0;
		int width = arg.length >= 2 ? Integer.parseInt(arg[1]) : 0;
		// int height = 3;
		// int width = 3;
		int count = 0;
		Game game = new Game(height, width);
		System.out.println(" ");
		while (!gameOver) {
			if (!gameOver) {
				count+=1;
				System.out.println("Round " + count);
				Scanner scanner = new Scanner(System.in);
				// System.out.println("Enter your move: ");
				String input = scanner.nextLine();
				gameOver = game.nextRound(input);
				// System.out.println(" ");
			}
		}
		}
	}

