import java.awt.*;
import javax.swing.*;
public class MainWindow {
	final int DEFAULT_WIDTH = 850, DEFAULT_HEIGHT = 600;
	int width, height;
	JFrame frame;
	Menu menu;
	Player player;
	Quiz quiz;
	MainWindow() {
		width = DEFAULT_WIDTH;
		height = DEFAULT_HEIGHT;
		
		frame = new JFrame("Impossible Quiz");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		menu = new Menu(this);
		frame.setContentPane(menu);
		
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
	public void startQuiz(String name) {
		player = new Player(name);
		quiz = new Quiz(this, player);
		quiz.start();
	}
	public void showAbout() {
		String about = "Zhi Wei Wang ..." +
				"\n\nKenton Wong ...";
		JOptionPane.showMessageDialog(frame, about);
	}
	public void setContentPane(JPanel panel) {
		frame.setContentPane(panel);
		frame.pack();
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	public static void main(String[] args) {
		new MainWindow();
	}
}