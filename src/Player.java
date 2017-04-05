public class Player {
	String name;
	int lives;
	public Player(String name) {
		this.name = name;
		
	}
	public void loseLife() {
		lives -= 1;
	}
	public int getLives() {
		return lives;
	}
}