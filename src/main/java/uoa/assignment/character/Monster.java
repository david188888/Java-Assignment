package uoa.assignment.character;

import java.util.Random;

public class Monster extends GameCharacter {

	public  Monster(String name) {
		super(name);
	}


	public void hurtCharacter(GameCharacter character) {
		if (character.successfulDefense()){
			return;
		}
		else {
			character.setHealth(character.getHealth() - 20);
		}
	}

	
	public boolean successfulDefense() {
		Random rand = new Random();
		int randomNum = rand.nextInt(2);
		if (randomNum == 0) {
			return true;
		}
		else {
			return false;
		}
	}


	
	public String decideMove () {
		Random rand = new Random();
		int randomNum = rand.nextInt(4);
		switch (randomNum) {
			case 0:
				return "up";
			case 1:
				return "down";
			case 2:
				return "left";
			case 3:
				return "right";
			default:
				return "up";
		}
	}

}
