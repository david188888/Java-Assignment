package uoa.assignment.character;

public abstract class GameCharacter {
    
	private String name ="";
	
	private int health; 
	
	public int row;
	public int column;
	
	
	public GameCharacter (String name) {
		this.name = name;
		this.health = 100;
	}
	
	public abstract void hurtCharacter (GameCharacter character);
	
	public abstract boolean successfulDefense ();
	
	
	public String sayName() {
	return this.name; 
	}

	public int getHealth() {
		return this.health;
	}

	public void setHealth(int health) {
		this.health = health;
	}
}

