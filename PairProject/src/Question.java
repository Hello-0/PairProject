import javax.swing.*;
public abstract class Question extends JPanel {
	MainWindow window;
	boolean correct, pass;
	public Question(MainWindow window) {
		this.window = window;
		pass = false;
	}
	public boolean correct() {
		return correct;
	}
	public boolean pass() {
		return pass;
	}
}