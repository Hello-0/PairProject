import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SpecialQuestion1 extends Question {
	
	public SpecialQuestion1(MainWindow window, Quiz quiz, int questionNum) {
		super(window, quiz, questionNum);
	}
	public void createPanel() {
		
	}

	class Paint extends JPanel {
		 public void paintComponent(Graphics g) {
				 super.paintComponent(g);
				 g.setColor(Color.GREEN);
		         g.fillRect(0, 225, 75, 75);
		         g.fillRect(760,225,75,75);
		 }
	}
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