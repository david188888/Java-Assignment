package uoa.assignment.character;

import java.util.Random;

public class Player extends GameCharacter {

	public Player(String name) {
		super(name);
	}

	public void hurtCharacter(GameCharacter character) {
		if (character.successfulDefense()) {
			return;
		} else {
			character.setHealth(character.getHealth() - 50);
		}
	}

	public boolean successfulDefense() {
		Random rand = new Random();
		int randomNum = rand.nextInt(10); //using nextInt(10) to generate a random number between 0 and 9 inclusive
		if (randomNum < 3) { // 30% chance of successful defense
			return true;
		} else {
			return false;
		}
	}

}
