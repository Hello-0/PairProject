import java.util.*;
import java.awt.*;

import javax.swing.*;
public class Quiz {
	MainWindow window;
	Player player;
	int questionNum;
	JLabel lose,win;
	JButton back, tryagain;
	ImageIcon loseScreen,winScreen;
	//ArrayList<MultipleChoiceQuestion> mcQuestions;
	ArrayList<Question> questions;//specQuestions, ;
	public Quiz(MainWindow window, Player player) {
		this.window = window;
		this.player = player;
		questions = new ArrayList<Question>();
		//mcQuestions = new ArrayList<MultipleChoiceQuestion>();
		//specQuestions = new ArrayList<Question>();
		addQuestions();
	}
	private void addQuestions() {
		MultipleChoiceQuestion mc1 = new MultipleChoiceQuestion(window, this, 1, "How many seconds in a year?", "31536000", "12", "60", "1", "b");
		MultipleChoiceQuestion mc2 = new MultipleChoiceQuestion(window, this, 2, "I did, did I?", "No, I didn't", "Of course I did!", "He did, eh?", "Wait, what?", "c");
		SpecialQuestion1 sq1 = new SpecialQuestion1(window, this, 3);
		MultipleChoiceQuestion mc3 = new MultipleChoiceQuestion(window, this, 4, "How many letters in your name?",
				"8", Integer.toString(player.getName().replaceAll(" ", "").length()), "I forget my name", "Is this a trick question?", "a");
		MultipleChoiceQuestion mc4 = new MultipleChoiceQuestion(window, this, 5, "See, oh double-you?", "What?", "Ouch", "Moo", "We are twins", "c");
		MultipleChoiceQuestion mc5 = new MultipleChoiceQuestion(window, this, 6, "How many people in this class?", "11", "Do computers count?", "ZHI PUT IN HOW MANY IN YOURS", "It's just me", "d");
		MultipleChoiceQuestion mc6 = new MultipleChoiceQuestion(window, this, 7, "Ring ring ring", "Hello?", "Banana Phone", "STRANGER DANGER", "I don't even have a phone", "b");
		/**
		mcQuestions.add(mc1);
		mcQuestions.add(mc2);
		mcQuestions.add(mc3);
		mcQuestions.add(mc4);
		mcQuestions.add(mc5);
		mcQuestions.add(mc6);
		questions.add(sq1);
		*/
		questions = new ArrayList<Question>();
		questions.add(mc1);
		questions.add(mc2);
	//	questions.add(sq1);
		questions.add(mc3);
		questions.add(mc4);
		questions.add(mc5);
		questions.add(mc6);
		/*
		for (int i = 0; i < mcQuestions.size() + specQuestions.size(); i++)
			if (mcQuestions.size() > i && mcQuestions.get(i).getQuestionNum() == i + 1)
				questions.add(mcQuestions.get(i));
			else if (specQuestions.size() > i && specQuestions.get(i).getQuestionNum() == i + 1)
				questions.add(specQuestions.get(i));
		
		for (int i = 0; mcQuestions.size() + specQuestions.size() > 0; i++)
			if (mcQuestions.size() > 0 && mcQuestions.get)
		*/
		/**
			//this is for if we just don't use questionNum since it's bein a lil shit
		boolean moreMC = true;
		int qBreak = mcQuestions.size() / (specQuestions.size() + 1);
		if (specQuestions.size() > mcQuestions.size()) {
			moreMC = false;
			qBreak = specQuestions.size() / (mcQuestions.size() + 1);
		}
		for (int i = 0; mcQuestions.size() + specQuestions.size() > 0; i++)
			if (moreMC)
				if (i == 0)
					questions.add(mcQuestions.remove(0));
				else if (i % qBreak == 0)
					questions.add(mcQuestions.remove(0));
				else
					questions.add(specQuestions.remove(0));
			else
				if (i == 0)
					questions.add(specQuestions.remove(0));
				else if (i % qBreak == 0)
					questions.add(specQuestions.remove(0));
				else
					questions.add(mcQuestions.remove(0));
		*/
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
	private void setWinPanel() 
	{
		JPanel winPanel = new JPanel(null);
		winPanel.setPreferredSize(new Dimension(window.getWidth(), window.getHeight()));
		
		back = new JButton("Back to Menu");
		back.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
		
		win = new JLabel();
		winScreen = new ImageIcon("res/winscreen.png");
		Image img = winScreen.getImage().getScaledInstance(window.getWidth(),window.getHeight(), java.awt.Image.SCALE_SMOOTH);
		win.setIcon(new ImageIcon(img));

		winPanel.add(win);
		win.setBounds(0,0,window.getWidth(),window.getHeight());

		win.add(back);
		back.setBounds(50, 500, 250, 50);
		
		window.setContentPane(winPanel);
	}
	public void setLosePanel() 
	{
		JPanel losePanel = new JPanel(null);
		losePanel.setPreferredSize(new Dimension(window.getWidth(), window.getHeight()));
		
		tryagain = new JButton("Try Again!");
		tryagain.setFont(new Font("Comic Sans MS", Font.PLAIN, 45));
		tryagain.setForeground(Color.RED);
		tryagain.setBorderPainted(false); 
        tryagain.setContentAreaFilled(false); 
        tryagain.setFocusPainted(false); 
        tryagain.setOpaque(false);
        
        back = new JButton("Give Up...");
		back.setFont(new Font("Comic Sans MS", Font.PLAIN, 45));
		back.setForeground(Color.CYAN);
		back.setBorderPainted(false); 
        back.setContentAreaFilled(false); 
        back.setFocusPainted(false); 
        back.setOpaque(false);
		
		lose = new JLabel();
		loseScreen = new ImageIcon("res/losescreen.png");
		Image img = loseScreen.getImage().getScaledInstance(window.getWidth(),window.getHeight(), java.awt.Image.SCALE_SMOOTH);
		lose.setIcon(new ImageIcon(img));
		
		losePanel.add(lose);
		lose.setBounds(0,0,window.getWidth(),window.getHeight());
		
		lose.add(tryagain);
		tryagain.setBounds(25, 515, 265, 60);
		lose.add(back);
		back.setBounds(535, 510, 265, 60);
		
		window.setContentPane(losePanel);
	}
	public Player getPlayer() {
		return player;
	}
	public ArrayList<Question> getQuestionList() {
		return questions;
	}
}