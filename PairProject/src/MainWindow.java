import javax.swing.*;

import java.awt.*;
public class MainWindow {

	double width, height;
	JFrame frame;
	Dimension scrn = Toolkit.getDefaultToolkit().getScreenSize();
	Menu menu;
	Quiz quiz;
	final double DEFAULT_MONITOR_WIDTH = scrn.width*(0.9), 
			  DEFAULT_MONITOR_HEIGHT = scrn.height*(0.9);
	
	MainWindow() {
		width = DEFAULT_MONITOR_WIDTH;
		height = DEFAULT_MONITOR_HEIGHT;
		
		frame = new JFrame("Impossible Quiz");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		menu = new Menu(this);
		frame.setContentPane(menu);
		
		frame.pack();
		frame.setVisible(true);
	}
	public void startQuiz() {
		//quiz = new Quiz();
	}
	public int getWidth() {
		return (int)width;
	}
	public int getHeight() {
		return (int)height;
	}
	public static void main(String[] args) {
		new MainWindow();
	}
}