import javax.swing.*;
public abstract class Question extends JPanel {
	MainWindow window;
	Quiz quiz;
	boolean correct, pass;
	public Question(MainWindow window, Quiz quiz) {
		this.window = window;
		this.quiz = quiz;
		pass = false;
	}
	public boolean correct() {
		return correct;
	}
	public boolean pass() {
		return pass;
	}
}