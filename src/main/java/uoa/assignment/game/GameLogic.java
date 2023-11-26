package uoa.assignment.game;

import java.util.Scanner;

import uoa.assignment.character.GameCharacter;
import uoa.assignment.character.Player;
import uoa.assignment.character.Monster;

public class GameLogic {

	public static void moveCharacter(String input, Map gameMap, GameCharacter character) {
		if (!(input.equals("up") || input.equals("down") || input.equals("left") || input.equals("right"))) {
			System.out.println("Use only keywords up, down, left, right");
			return;
		} else {
			switch (input) {
				case "up":
					moveUp(character, gameMap);
					break;
				case "down":
					moveDown(character, gameMap);
					break;
				case "left":
					moveLeft(character, gameMap);
					break;
				case "right":
					moveRight(character, gameMap);
					break;
			}
		}
	}

	private static void moveRight(GameCharacter character, Map gameMap) {
		if (character.column == gameMap.layout[0].length - 1) {
			System.out.println("You can't go right. You lose a move.");
		} else {
			if (invalidPlayer(character)) {
				character.column++;
				if (checkMonster(character, gameMap)) {
					hurtMonster(character, gameMap);
					character.column--;
				} else {
					character.column--;
					initialisepossition(character, gameMap);
					character.column++;
					gameMap.layout[character.row][character.column] = "*";
				}
			} else {
				if (checkMonsterHealth(character, gameMap)){
					gameMap.layout[character.row][character.column] = "x";
				}
				else{
				character.column++;
				if (checkMonster(character, gameMap)) {
					System.out.println("Monster already there so can't move");
				}

				else if (checkPlayer(character, gameMap)) {
					hurtPlayer(character, gameMap);
					character.column--;
				}

				else {
					character.column--;
					initialisepossition(character, gameMap);
					character.column++;
					gameMap.layout[character.row][character.column] = "%";
				}
			}
		}
		}
	}

	private static void moveLeft(GameCharacter character, Map gameMap) {
		if (character.column == 0) {
			System.out.println("You can't go left. You lose a move.");
		} else {
			if (invalidPlayer(character)) {
				character.column--;
				if (checkMonster(character, gameMap)) {
					hurtMonster(character, gameMap);
					character.column++;
				} else {
					character.column++;
					initialisepossition(character, gameMap);
					character.column--;
					gameMap.layout[character.row][character.column] = "*";
				}
			} else {
				if (checkMonsterHealth(character, gameMap)){
					gameMap.layout[character.row][character.column] = "x";
				}
				else{
				character.column--;
				if (checkMonster(character, gameMap)) {
					System.out.println("Monster already there so can't move");
				} 

				else if (checkPlayer(character, gameMap)) {
					hurtPlayer(character, gameMap);
					character.column++;
				} 
				
				else {
					character.column++;
					initialisepossition(character, gameMap);
					character.column--;
					gameMap.layout[character.row][character.column] = "%";
				}
			}
		}
		}
	}

	private static void moveUp(GameCharacter character, Map gameMap) {
		if (character.row == 0) {
			System.out.println("You can't go up. You lose a move.");
		} else {
			if (invalidPlayer(character)) {
				character.row--;
				if (checkMonster(character, gameMap)) {
					hurtMonster(character, gameMap);
					character.row++;
				} else {
					character.row++;
					initialisepossition(character, gameMap);
					character.row--;
					gameMap.layout[character.row][character.column] = "*";
				}
			} else {
				if (checkMonsterHealth(character, gameMap)){
					gameMap.layout[character.row][character.column] = "x";
				}
				else{
				character.row--;
				if (checkMonster(character, gameMap)) {
					System.out.println("Monster already there so can't move");
				} 
				
				else if (checkPlayer(character, gameMap)) {
					hurtPlayer(character, gameMap);
					character.row++;
				}

				else {
					character.row++;
					initialisepossition(character, gameMap);
					character.row--;
					gameMap.layout[character.row][character.column] = "%";
				}
			}
		}
		}
	}

	private static void moveDown(GameCharacter character, Map gameMap) {
		if (character.row == gameMap.layout.length - 1) {
			System.out.println("You can't go down. You lose a move.");
		} else {
			if (invalidPlayer(character)) {
				character.row++;
				if (checkMonster(character, gameMap)) {
					hurtMonster(character, gameMap);
					character.row--;
				} else {
					character.row--;
					initialisepossition(character, gameMap);
					character.row++;
					gameMap.layout[character.row][character.column] = "*";
				}
			} else {
				if (checkMonsterHealth(character, gameMap)){
					gameMap.layout[character.row][character.column] = "x";
				}
				else{
				character.row++;
				if (checkMonster(character, gameMap)) {
					System.out.println("Monster already there so can't move");
				} 
				
				else if (checkPlayer(character, gameMap)) {
					hurtPlayer(character, gameMap);
					character.row--;
				}

				else {
					character.row--;
					initialisepossition(character, gameMap);
					character.row++;
					gameMap.layout[character.row][character.column] = "%";
				}
			}
		}
		}
	}

	private static boolean invalidPlayer(GameCharacter character) {
		if (character instanceof Player) {
			return true;
		} else {
			return false;
		}
	}

	private static void initialisepossition(GameCharacter character, Map gameMap) {
		gameMap.layout[character.row][character.column] = ".";
	}

	private static boolean checkMonster(GameCharacter character, Map gameMap) {
		if (gameMap.layout[character.row][character.column].equals("%") || gameMap.layout[character.row][character.column].equals("x")) {
			return true;
		} else {
			return false;
		}
	}

	private static void hurtMonster(GameCharacter character, Map gameMap) {
		for (int i = 1; i < gameMap.characters.length; i++) {
			if (gameMap.characters[i].row == character.row && gameMap.characters[i].column == character.column) {
				GameCharacter hurt_monster = gameMap.characters[i];
				if (checkMonsterHealth(hurt_monster, gameMap)){
					System.out.println("Character already dead");
					gameMap.layout[hurt_monster.row][hurt_monster.column] = "x";
				}
				else{
				character.hurtCharacter(hurt_monster);
			}
		}
		}
	}

	private static void hurtPlayer(GameCharacter character, Map gameMap) {
			GameCharacter hurt_player = gameMap.characters[0];
			character.hurtCharacter(hurt_player);

	}

	private static boolean checkPlayer(GameCharacter character, Map gameMap) {
		if (gameMap.layout[character.row][character.column].equals("*")) {
			return true;
		} else {
			return false;
		}
	}


	private static boolean checkMonsterHealth(GameCharacter character, Map gameMap){
		if (character.getHealth()==0){
			return true;
		}
		else{
			return false;
		}
	}


}
