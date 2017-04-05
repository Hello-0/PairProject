import java.util.*;
import javax.swing.*;
public class MainWindow {
	JFrame frame;
	Menu menu;
	int width;
	int height;
	MainWindow() {
		width = 1500;
		height = 800;
		
		frame = new JFrame("Impossible Quiz");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		menu = new Menu(this);
		frame.setContentPane(menu);
		
		frame.pack();
		frame.setVisible(true);
	}
	public void startQuiz(Quiz quiz) {
		ArrayList<Question> questions = quiz.getQuestionList();
		this.setContentArea(questions.get(0));
	}
	public void setContentArea(JPanel panel) {
		frame.setContentPane(panel);
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	public static void main(String[] args) {
		new MainWindow();
	}
}