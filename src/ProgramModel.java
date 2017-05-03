
import java.util.Observable;
import java.util.Random;

/**
 * The "brains" of the program. Handles the workings of the program.
 * 
 * @author Jordan Barraclough
 *
 */
public class ProgramModel extends Observable {

	// The number of circles
	private final int numOfCircles = 50;
	// Size of the circles
	public final int circSize = 20;

	// populus[x,y,(boolean for vaccinated)] //0 is vaccinated, 1 is not
	// vaccinated, 2 is infected
	public int[][] populus = new int[numOfCircles][3];

	/**
	 * The programModel constructor. (Honestly doesn't really do that much)
	 */
	public ProgramModel() {

	}

	/**
	 * This is initially called, and sets the model to being changed and
	 * notifies the observer that it has changed
	 */
	public void askForUpdate() {
		setChanged();
		notifyObservers("Welcome");
	}

	/**
	 * Starts the program running.
	 */
	public void start() {
		String theAction = "";

		setChanged();
		notifyObservers(theAction);
	}

	/**
	 * Stops the program running.
	 */
	public void stop() {
		// Do nothing for now
		System.out.println("stop");
	}

	/**
	 * Resets the circles on the screen.
	 * 
	 * @param percent
	 *            The percentage of the circles which are vaccinated.
	 */
	public void reset(String percent) {
		String theAction = "";
		int intPercent = 0;
		// Try catch to get the value of the percentage. This is here to prevent
		// the program breaking if the user decides to do something stupid like
		// put in words
		try {
			intPercent = Integer.valueOf(percent);

		} catch (NumberFormatException e) {
		}
		// Calls the java random integer class to provide random integers for
		// the location of the populus.
		Random rand = new Random();
		// loop through and populate the array
		for (int i = 0; i < populus.length; i++) {
			populus[i][0] = rand.nextInt(500) + (circSize / 2);
			populus[i][1] = rand.nextInt(400) + (circSize / 2);
			populus[i][2] = 1;
		}
		// These if statements prevent the user from setting the percentage
		// higher or lower than 100%
		if (intPercent > 100) {
			intPercent = 100;
		} else if (intPercent < 0) {
			intPercent = 0;
		}
		int num = (populus.length * intPercent) /100;
		for (int i = 0; i < num; i++) {
			populus[i][2] = 0;
		}

		setChanged();
		notifyObservers(theAction);
	}

	/**
	 * Used to retrieve the populus array.
	 * 
	 * @return The populus array.
	 */
	public int[][] getPopulus() {
		return populus;
	}

}
