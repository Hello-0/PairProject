import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class SpecialQuestion1 extends Question implements MouseMotionListener {
	boolean start;
	public SpecialQuestion1(MainWindow window, Quiz quiz, int questionNum) {
		super(window, quiz, questionNum);
		start = false;
	}
	public void createPanel() {
		//Paint panel = new Paint();
	}/*
	public void update(Graphics g) {
		paintComponent(g);
	}*/
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (!start) {
			g.drawOval(window.getWidth() - 75, window.getHeight() / 2 - 75 / 2, 75, 75);
		} else {
			addMouseListener(new MouseListener() {
				public void mouseClicked(MouseEvent e) {}
				public void mouseEntered(MouseEvent e) {}
				public void mouseExited(MouseEvent e) {
					loseLife();
				}
				public void mousePressed(MouseEvent e) {}
				public void mouseReleased(MouseEvent e) {}
			});
			addMouseMotionListener(new MouseAdapter() {
				public void MouseMoved(MouseEvent e) {
					
				}
			});
			g.setColor(Color.GREEN);
			g.fillRect(0, window.getHeight() / 2 - 75 / 2, 75, 75);
			g.fillRect(window.getWidth() - 75, window.getHeight() / 2 - 75 / 2, 75, 75);
		}
	}
	public void mouseDragged(MouseEvent e) {}
	public void mouseMoved(MouseEvent e) {}
	/*
	class Paint extends JPanel {
		 public void paintComponent(Graphics g) {
				 super.paintComponent(g);
				 g.setColor(Color.GREEN);
		         g.fillRect(0, 225, 75, 75);
		         g.fillRect(760,225,75,75);
		 }
	}
	*/
	class RightClickMenu extends JPopupMenu {
	    JMenuItem anItem;
	    public RightClickMenu(){
	        anItem = new JMenuItem("Click Me!");
	        add(anItem);
	    }
	}
	class PopClickListener extends MouseAdapter {
	    public void mousePressed(MouseEvent e){
	        if (e.isPopupTrigger())
	            doPop(e);
	    }
	    public void mouseReleased(MouseEvent e){
	        if (e.isPopupTrigger())
	            doPop(e);
	    }
	    private void doPop(MouseEvent e){
	        RightClickMenu menu = new RightClickMenu();
	        menu.show(e.getComponent(), e.getX(), e.getY());
	    }
	}
}