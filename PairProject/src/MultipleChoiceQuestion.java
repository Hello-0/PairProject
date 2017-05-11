import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class MultipleChoiceQuestion extends Question {
	String question, a, b, c, d, answer;
	JLabel questionLabel, livesLabel;
	//ImageIcon skip;
	JButton aB, bB, cB, dB;//,skips;
	boolean questionInputted = false, choicesInputted = false, answerInputted = false;
	public MultipleChoiceQuestion(MainWindow window, Quiz quiz, int questionNum) {
		super(window, quiz, questionNum);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}
	public MultipleChoiceQuestion(MainWindow window, Quiz quiz, int questionNum, String question) {
		this(window, quiz, questionNum);
		questionInputted = true;
		setQuestion(question);
	}
	public MultipleChoiceQuestion(MainWindow window, Quiz quiz, int questionNum, String question, String a, String b, String c, String d) {
		this(window, quiz, questionNum, question);
		choicesInputted = true;
		setChoices(a, b, c, d);
	}
	public MultipleChoiceQuestion(MainWindow window, Quiz quiz, int questionNum, String question, String a, String b, String c, String d, String answer) {
		this(window, quiz, questionNum, question, a, b, c, d);
		answerInputted = true;
		setAnswer(answer);
	}
	public void setQuestion(String question) {
		this.question = question;
		questionLabel = new JLabel(question);
		questionLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 48));
	}
	public void setChoices(String a, String b, String c, String d) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		aB = new JButton(a);
		bB = new JButton(b);
		cB = new JButton(c);
		dB = new JButton(d);
	}
	public void setAnswer(String answer) {
		if (answerInputted)
			switch (answer) {
				case "a":	addMouseListeners(aB);	break;
				case "b":	addMouseListeners(bB);	break;
				case "c":	addMouseListeners(cB);	break;
				case "d":	addMouseListeners(dB);	break;
			}
		else
			addMouseListeners(aB);
	}
	private void addMouseListeners(JButton button) {
		ArrayList<JButton> answerBs = new ArrayList<JButton>();
		answerBs.add(aB);
		answerBs.add(bB);
		answerBs.add(cB);
		answerBs.add(dB);
		answerBs.remove(button);
		
		button.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				quiz.nextQuestion();
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
		for (int i = 0; i < answerBs.size(); i++)
			answerBs.get(i).addMouseListener(new MouseListener() {
				public void mouseClicked(MouseEvent e) {
					loseLife();
					if (lose())
						quiz.setLosePanel();
					else
						addLivesLabel(true);
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
	}
	public void createPanel() {
		JLabel questionNum;
		ArrayList<JButton> answerBs = new ArrayList<JButton>();
	//	JPanel choicesPanel;
		
		if (!answerInputted) {
			if (!choicesInputted) {
				if (!questionInputted) {
					question = "Question Not Inputted";
					setQuestion(question);
				}
				a = "A";
				b = "B";
				c = "C";
				d = "D";
				setChoices(a, b, c, d);
			}
			answer = "a";
			setAnswer(answer);
		}
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
			//fix questionNum alignment FUCK THIS SHIT
		JPanel pane = new JPanel();
		pane.setBackground(Color.WHITE);
//		p.setPreferredSize(new Dimension(window.getWidth(), 8));
		//p.setBackground(Color.WHITE);
		livesLabel = new JLabel("LIVES: " + quiz.getPlayer().getLives());
		livesLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 60));
		livesLabel.setForeground(Color.GREEN);
		
		questionNum = new JLabel(Integer.toString(this.questionNum) + ".");
		questionNum.setFont(new Font("Comic Sans MS", Font.PLAIN, 48));
		questionNum.setForeground(Color.RED);
		/**
		skips = new JButton();
		skip = new ImageIcon("res/skiparrow.png");
		Image img = skip.getImage().getScaledInstance(125,125, java.awt.Image.SCALE_SMOOTH);
		skips.setIcon(new ImageIcon(img));
		skips.setOpaque(false);
		skips.setBorder(BorderFactory.createEmptyBorder());
		*/
		//questionNum.setAlignmentX(Component.LEFT_ALIGNMENT);
//		p.setAlignmentX(Component.LEFT_ALIGNMENT);
		//add(questionNum);
//		p.add(questionNum);
//		add(p);
		
//		add(Box.createRigidArea(new Dimension(window.getWidth(), window.getHeight() / 12)));
		questionLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 40));
		questionLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		questionLabel.setForeground(Color.BLUE);
//		questionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
//		add(questionLabel);
		
//		add(Box.createRigidArea(new Dimension(window.getWidth(), window.getHeight() / 6)));
		answerBs.add(aB);
		answerBs.add(bB);
		answerBs.add(cB);
		answerBs.add(dB);
		
		for (JButton button : answerBs) {
			button.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
			button.setBackground(new Color(247, 150, 221));
			button.setPreferredSize(new Dimension(window.getWidth() * 2 / 5, window.getHeight() / 8));
		}
		
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(pane);
        pane.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            	.addGroup(layout.createSequentialGroup()
            	.addGap(90, 90, 90)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                		.addComponent(questionNum, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(questionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(aB, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bB, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        	.addComponent(cB, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dB, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))))
                     .addGap(84, 84, 84))
             .addGroup(layout.createSequentialGroup()
            		 	.addGap(22, 22, 22)
                		.addComponent(livesLabel, javax.swing.GroupLayout.PREFERRED_SIZE,300, javax.swing.GroupLayout.PREFERRED_SIZE)
                		 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                		//.addComponent(skips, javax.swing.GroupLayout.PREFERRED_SIZE,100, javax.swing.GroupLayout.PREFERRED_SIZE))
        ));
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
            		  .addGap(27, 27, 27)
                      .addComponent(questionNum, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                      .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            		 .addComponent(questionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addGap(33, 33, 33)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(aB, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dB, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bB, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cB, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createSequentialGroup()
                .addComponent(livesLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
      
                //.addComponent(skips, javax.swing.GroupLayout.PREFERRED_SIZE,100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)))
        );
		add(pane);
	}
	public void removeLivesLabel() {
		removeAll();
		createPanel();
		window.setContentPane(this);
	}
	public void addLivesLabel(boolean lostLife) {
		if (lostLife)
			removeLivesLabel();
		livesLabel = new JLabel("LIVES: " + quiz.getPlayer().getLives());
		livesLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 60));
		livesLabel.setForeground(Color.GREEN);
		livesLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(livesLabel);
	}
	public String getQuestion() {
		return question;
	}
}