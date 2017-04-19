import java.util.*;
public class Quiz {
	MainWindow window;
	Player player;
	int questionNum;
	ArrayList<Question> questions;
	public Quiz(MainWindow window, Player player) {
		this.window = window;
		this.player = player;
		
		questions = new ArrayList<Question>();
		addQuestions(questions);
	}
	private void addQuestions(ArrayList<Question> questions) {
		questions.add(new MultipleChoiceQuestion(window, this));
		questions.add(new SpecialQuestion1(window, this));
			//add more when we make
	}
	public void start() {
		questionNum = 0;
		window.setContentPane(questions.get(questionNum));
	}
	private void nextQuestion() {
		try {
			questionNum++;
			window.setContentPane(questions.get(questionNum));
		} catch (Exception e) {
				//if runs out of questions then win
			setWinPanel();
		}
	}
	private void setWinPanel() {
		
	}
	private void setLosePanel() {
		
	}
	public Player getPlayer() {
		return player;
	}
	public ArrayList<Question> getQuestionList() {
		return questions;
	}
}