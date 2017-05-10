import java.awt.*;
import javax.swing.*;

/**
 * This class is used to draw the canvas and circles onto the screen below the
 * buttons.
 * 
 * @author Jordan Barraclough
 *
 */
class DrawCanvas extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// The array to be drawn
	private int[][] populus = null;
	// The size of the circles
	private int circSize = 20;

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g); // paint background
		setBackground(Color.white);
		// This breaks if it doesn't have a populus, so make one if it's null
		if (populus == null) {
			initPop();
		}
		
		for (int i = 0; i < populus.length; i++) {
			if (populus[i][2] == 0) {
				g.setColor(Color.yellow);
			} else if (populus[i][2] == 1) {
				g.setColor(Color.blue);
			} else if (populus[i][2] == 2) {
				g.setColor(Color.red);
			}

			g.fillOval(populus[i][0], populus[i][1], circSize, circSize);
		}

	}

	/**
	 * Sets the internal populus to @param pop
	 */
	public void setPopulus(int[][] pop) {
		populus = pop;
	}

	/**
	 * used as a placeholder populus array incase the array hasn't been
	 * initialised
	 */
	private void initPop() {
		populus = new int[1][3];
		populus[0][0] = 1;
		populus[0][1] = 1;
		populus[0][2] = 1;
	}

}