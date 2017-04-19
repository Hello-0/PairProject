public class Player {
	String name;
	int lives, passes;
	public Player(String name) {
		this.name = name;
		lives = 3;
		passes = 0;
	}
	public void loseLife() {
		lives -= 1;
	}
	public void addPass() {
		passes += 1;
	}
	public void usePass() {
		passes -= 1;
	}
	public String getName() {
		return name;
	}
	public int getLives() {
		return lives;
	}
	public int getPasses() {
		return passes;
	}
}