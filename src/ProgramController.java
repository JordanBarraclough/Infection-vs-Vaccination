
/**
 * This is the Controller class, used as the "go between" class for the model
 * and the view.
 * 
 * @author Jordan Barraclough
 *
 */
public class ProgramController {
	// Holds the model and the view so that information cab be sent between the
	// two when needed.
	private ProgramModel model = null;
	private ProgramView view = null;

	/**
	 * Initialises the controller.
	 * 
	 * @param model
	 *            The model to control.
	 * @param view
	 *            The view to control,
	 */
	public ProgramController(ProgramModel model, ProgramView view) {
		this.view = view;
		this.model = model;
	}

	/**
	 * Start the program running the process.
	 */
	public void start() {
		model.start();
	}

	/**
	 * Resets the location of the circles on the screen.
	 * 
	 * @param percent
	 *            The percentage of the circles which are to be vaccinated.
	 */
	public void reset(String percent) {
		model.reset(percent);
	}

}
