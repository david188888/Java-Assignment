package uoa.assignment.game;

import java.util.Scanner;

public class RunGame {

	private static boolean gameOver = false;

	public static void main(String[] args) {
		int height = args.length > 0 ? Integer.parseInt(args[0]) : 0;
		int width = args.length > 1 ? Integer.parseInt(args[1]) : 0;

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

