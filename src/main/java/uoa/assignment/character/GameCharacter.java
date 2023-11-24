package uoa.assignment.character;

public abstract class GameCharacter {
    
	private String name ="";
	
	private int health; 
	
	public int row;
	public int column;
	
	
	public GameCharacter (String name) {
		//complete
	}
	
	public abstract void hurtCharacter (GameCharacter character);
	
	public abstract boolean successfulDefense ();
	
	
	public String sayName() {
	return ""; 
	}

	public int getHealth() {
		return -1;
	}

	public void setHealth(int health) {
		//complete
	}
}

