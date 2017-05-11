import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Quiz {
	MainWindow window;
	Player player;
	int questionNum;
	JLabel lose,win;
	JButton back, tryAgain;
	ImageIcon loseScreen,winScreen;
	ArrayList<Question> questions;
	public Quiz(MainWindow window, Player player) {
		this.window = window;
		this.player = player;
		questions = new ArrayList<Question>();
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
		
		questions = new ArrayList<Question>();
		questions.add(mc1);
		questions.add(sq1);
		questions.add(mc2);
		questions.add(mc3);
		questions.add(mc4);
		questions.add(mc5);
		questions.add(mc6);
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
		} catch (IndexOutOfBoundsException e) {
			setWinPanel();
		}
	}
	private void setWinPanel() {
		JPanel winPanel = new JPanel(null);
		winPanel.setPreferredSize(new Dimension(window.getWidth(), window.getHeight()));
		
		back = new JButton("Back to Menu");
		back.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				window.setContentPane(new Menu(window));
			}
		});
		
		win = new JLabel();
		winScreen = new ImageIcon("res/winscreen.png");
		Image img = winScreen.getImage().getScaledInstance(window.getWidth(), window.getHeight(), Image.SCALE_SMOOTH);
		win.setIcon(new ImageIcon(img));

		winPanel.add(win);
		win.setBounds(0, 0, window.getWidth(), window.getHeight());

		win.add(back);
		back.setBounds(50, 500, 250, 50);
		
		window.setContentPane(winPanel);
	}
	public void setLosePanel() {
		JPanel losePanel = new JPanel(null);
		losePanel.setPreferredSize(new Dimension(window.getWidth(), window.getHeight()));
		
		tryAgain = new JButton("Try Again!");
		tryAgain.setFont(new Font("Comic Sans MS", Font.PLAIN, 45));
		tryAgain.setForeground(Color.RED);
		tryAgain.setBorderPainted(false); 
        tryAgain.setContentAreaFilled(false); 
        tryAgain.setFocusPainted(false); 
        tryAgain.setOpaque(false);
        tryAgain.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {
				losePanel.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			public void mouseExited(MouseEvent e) {
				losePanel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
        });
        tryAgain.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		window.setContentPane(new Menu(window));
        	}
        });
        
        back = new JButton("Give Up...");
		back.setFont(new Font("Comic Sans MS", Font.PLAIN, 45));
		back.setForeground(Color.CYAN);
		back.setBorderPainted(false); 
        back.setContentAreaFilled(false); 
        back.setFocusPainted(false); 
        back.setOpaque(false);
        back.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {
				losePanel.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			public void mouseExited(MouseEvent e) {
				losePanel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
        });
        back.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		window.dispose();
        	}
        });
		
		lose = new JLabel();
		loseScreen = new ImageIcon("res/losescreen.png");
		Image img = loseScreen.getImage().getScaledInstance(window.getWidth(),window.getHeight(), java.awt.Image.SCALE_SMOOTH);
		lose.setIcon(new ImageIcon(img));
		
		losePanel.add(lose);
		lose.setBounds(0, 0, window.getWidth(), window.getHeight());
		
		lose.add(tryAgain);
		tryAgain.setBounds(25, 515, 265, 60);
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