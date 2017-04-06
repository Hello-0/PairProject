import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Menu extends JPanel implements ActionListener {
	
	MainWindow window;
	JTextField nameField;
	
	public Menu(MainWindow window) {
		
		this.window = window;
		JLabel title, namePrompt;
		//JTextField nameField;
		JButton start;
		
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(window.getWidth(), window.getHeight()));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		title = new JLabel("Impossible Quiz");
		title.setFont(new Font("Arial", Font.BOLD, window.getWidth() / 10));
		title.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(title);
		add(Box.createRigidArea(new Dimension(window.getWidth(), window.getHeight() / 5)));
		
		namePrompt = new JLabel("What is the reference to which you are called by?");
		namePrompt.setFont(new Font("Arial", Font.PLAIN, 24));
		namePrompt.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(namePrompt);
		
		//fuck this pos textfield bitch ass nigga go fix it
		nameField = new JTextField(20);
		add(nameField);
		
		start = new JButton("Begin Quiz!");
		start.addActionListener(this);
		start.setActionCommand("start");
		add(start);
		
		window.setContentArea(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("start"))
			new Quiz(window, nameField.getText());
	}
}
