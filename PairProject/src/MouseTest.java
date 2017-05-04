import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class MouseTest implements MouseMotionListener {
	JFrame frame;
	double pX;
	double pY;
	Robot r;
	
	MouseTest() {
		frame = new JFrame("mouse");
		try {
			r = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	    Paint paint = new Paint();
	    paint.setBackground(Color.BLUE);
	   // paint.addMouseListener(new PopClickListener());
	    r.mouseMove(1175, 415);
	    frame.add(paint);
	    frame.addMouseMotionListener(new MouseAdapter() {
            public void mouseMoved(MouseEvent e) {
                // Get x,y and store them
            	if(r.getPixelColor(e.getXOnScreen(),e.getYOnScreen()).getBlue() == Color.BLUE.getBlue()) {
            	//	frame.dispose();
            		System.out.println(Color.BLUE);
            		System.out.println(r.getPixelColor(e.getXOnScreen(), e.getYOnScreen()));
            		System.out.println(e.getX() + " " + e.getY());
            	}
            }
        });
	    frame.setPreferredSize(new java.awt.Dimension(850, 600));
	    frame.pack();
	    frame.setVisible(true);
	    frame.setLocationRelativeTo(null);
	}
	public void mouseDragged(MouseEvent e) {}
	public void mouseMoved(MouseEvent e) {}
	
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
	
	public static void main(String args[]) {
		new MouseTest();
	}
}