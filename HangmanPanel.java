package rudy_prj_src;

import java.awt.*;

import javax.swing.JPanel;

public class HangmanPanel extends JPanel {
	private int mistakeNum = 0;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void setMistakeNum(int num) {
		mistakeNum = num;
	}
	
	public void paint(Graphics g) {
		drawGallows(g);	
		drawFigure(g, mistakeNum);
	}
	
    public Dimension getPreferredSize() {
        return new Dimension(300, 200);
    }
    
    private void drawGallows(Graphics g) {
    	g.drawLine(330, 30, 260, 60); // hook
    	g.drawLine(330, 30, 330, 190); // body
    	g.drawLine(287, 190, 373, 190); // base
    }
    
    public void drawFigure(Graphics g, int mistakeNum) {
    	switch (mistakeNum) {
    		case 1:
    			g.drawOval(245, 60, 33, 33); // head
    			break;
    		case 2:
    	    	g.drawOval(245, 60, 33, 33); // head
    	    	g.drawLine(261, 93, 261, 150); // body
    	    	break;
    		case 3:
    	    	g.drawOval(245, 60, 33, 33); // head
    	    	g.drawLine(261, 93, 261, 150); // body
    	    	g.drawLine(261, 110, 237, 125); // left arm
    	    	break;
    		case 4: 
    	    	g.drawOval(245, 60, 33, 33); // head
    	    	g.drawLine(261, 93, 261, 150); // body
    	    	g.drawLine(261, 110, 237, 125); // left arm
    	    	g.drawLine(261, 110, 285, 125); // right arm
    	    	break;
    		case 5:
    	    	g.drawOval(245, 60, 33, 33); // head
    	    	g.drawLine(261, 93, 261, 150); // body
    	    	g.drawLine(261, 110, 237, 125); // left arm
    	    	g.drawLine(261, 110, 285, 125); // right arm
    	    	g.drawLine(261, 150, 236, 175); // left leg
    	    	break;
    		case 6:
    	    	g.drawOval(245, 60, 33, 33); // head
    	    	g.drawLine(261, 93, 261, 150); // body
    	    	g.drawLine(261, 110, 237, 125); // left arm
    	    	g.drawLine(261, 110, 285, 125); // right arm
    	    	g.drawLine(261, 150, 236, 175); // left leg
    	    	g.drawLine(261, 150, 286, 175); // right leg
    	    	break;
    	    default: break;
    	}
    }
}
