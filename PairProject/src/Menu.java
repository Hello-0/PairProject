import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.Timer;

public class Menu extends JPanel implements ActionListener {
	MainWindow window;
	JTextField nameField;
	private JLabel title;
	int Color1 = 0xFFFFFF;
	
	public Menu(MainWindow window) {
		this.window = window;
		JLabel namePrompt;
		JButton start, about;
		JPanel buttonPanel;
		GridBagConstraints gbc;
		
		
		setBackground(Color.WHITE);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setPreferredSize(new Dimension(window.getWidth(), window.getHeight()));
		
		title = new JLabel("Impossible Quiz");
		title.setAlignmentX(Component.CENTER_ALIGNMENT);
		title.setForeground(new Color(Color1));
		add(title);
		add(Box.createRigidArea(new Dimension(window.getWidth(), window.getHeight() / 4)));
		
		Timer tmr = new Timer(50, new ActionListener(){
    		
			public void actionPerformed(ActionEvent e){

				Color1 = gradient(Color1);
				title.setForeground(new Color(Color1));
			}
		});
		
		tmr.start();
	
		namePrompt = new JLabel("What is your name?");
		namePrompt.setFont(new Font("Arial", Font.PLAIN, 20));
		namePrompt.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(namePrompt);
		add(Box.createRigidArea(new Dimension(window.getWidth(), window.getHeight() / 15)));
		
		nameField = new JTextField(24);
		nameField.setFont(new Font("Arial", Font.PLAIN, 16));
		nameField.setMaximumSize(new Dimension(window.getWidth() / 2, 24));
		nameField.setHorizontalAlignment(SwingConstants.CENTER);
		add(nameField);
		
		gbc = new GridBagConstraints();
		gbc.fill = 1;
		gbc.insets = new Insets(2, 2, 2, 2);
		buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.WHITE);
		buttonPanel.setLayout(new GridBagLayout());
		
		start = new JButton("Start!");
		start.setFont(new Font("Arial", Font.PLAIN, 16));
		start.addActionListener(this);
		start.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				
			}
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
		about.setFont(new Font("Arial", Font.PLAIN, 16));
		about.addActionListener(this);
		about.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				
			}
			public void mouseEntered(MouseEvent e) {
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			public void mouseExited(MouseEvent e) {
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
		});
		buttonPanel.add(about, gbc);
		
		add(buttonPanel);
		
		try {
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("res/PressStart2P.ttf")));
			Font pix = Font.createFont(Font.TRUETYPE_FONT, new File("res/PressStart2P.ttf"));
			
			title.setFont(pix.deriveFont(50f));
			
			namePrompt.setFont(pix.deriveFont(35f));
			
			nameField.setFont(pix.deriveFont(40f));
			nameField.setMaximumSize(new Dimension(window.getWidth() / 2, 24));
			nameField.setHorizontalAlignment(SwingConstants.CENTER);;
			
			start.setFont(pix.deriveFont(50f));
			about.setFont(pix.deriveFont(50f));
		} catch (FontFormatException|IOException e) {}
	}
	
	public int gradient(int color){
		int r = color & 0xFF0000;
		int g = color & 0x00FF00;
		int b = color & 0x0000FF;
		if(r == 0xFF0000 && g != 0x00FF00 && b== 0x000000)
		{
			color += 0x000F00;
		}else if(r != 0x000000 && g == 0x00FF00 && b== 0x000000){
			color -= 0x0F0000;
			
		}else if(r == 0x000000 && b != 0x0000FF){
			color -= 0x000F00;
			color += 0x00000F;
			
		}else if(r != 0xFF0000){
			color += 0x0F0000;
			
		}else{
			
			color -= 0x00000F;
		}
		return color;
	}
	
	/**
	public Menu(MainWindow window) {
		JLabel title, namePrompt;
		JButton start, about;
		GridBagConstraints gbc;
	
		this.window = window;
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(window.getWidth(), window.getHeight()));
		setLayout(new GridBagLayout());
		
		nameField = new JTextField(24);
		title = new JLabel("Impossible Quiz");
		namePrompt = new JLabel("What is your name?");
		start = new JButton("Start!");
		about = new JButton("About?");
		
		start.addActionListener(this);
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
		
		about.addActionListener(this);
		about.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				
			}
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
			
			namePrompt.setFont(pix.deriveFont(35f));
			
			nameField.setFont(pix.deriveFont(40f));
			nameField.setMaximumSize(new Dimension(window.getWidth() / 2, 24));
			nameField.setHorizontalAlignment(SwingConstants.CENTER);;
			
			start.setFont(pix.deriveFont(50f));
			about.setFont(pix.deriveFont(50f));
		} catch (FontFormatException|IOException e) {}
		
		gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.gridwidth = GridBagConstraints.CENTER;
		
		gbc.weighty =0.01;
	
		gbc.gridx =1;
		gbc.gridy =0;
		add(title,gbc);
		
		gbc.gridx =1;
		gbc.gridy =1;
		add(namePrompt,gbc);
		
		gbc.gridx =1;
		gbc.gridy =2;
		add(nameField,gbc);
		
		gbc.gridx =0;
		gbc.gridy =3;
		add(start, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 3;
		add(about,gbc);
	}
	*/
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
			case "Start!":	window.startQuiz(nameField.getText());	break;
			case "About?":	window.showAbout();						break;
		}
	}
}