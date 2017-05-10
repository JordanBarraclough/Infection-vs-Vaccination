
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
	
	private final int finalDistance = 10;
	
	// used to check the distance between infected and vaccinated
	private int distance = finalDistance;
	
	

	// populus[x,y,(boolean for vaccinated)] //0 is vaccinated, 1 is not
	// vaccinated, 2 is infected
	public int[][] populus = new int[numOfCircles][3];

	/**
	 * The programModel constructor. (The constructor honestly doesn't really do that much)
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
		distance+=10;
		String theAction = "";
		System.out.println("here");
		
		for (int i = 0; i < populus.length; i++) {
			if (populus[i][2] == 2) {
				for (int j = 0; j < populus.length; j++) {
					if (populus[j][2] == 1) {
						int xDis = Math.abs(populus[i][0] - populus[j][0]);
						int yDis = Math.abs(populus[i][1] - populus[j][1]);
						if (xDis <= distance && yDis <= distance) {
							populus[j][2] = 2;
							System.out.println("here2");
							setChanged();
							notifyObservers(theAction);
						}
					}
				}
			}
		}

		setChanged();
		notifyObservers(theAction);
	}

	/**
	 * Resets the circles on the screen.
	 * 
	 * @param percent
	 *            The percentage of the circles which are vaccinated.
	 */
	public void reset(String percent) {
		String theAction = "";

		// reset the distance check back to 10
		distance = finalDistance;
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
		// higher than 100% or lower than 0%
		if (intPercent > 100) {
			intPercent = 100;
		} else if (intPercent < 0) {
			intPercent = 0;
		}
		int num = (populus.length * intPercent) / 100;
		for (int i = 0; i < num; i++) {
			populus[i][2] = 0;
		}

		populus[0][2] = 2;

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
