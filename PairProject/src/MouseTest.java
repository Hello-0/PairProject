import java.awt.AWTException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Robot;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.*;

public class MouseTest implements MouseMotionListener {

	JFrame frame;
	JLabel yo;
	double pX;
	double pY;
	Robot r;
	
	MouseTest(){
		
		frame = new JFrame("mouse");
		yo = new JLabel("HERE");
		try {
			r = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		yo.setPreferredSize(new Dimension(100,100));
		frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		frame.add(yo);
	    pX= yo.getLocation().getX();
	    pY= yo.getLocation().getY();
	    System.out.println("LoCATION:" + pX +" "+ pY);
	    Paint paint = new Paint();
	    paint.setBackground(Color.BLUE);
	    frame.add(paint);
	    paint.addMouseMotionListener(new MouseAdapter() {
            public void mouseMoved(MouseEvent me) {
                // Get x,y and store them
            	if(r.getPixelColor(me.getX(),me.getY()) == Color.BLUE){
            		System.out.println(r.getPixelColor(me.getX(), me.getY()));
            		System.out.println(me.getX() + " " + me.getY());
            	}
            }
        });
	    frame.setPreferredSize(new java.awt.Dimension(850, 600));
	    frame.pack();
	    frame.setVisible(true);
	}
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	class Paint extends JPanel{
		 public void paintComponent(Graphics g){
				 super.paintComponent(g);
				 g.setColor(Color.GREEN);
		         g.fillRect(25, 25, 50, 50);
		     }
	}
	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public static void main(String args[]){
		new MouseTest();
	}

}
