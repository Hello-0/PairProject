import java.util.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
public class Menu extends JPanel implements ActionListener {
	MainWindow window;
	public Menu(MainWindow window) {
		this.window = window;
		JLabel title, namePrompt;
		JTextField nameField;
		JButton start, about;
		JPanel buttonPanel;
		GridBagConstraints gbc;
		
		setBackground(Color.WHITE);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setPreferredSize(new Dimension(window.getWidth(), window.getHeight()));
		
		title = new JLabel("Impossible Quiz");
		title.setFont(new Font("Arial", Font.BOLD, 120));
		title.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(title);
		add(Box.createRigidArea(new Dimension(window.getWidth(), window.getHeight() / 5)));
		
		namePrompt = new JLabel("What is your name?");
		namePrompt.setFont(new Font("Arial", Font.PLAIN, 20));
		namePrompt.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(namePrompt);
		add(Box.createRigidArea(new Dimension(window.getWidth(), window.getHeight() / 15)));
		
		nameField = new JTextField(24);
		nameField.setFont(new Font("Arial", Font.PLAIN, 16));
		nameField.setMaximumSize(new Dimension(window.getWidth() / 2, 24));
		nameField.setHorizontalAlignment(SwingConstants.CENTER);
		nameField.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(nameField);
		add(Box.createRigidArea(new Dimension(window.getWidth(), window.getHeight() / 5)));
		
		gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.WHITE);
		buttonPanel.setLayout(new GridBagLayout());
		
		start = new JButton("Start!");
		start.setFont(new Font("Arial", Font.PLAIN, 16));
		//start.setPreferredSize(new Dimension(200, 40));
		start.setAlignmentX(Component.CENTER_ALIGNMENT);
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
		buttonPanel.add(start, gbc);
		
		gbc.gridy = 1;
		about = new JButton("About?");
		buttonPanel.add(about, gbc);
		
		add(buttonPanel);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Start"))
			window.startQuiz();
	}
}