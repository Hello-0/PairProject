import java.awt.AWTException;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Robot;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.*;

public class MouseTest implements MouseMotionListener {

	JFrame frame;
	double pX;
	double pY;
	Robot r;
	
	MouseTest(){
		
		frame = new JFrame("mouse");
		try {
			r = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	    Paint paint = new Paint();
	    paint.setBackground(Color.BLUE);
	    r.mouseMove(1175, 415);
	    frame.add(paint);
	    frame.addMouseMotionListener(new MouseAdapter() {
            public void mouseMoved(MouseEvent me) {
                // Get x,y and store them
            	if(r.getPixelColor(me.getXOnScreen(),me.getYOnScreen()).getBlue() == Color.BLUE.getBlue()){
            	//	frame.dispose();
            		System.out.println(Color.BLUE);
            		System.out.println(r.getPixelColor(me.getXOnScreen(), me.getYOnScreen()));
            		System.out.println(me.getX() + " " + me.getY());
            	}
            }
        });
	    frame.setPreferredSize(new java.awt.Dimension(850, 600));
	    frame.pack();
	    frame.setVisible(true);
	    frame.setLocationRelativeTo(null);
	}
	public void mouseDragged(MouseEvent arg0) {}
	public void mouseMoved(MouseEvent arg0) {}
	
	class Paint extends JPanel{
		 public void paintComponent(Graphics g){
				 super.paintComponent(g);
				 g.setColor(Color.GREEN);
		         g.fillRect(0, 225, 75, 75);
		         g.fillRect(760,225,75,75);
		 }
	}

	public static void main(String args[]){
		new MouseTest();
	}
}
