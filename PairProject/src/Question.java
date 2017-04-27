import java.awt.*;
import javax.swing.*;
public abstract class Question extends JPanel {
	MainWindow window;
	Quiz quiz;
	int questionNum;
	public Question(MainWindow window, Quiz quiz, int questionNum) {
		this.window = window;
		this.quiz = quiz;
		this.questionNum = questionNum;
		
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(window.getWidth(), window.getHeight()));
	}
	public void loseLife() {
		quiz.getPlayer().loseLife();
	}
	public abstract void createPanel();
	public boolean lose() {
		return quiz.getPlayer().getLives() <= 0;
	}
	public String getQuestion() {
		return "";
	}
	public int getQuestionNum() {
		return questionNum;
	}
}