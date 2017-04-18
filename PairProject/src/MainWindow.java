import javax.swing.*;
import java.awt.*;
public class MainWindow {
	final int DEFAULT_MONITOR_WIDTH = 1500, DEFAULT_MONITOR_HEIGHT = 800;
	int width, height;
	JFrame frame;
	Menu menu;
	Quiz quiz;
	Player player;
	MainWindow() {
		width = DEFAULT_MONITOR_WIDTH;
		height = DEFAULT_MONITOR_HEIGHT;
		
		frame = new JFrame("Impossible Quiz");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		menu = new Menu(this);
		frame.setContentPane(menu);
		
		frame.pack();
		frame.setVisible(true);
	}
	public void startQuiz(String name) {
		player = new Player(name);
		quiz = new Quiz(this, player);
		quiz.start();
	}
	public void showAbout() {
		String about = "we can fuck around with this later";
		JOptionPane.showMessageDialog(frame, about);
	}
	public void setContentPane(JPanel panel) {
		frame.setContentPane(panel);
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