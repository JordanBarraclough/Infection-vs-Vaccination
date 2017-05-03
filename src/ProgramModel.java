
import java.util.Observable;
import java.util.Random;

public class ProgramModel extends Observable {

	// The number of circles
	private final int numOfCircles = 50;
	// Size of the circles
	public final int circSize = 20;

	// populus[x,y,(boolean for vaccinated)] //0 is vaccinated, 1 is not
	// vaccinated, 2 is infected
	public int[][] populus = new int[numOfCircles][3];

	/**
	 * This class contains the workings for the program
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
	 * Starts the program running
	 * @param percent
	 */
	public void start() {
		String theAction = "";


		setChanged();
		notifyObservers(theAction);
	}

	public void stop() {
		// Do nothing for now
		System.out.println("stop");
	}

	public void reset(String percent) {
		String theAction = "";
		int intPercent = 0;
		boolean real = false;
		try {
			intPercent = Integer.valueOf(percent);
			
		} catch (NumberFormatException e) {
			System.out.println("false");
		}
		System.out.println(intPercent);
		Random rand = new Random();
		for (int i = 0; i < populus.length; i++) {
			populus[i][0] = rand.nextInt(500) + (circSize / 2);
			populus[i][1] = rand.nextInt(400) + (circSize / 2);
		}
		System.out.println("reset");
		setChanged();
		notifyObservers(theAction);
	}

	public int[][] getPopulus() {
		return populus;
	}

}
