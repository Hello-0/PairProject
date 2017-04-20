import java.awt.*;
import javax.swing.*;
public abstract class Question extends JPanel {
	MainWindow window;
	Quiz quiz;
	boolean correct, pass;
	public Question(MainWindow window, Quiz quiz) {
		this.window = window;
		this.quiz = quiz;
		pass = false;
		
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(window.getWidth(), window.getHeight()));
	}
	public abstract void createPanel();
	public boolean correct() {
		return correct;
	}
	public boolean pass() {
		return pass;
	}
}