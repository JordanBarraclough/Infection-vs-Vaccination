import java.awt.Container;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;
import javax.swing.RootPaneContainer;

/**
 * The view class, used for anything that is being produce to the screen.
 * 
 * @author Jordan Barraclough
 *
 */
public class ProgramView implements Observer {
	// The height and width of the JFrame
	private static final int HEIGHT = 600; // Height of window
	private static final int WIDTH = 600; // Width of window

	// The buttons, text field, label and canvas for the program.
	private final JButton runBt = new JButton("Run");
	private final JButton resetBt = new JButton("Reset");
	private final JTextField theInputPcnt = new JTextField();
	private final JLabel descript = new JLabel();
	private final JLabel theAction = new JLabel();
	private DrawCanvas canvas;

	private ProgramController cont = null;

	/**
	 * This class is used for everything that is going to be drawn to the
	 * screen.
	 * 
	 * @param rpc
	 *            The container which this view is going to be drawing to.
	 */
	public ProgramView(RootPaneContainer rpc) {

		Container cp = rpc.getContentPane(); // Content Pane
		Container rootWindow = (Container) rpc; // Root Window
		cp.setLayout(null); // No layout manager
		rootWindow.setSize(WIDTH, HEIGHT); // Size of Window

		runBt.setBounds(10, 10, 80, 40); // Start button
		runBt.addActionListener( // Call back code
				e -> cont.start());
		cp.add(runBt);

		resetBt.setBounds(100, 10, 80, 40); // Start button
		resetBt.addActionListener( // Call back code
				e -> cont.reset(theInputPcnt.getText()));
		cp.add(resetBt);

		theInputPcnt.setBounds(350, 10, 100, 40); // Input Area
		theInputPcnt.setText("0"); // Start with a nice 0 in the box
		cp.add(theInputPcnt);
		
		descript.setBounds(190, 10, 150, 40);
		descript.setText("Vaccinated percentage:");
		cp.add(descript);

		theAction.setBounds(110, 25, 270, 20); // Message area
		theAction.setText(""); // Blank
		cp.add(theAction);

		canvas = new DrawCanvas(); // Canvas area
		canvas.setBounds(10, 60, 550, 450); // Sets the position and size of the canvas to be drawn.
		cp.add(canvas);
	}

	/**
	 * Sets the controller so that it can be used to relay information by the view.
	 * @param c
	 */
	public void setController(ProgramController c) {
		cont = c;
	}

	@Override
	public void update(Observable modelp, Object arg) {
		ProgramModel model = (ProgramModel) modelp;
		String message = (String) arg;
		theAction.setText(message);
		canvas.setPopulus(model.getPopulus());
		canvas.repaint();
		theInputPcnt.requestFocusInWindow();
	}

}
