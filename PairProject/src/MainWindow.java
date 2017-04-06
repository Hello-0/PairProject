import javax.swing.*;
import java.awt.*;
public class MainWindow {
	final int DEFAULT_MONITOR_WIDTH = 1500, DEFAULT_MONITOR_HEIGHT = 800;
	int width, height;
	JFrame frame;
	Menu menu;
	Quiz quiz;
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
	public void startQuiz() {
		quiz = new Quiz();
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