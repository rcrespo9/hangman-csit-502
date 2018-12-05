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
	}
	
    public Dimension getPreferredSize() {
        return new Dimension(300, 200);
    }
    
    private void drawGallows(Graphics g) {
    	g.drawLine(330, 30, 260, 60);
    	g.drawLine(330, 30, 330, 180);
    	g.drawLine(287, 180, 373, 180);
    }
}
