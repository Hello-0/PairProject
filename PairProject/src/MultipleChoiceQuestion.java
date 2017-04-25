import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class MultipleChoiceQuestion extends Question {
	String question, a, b, c, d, answer;
	JLabel questionL, aL, bL, cL, dL;
		// L for label!
	boolean questionInputted = false, choicesInputted = false, answerInputted = false;
	public MultipleChoiceQuestion(MainWindow window, Quiz quiz, int questionNum) {
		super(window, quiz, questionNum);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		/*
		setQuestion(question);
		setChoices(a, b, c, d);
		setAnswer(answer);
		*/
	}
	public String getQuestion() {
		return question;
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
		System.out.println("settin choices");
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		aL = new JLabel(a);
		bL = new JLabel(b);
		cL = new JLabel(c);
		dL = new JLabel(d);
	}
	public void setAnswer(String answer) {
		System.out.println("settin answers");
		if (answerInputted)
			switch (answer) {
				case "a":	addMouseListeners(aL);	break;
				case "b":	addMouseListeners(bL);	break;
				case "c":	addMouseListeners(cL);	break;
				case "d":	addMouseListeners(dL);	break;
			}
		else
			addMouseListeners(aL);
	}
	private void addMouseListeners(JLabel label) {
		ArrayList<JLabel> answerLs = new ArrayList<JLabel>();
		answerLs.add(aL);
		answerLs.add(bL);
		answerLs.add(cL);
		answerLs.add(dL);
		answerLs.remove(label);
		
		label.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				correct = true;
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
		for (int i = 0; i < answerLs.size(); i++)
			answerLs.get(i).addMouseListener(new MouseListener() {
				public void mouseClicked(MouseEvent e) {
					correct = false;
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
		JLabel questionNum = new JLabel(Integer.toString(this.questionNum) + ".");
		JLabel x = new JLabel("res/x.png");
		JPanel choicesPanel = new JPanel(new GridLayout());
		
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
		
		questionNum.setFont(new Font("Comic Sans MS", Font.PLAIN, 48));
		questionNum.setForeground(Color.BLUE);
		questionNum.setAlignmentX(Component.LEFT_ALIGNMENT);
		add(questionNum);
		
		add(Box.createRigidArea(new Dimension(window.getWidth(), window.getHeight() / 10)));
		questionL.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(questionL);
		
		//choicesPanel:
		//2x2 grid like
		//  	a  b
		//      c  d
		//add choicesPanel to main JPanel after
	}
}
