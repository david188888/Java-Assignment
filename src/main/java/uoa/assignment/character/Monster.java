package uoa.assignment.character;

import java.util.Random;

public class Monster extends GameCharacter {

	public  Monster(String name) {
		super(name);
	}


	public void hurtCharacter(GameCharacter character) {
		
	}

	
	public boolean successfulDefense() {
		
		  return true;
	}


	
	public String decideMove () {
		
		return "move";
	}

}
