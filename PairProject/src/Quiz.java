import java.util.*;

public class Quiz {
	
	MainWindow window;
	Player player;
	int questionNum;
	ArrayList<Question> questions;
	
	public Quiz(MainWindow window, String name) {
		this.window = window;
		player = new Player(name);
		
		questions = new ArrayList<Question>();
		addQuestions(questions);
		
		window.startQuiz(this);
	}
	
	private void addQuestions(ArrayList<Question> questions) {
		questions.add(new Question1(window));
		//add more when we make
	}
	
	private void nextQuestion() {
		//switch to next question
	}
	
	public ArrayList<Question> getQuestionList() {
		return questions;
	}
}
