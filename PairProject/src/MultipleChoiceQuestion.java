import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
public class MultipleChoiceQuestion extends Question {
	String question, a, b, c, d;
	JLabel questionL, aL, bL, cL, dL;
		// L for label!
	public MultipleChoiceQuestion(MainWindow window, Quiz quiz) {
		super(window, quiz);
	}
	public MultipleChoiceQuestion(MainWindow window, Quiz quiz, String question) {
		this(window, quiz);
		setQuestion(question);
	}
	public MultipleChoiceQuestion(MainWindow window, Quiz quiz, String question, String a, String b, String c, String d) {
		this(window, quiz, question);
		setChoices(a, b, c, d);
	}
	public MultipleChoiceQuestion(MainWindow window, Quiz quiz, String question, String a, String b, String c, String d, String answer) {
		this(window, quiz, question, a, b, c, d);
		setAnswer(answer);
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public void setChoices(String a, String b, String c, String d) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}
	public void setAnswer(String answer) {
		switch (answer) {
			case "a":	addMouseListeners(aL);	break;
			case "b":	addMouseListeners(bL);	break;
			case "c":	addMouseListeners(cL);	break;
			case "d":	addMouseListeners(dL);	break;
		}
	}
	private void addMouseListeners(JLabel label) {
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
	}
}
