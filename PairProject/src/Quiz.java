import java.util.*;
import java.awt.*;
import javax.swing.*;
public class Quiz {
	MainWindow window;
	Player player;
	int questionNum;
	JLabel life;
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
		MultipleChoiceQuestion mc1 = new MultipleChoiceQuestion(window, this, 1, "How many seconds in a year?", "31536000", "12", "60", "1", "b");
		MultipleChoiceQuestion mc2 = new MultipleChoiceQuestion(window, this, 2, "I did, did I?", "No, I didn't", "Of course I did!", "He did, eh?", "Wait, what?", "c");
		MultipleChoiceQuestion mc3 = new MultipleChoiceQuestion(window, this, 3, "How many letters in your name?",
				"8", Integer.toString(player.getName().length()), "I forget my name", "Is this a trick question?", "a");
		MultipleChoiceQuestion mc4 = new MultipleChoiceQuestion(window, this, 4, "See, oh double-you?", "What?", "Ouch", "Moo", "We are twins", "c");
		MultipleChoiceQuestion mc5 = new MultipleChoiceQuestion(window, this, 5, "How many people in this class?", "11", "Do computers count?", "HOW MANY IN YOURS", "Depends on the class", "d");
		MultipleChoiceQuestion mc6 = new MultipleChoiceQuestion(window, this, 6, "Ring ring ring", "Hello?", "omg iz that a landline", "STRANGER DANGER", "I don't even have a phone", "b");
		
		mcQuestions.add(mc1);
		mcQuestions.add(mc2);
		mcQuestions.add(mc3);
		mcQuestions.add(mc4);
		mcQuestions.add(mc5);
		mcQuestions.add(mc6);
		//questions.add(new SpecialQuestion1(window, this, 3));
			//add more when we make
		
		questions = new ArrayList<Question>();
		for (int i = 0; i < mcQuestions.size() + specQuestions.size(); i++)
			if (mcQuestions.size() > i && mcQuestions.get(i).getQuestionNum() == i + 1)
				questions.add(mcQuestions.get(i));
			else if (specQuestions.size() > i && specQuestions.get(i).getQuestionNum() == i + 1)
				questions.add(specQuestions.get(i));
	}
	public void start() {
		questionNum = 0;
		questions.get(questionNum).createPanel();
		window.setContentPane(questions.get(questionNum));
	}
	public void nextQuestion() {
		try {
			questionNum++;
			questions.get(questionNum).createPanel();
			window.setContentPane(questions.get(questionNum));
		} catch (Exception e) {
			setWinPanel();
		}
	}
	private void setWinPanel() {
		JPanel winPanel = new JPanel();
		winPanel.setPreferredSize(new Dimension(window.getWidth(), window.getHeight()));
		winPanel.setBackground(Color.BLUE);
		
		window.setContentPane(winPanel);
	}
	public void setLosePanel() {
		JPanel losePanel = new JPanel();
		losePanel.setPreferredSize(new Dimension(window.getWidth(), window.getHeight()));
		losePanel.setBackground(Color.RED);
		window.setContentPane(losePanel);
	}
	public Player getPlayer() {
		return player;
	}
	public ArrayList<Question> getQuestionList() {
		return questions;
	}
}