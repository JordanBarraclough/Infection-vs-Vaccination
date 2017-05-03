import javax.swing.JFrame;

/**
 * The main method for the program. Does simple setup/initialisation stuff for
 * the PMV model.
 */
public class Main {

	public static void main(String args[]) {
		// Initialise the JFrame
		JFrame window = new JFrame();
		// Set the title
		window.setTitle("Infection vs Vaccination");
		/*
		 * Makes the program actually stop when the window is exited (if you
		 * don't do this then your eventually computer dies from the number of
		 * programs running)
		 */
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Initialisation stuff
		ProgramModel model = new ProgramModel();
		ProgramView view = new ProgramView(window);
		ProgramController cont = new ProgramController(model, view);
		// Allows the view to interact with the controller.
		view.setController(cont);
		// Makes the model an observer of the view
		model.addObserver(view);
		// Makes the window visible (kinda important)
		window.setVisible(true);

	}

}
