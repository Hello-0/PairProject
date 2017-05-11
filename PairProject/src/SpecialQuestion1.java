import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class SpecialQuestion1 extends Question {
	boolean start;
	public SpecialQuestion1(MainWindow window, Quiz quiz, int questionNum) {
		super(window, quiz, questionNum);
		start = false;
	}
	public void createPanel() {
		repaint();
	}
	public void update(Graphics g) {
		paint(g);
	}
	public void paint(Graphics g) {
		super.paint(g);
		JLabel lives = new JLabel("LIVES: " + quiz.getPlayer().getLives());
		lives.setFont(new Font("Comic Sans MS", Font.PLAIN, 60));
		if (!start) {
			removeAll();
			setBackground(Color.WHITE);
			g.drawRect(window.getWidth() - 75, window.getHeight() / 2 - 75 / 2, 75, 75);
			g.drawString("Move Here!", window.getWidth() - 67, window.getHeight() / 2 + 6);
			//g.drawString("LIVES: " + quiz.getPlayer().getLives(), 30, window.getHeight() - 30);
			add(lives);
			lives.setBounds(20, window.getHeight() - 80, 500, 60);
			addMouseMotionListener(new MouseMotionListener() {
				public void mouseDragged(MouseEvent e) {}
				public void mouseMoved(MouseEvent e) {
					if (!start && e.getX() > window.getWidth() - 80 && e.getX() < window.getWidth() - 5
							&& e.getY() > window.getHeight() / 2 - 75 / 2 && e.getY() < window.getHeight() / 2 + 75 / 2)
						start = true;
					repaint();
				}
			});
		} else {
			setBackground(Color.BLUE);
			g.setColor(Color.GREEN);
			g.fillRect(window.getWidth() - 75, window.getHeight() / 2 - 75 / 2, 75, 75);
			JButton b = new JButton("Click me!");
			b.setBackground(Color.GREEN);
			b.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					quiz.nextQuestion();
				}
			});
			add(b);
			b.setBounds(0, window.getHeight() / 2 - 75 / 2, 100, 75);
			addMouseMotionListener(new MouseMotionListener() {
				public void mouseDragged(MouseEvent e) {}
				public void mouseMoved(MouseEvent e) {
					if (!(e.getY() > window.getHeight() / 2 - 75 / 2 && e.getY() < window.getHeight() / 2 + 75 / 2
							&& e.getX() > window.getWidth() - 75 || e.getX() < 100) && start) {
						start = false;
						repaint();
						loseLife();
						if (lose())
							quiz.setLosePanel();
					}
				}
			});
		}
	}
}