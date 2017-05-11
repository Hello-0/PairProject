import java.awt.*;
import javax.swing.*;
public class MainWindow {
	final int DEFAULT_WIDTH = 825, DEFAULT_HEIGHT = 600;
	int width, height;
	JFrame frame;
	Menu menu;
	Player player;
	Quiz quiz;
	MainWindow() {
		width = DEFAULT_WIDTH;
		height = DEFAULT_HEIGHT;
		
		frame = new JFrame("Impossible Quiz");
		frame.setResizable(false);
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
		String about = "Zhi Wei Wang is the master.\nHe is able to do anything and everything if enough effort and belief in himself is put into the task." +
				"\n\nKenton Wong is the master's assistant.\nAs his assistant, he mainly runs simple errands, such as bringing him\nMcDonald's fries every once in a while or massaging his back when he gets sore from programming.";
		JOptionPane.showMessageDialog(frame, about);
	}
	public void setContentPane(JPanel panel) {
		frame.setContentPane(panel);
		frame.pack();
	}
	public void dispose() {
		frame.dispose();
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