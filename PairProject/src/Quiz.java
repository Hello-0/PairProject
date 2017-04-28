import java.util.*;
import java.awt.*;
import javax.swing.*;

public class Quiz {
	MainWindow window;
	Player player;
	int questionNum;
	JLabel livesLabel = new JLabel("LIVES:");
	JLabel life;
	ArrayList<MultipleChoiceQuestion> mcQuestions;
	ArrayList<Question> specQuestions, questions;
	
	public Quiz(MainWindow window, Player player) {
		this.window = window;
		this.player = player;
		
		livesLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 60));
		livesLabel.setForeground(Color.YELLOW);

		life = new JLabel(Integer.toString(player.getLives()));
		life.setFont(new java.awt.Font("Comic Sans MS", 0, 60));
		life.setForeground(new java.awt.Color(25, 220, 50));
		
		questions = new ArrayList<Question>();
		mcQuestions = new ArrayList<MultipleChoiceQuestion>();
		specQuestions = new ArrayList<Question>();
		addQuestions();
	}
	
	private void addQuestions() {
		MultipleChoiceQuestion mc1 = new MultipleChoiceQuestion(window, this, 1, "How many seconds in a year?", "31536000", "12", "60", "1", "b");
		mc1.createPanel();
		MultipleChoiceQuestion mc2 = new MultipleChoiceQuestion(window, this, 2, "I did, did I?", "No, I didn't", "Of course I did!", "He did, eh?", "Wait, what?", "c");
		mc2.createPanel();
		MultipleChoiceQuestion mc3 = new MultipleChoiceQuestion(window, this, 3, "How many letters in your name?",
				"8", Integer.toString(player.getName().length()), "I forget my name", "Is this a trick question?", "a");
		mc3.createPanel();
		
		mcQuestions.add(mc1);
		mcQuestions.add(mc2);
		mcQuestions.add(mc3);
		//questions.add(new SpecialQuestion1(window, this, 3));
			//add more when we make
		
		//put all questions in an order in questions arraylist
		questions = new ArrayList<Question>();
		for (int i = 0; i < mcQuestions.size() + specQuestions.size(); i++)
			if (mcQuestions.size() > i && mcQuestions.get(i).getQuestionNum() == i + 1)
				questions.add(mcQuestions.get(i));
			else if (specQuestions.size() > i && specQuestions.get(i).getQuestionNum() == i + 1)
				questions.add(specQuestions.get(i));
		System.out.println("addqs:\t"+questions.size());
	}
	public void start() {
		questionNum = 0;
		livesLabel.setAlignmentX(SwingConstants.LEFT);
	//	questions.get(questionNum).setLayout(new FlowLayout());
		questions.get(questionNum).add(livesLabel);
		questions.get(questionNum).add(life);
		
		window.setContentPane(questions.get(questionNum));

	}
	public void nextQuestion() {
		try {
			questionNum++;
			questions.get(questionNum).add(livesLabel);
			questions.get(questionNum).add(life);
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