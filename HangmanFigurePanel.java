package rudy_prj_src;

import java.awt.*;

import javax.swing.JPanel;

public class HangmanFigurePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void paint(Graphics g) {
		drawGallows(g);	
		drawFigure(g);
	}
	
    public Dimension getPreferredSize() {
        return new Dimension(300, 200);
    }
    
    private void drawGallows(Graphics g) {
    	g.drawLine(330, 30, 260, 60); // hook
    	g.drawLine(330, 30, 330, 190); // body
    	g.drawLine(287, 190, 373, 190); // base
    }
    
    public void drawFigure(Graphics g) {
    	g.drawOval(245, 60, 33, 33); // head
    	g.drawLine(261, 93, 261, 150); // body
    	g.drawLine(261, 110, 237, 125); // left arm
    	g.drawLine(261, 110, 285, 125); // right arm
    	g.drawLine(261, 150, 236, 175); // left leg
    	g.drawLine(261, 150, 286, 175); // right leg
    }
}
