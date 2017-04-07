import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.swing.*;

public class Menu extends JPanel implements ActionListener {
	MainWindow window;
	JLabel title, namePrompt;
	JTextField nameField;
	JButton start, about;
	GridBagConstraints gbc;
	
	public Menu(MainWindow window) {
		
		this.window = window;
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(window.getWidth(), window.getHeight()));
		setLayout(new GridBagLayout());
		
		nameField = new JTextField(24);
		title = new JLabel("Impossible Quiz");
		namePrompt = new JLabel("What is your name?");
		start = new JButton("Start!");
		about = new JButton("About?");
		
		start.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			public void mouseExited(MouseEvent e) {
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
		});
		
		try {

			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("res/PressStart2P.ttf")));
			Font pix = Font.createFont(Font.TRUETYPE_FONT, new File("res/PressStart2P.ttf"));
			
			title.setFont(pix.deriveFont(60f));
			
			namePrompt.setFont(pix.deriveFont(40f));
			
			nameField.setFont(pix.deriveFont(40f));
			nameField.setMaximumSize(new Dimension(window.getWidth() / 2, 24));
			nameField.setHorizontalAlignment(SwingConstants.CENTER);;
			
			start.setFont(pix.deriveFont(40f));
			
		} catch (FontFormatException|IOException e) {
				// TODO Auto-generated catch block;
		}
		
		gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.weighty =0.01;
		
		gbc.gridy =0;
		add(title,gbc);
		
		gbc.gridy =1;
		add(namePrompt,gbc);
		
		gbc.gridy =2;
		add(nameField,gbc);

		gbc.gridy =3;
		add(start, gbc);

		gbc.gridy =4;
		add(about,gbc);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Start"))
			window.startQuiz();
	}
}