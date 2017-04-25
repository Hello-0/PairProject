import java.util.*;
public class Quiz {
	MainWindow window;
	Player player;
	int questionNum;
	ArrayList<MultipleChoiceQuestion> mcQuestions;
	ArrayList<Question> specQuestions, questions;
	public Quiz(MainWindow window, Player player) {
		this.window = window;
		this.player = player;
		
		questions = new ArrayList<Question>();
		mcQuestions = new ArrayList<MultipleChoiceQuestion>();
		specQuestions = new ArrayList<Question>();
		addQuestions();
	}
	private void addQuestions() {
		MultipleChoiceQuestion mc1 = new MultipleChoiceQuestion(window, this, 1, "test?", "a", "b", "c", "d", "b");
		mc1.createPanel();
		MultipleChoiceQuestion mc2 = new MultipleChoiceQuestion(window, this, 2, "test2!!");
		mc2.createPanel();
		
		mcQuestions.add(mc1);
		mcQuestions.add(mc2);
		//questions.add(new SpecialQuestion1(window, this));
			//add more when we make
		
		
		//put all questions in an order in questions arraylist
		for (int i = 0; mcQuestions.size() > 0 && specQuestions.size() > 0; i++)
			if (i % 3 != 2)
				questions.add(mcQuestions.remove(0));
			else
				questions.add(specQuestions.remove(0));
		if (mcQuestions.size() > 0)
			while (mcQuestions.size() > 0)
				questions.add(mcQuestions.remove(0));
		else
			while (specQuestions.size() > 0)
				questions.add(specQuestions.remove(0));
	}
	public void start() {
		questionNum = 0;
		//System.out.println(mcQuestions.get(questionNum).getQuestion());
		System.out.println("question#"+questionNum);
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