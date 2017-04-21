import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.*;

public class MouseTest implements MouseMotionListener {

	JFrame frame;
	JLabel yo;
	double pX;
	double pY;
	
	MouseTest(){
		
		frame = new JFrame("mouse");
		yo = new JLabel("HERE");
		yo.setPreferredSize(new Dimension(100,100));
		frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	    frame.setBackground(new java.awt.Color(255, 255, 255));
	    yo.setBackground(Color.red);
	    frame.add(yo);
	    pX= yo.getLocation().getX();
	    pY= yo.getLocation().getY();
	    System.out.println("LoCATION:" + pX +" "+ pY);
	    frame.addMouseMotionListener(new MouseAdapter() {
            public void mouseMoved(MouseEvent me) {
                // Get x,y and store them
             
                System.out.println(me.getX() + " " + me.getY());
            }
        });
	    frame.setPreferredSize(new java.awt.Dimension(850, 600));
	    frame.pack();
	    frame.setVisible(true);
	}
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public static void main(String args[]){
		new MouseTest();
	}

}
