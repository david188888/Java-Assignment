package uoa.assignment.character;

import java.util.Random;

public class Player extends GameCharacter{

	public Player(String name) {
		super(name);
	}

	
	public
	void hurtCharacter(GameCharacter character) {
		if (character.successfulDefense()){
			return;
		}
		else {
			character.setHealth(character.getHealth() - 50);
		}
	}

	
	public
	boolean successfulDefense() {
		Random rand = new Random();
		int randomNum = rand.nextInt(4);
		if (randomNum == 0) {
			return true;
		}
		else {
			return false;
		}
	}

}
