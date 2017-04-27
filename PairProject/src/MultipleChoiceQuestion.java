import java.util.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
public class MultipleChoiceQuestion extends Question {
	String question, a, b, c, d, answer;
	JLabel questionL,lives;
	JButton aB, bB, cB, dB;
	boolean questionInputted = false, choicesInputted = false, answerInputted = false;
	public MultipleChoiceQuestion(MainWindow window, Quiz quiz, int questionNum) {
		super(window, quiz, questionNum);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}
	public MultipleChoiceQuestion(MainWindow window, Quiz quiz, int questionNum, String question) {
		this(window, quiz, questionNum);
		questionInputted = true;
		setQuestion(question);
	}
	public MultipleChoiceQuestion(MainWindow window, Quiz quiz, int questionNum, String question, String a, String b, String c, String d) {
		this(window, quiz, questionNum, question);
		choicesInputted = true;
		setChoices(a, b, c, d);
	}
	public MultipleChoiceQuestion(MainWindow window, Quiz quiz, int questionNum, String question, String a, String b, String c, String d, String answer) {
		this(window, quiz, questionNum, question, a, b, c, d);
		answerInputted = true;
		setAnswer(answer);
	}
	public void setQuestion(String question) {
		this.question = question;
		questionL = new JLabel(question);
		questionL.setFont(new Font("Comic Sans MS", Font.PLAIN, 48));
	}
	public void setChoices(String a, String b, String c, String d) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		aB = new JButton(a);
		bB = new JButton(b);
		cB = new JButton(c);
		dB = new JButton(d);
	}
	public void setAnswer(String answer) {
		if (answerInputted)
			switch (answer) {
				case "a":	addMouseListeners(aB);	break;
				case "b":	addMouseListeners(bB);	break;
				case "c":	addMouseListeners(cB);	break;
				case "d":	addMouseListeners(dB);	break;
			}
		else
			addMouseListeners(aB);
	}
	private void addMouseListeners(JButton button) {
		ArrayList<JButton> answerBs = new ArrayList<JButton>();
		answerBs.add(aB);
		answerBs.add(bB);
		answerBs.add(cB);
		answerBs.add(dB);
		answerBs.remove(button);
		
		button.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				quiz.nextQuestion();
			}
			public void mouseEntered(MouseEvent e) {
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			public void mouseExited(MouseEvent e) {
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
		});
		for (int i = 0; i < answerBs.size(); i++)
			answerBs.get(i).addMouseListener(new MouseListener() {
				public void mouseClicked(MouseEvent e) {
					loseLife();
					if (lose())
						quiz.setLosePanel();
				}
				public void mouseEntered(MouseEvent e) {
					setCursor(new Cursor(Cursor.HAND_CURSOR));
				}
				public void mouseExited(MouseEvent e) {
					setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}
				public void mousePressed(MouseEvent e) {}
				public void mouseReleased(MouseEvent e) {}
			});
	}
	public void createPanel() {
		JLabel questionNum;
		JLabel x = new JLabel("res/x.png");
		ArrayList<JButton> answerBs = new ArrayList<JButton>();
		JPanel choicesPanel;
		
		if (!answerInputted) {
			if (!choicesInputted) {
				if (!questionInputted) {
					question = "Question Not Inputted";
					setQuestion(question);
				}
				a = "A";
				b = "B";
				c = "C";
				d = "D";
				setChoices(a, b, c, d);
			}
			answer = "a";
			setAnswer(answer);
		}
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
			//fix questionNum alignment FUCK THIS SHIT
		JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
		p.setPreferredSize(new Dimension(window.getWidth(), 8));
		questionNum = new JLabel(Integer.toString(this.questionNum) + ".");
		questionNum.setFont(new Font("Comic Sans MS", Font.PLAIN, 48));
		questionNum.setForeground(Color.BLUE);
		//questionNum.setAlignmentX(Component.LEFT_ALIGNMENT);
		p.setAlignmentX(Component.LEFT_ALIGNMENT);
		//add(questionNum);
		p.add(questionNum);
		add(p);
		
		add(Box.createRigidArea(new Dimension(window.getWidth(), window.getHeight() / 12)));
		questionL.setFont(new Font("Comic Sans MS", Font.PLAIN, 48));
		questionL.setForeground(Color.BLUE);
		questionL.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(questionL);
		
		add(Box.createRigidArea(new Dimension(window.getWidth(), window.getHeight() / 6)));
		answerBs.add(aB);
		answerBs.add(bB);
		answerBs.add(cB);
		answerBs.add(dB);
		for (JButton button : answerBs) {
			button.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
			button.setBackground(new Color(247, 150, 221));
			button.setPreferredSize(new Dimension(window.getWidth() * 2 / 5, window.getHeight() / 8));
		}
		
		choicesPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 10));
		choicesPanel.setBackground(Color.WHITE);
		for (JButton button : answerBs)
			choicesPanel.add(button);
		add(choicesPanel);
		
		lives = new JLabel("LIVES:");
		lives.setFont(new Font("Comic Sans MS", Font.PLAIN, 48));
		lives.setForeground(new Color(25, 220, 50));
		lives.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(lives);
		add(Box.createRigidArea(new Dimension(window.getWidth(), window.getHeight() / 16)));
	}
	public String getQuestion() {
		return question;
	}
}