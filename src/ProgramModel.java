
import java.util.Observable;
import java.util.Random;

public class ProgramModel extends Observable {
	
	//The number of circles
	private final int numOfCircles = 50;
	public final int circSize = 20; 
	
	//populus[x,y,(boolean for vaccinated)] //0 is not, 1 is vaccinated
	public int[][] populus = new int[numOfCircles][3];
	

	public ProgramModel(){
		
	}
	
	public void askForUpdate() {
	    setChanged(); notifyObservers("Welcome");
	  }
	  
	 public void start(String percent){
		 String theAction = "";
		 int intPercent = 0;
		  
		  try {
			intPercent = Integer.parseInt(percent);
		} catch (NumberFormatException e) {}
		  
		  setChanged(); notifyObservers(theAction);
	  }
	  
	 public void stop(){
		  //Do nothing for now
		  System.out.println("stop");
	  }
	  
	 public void reset(String percent){
		 String theAction = "";
		 		 Random rand = new Random();
		   for(int i = 0; i<populus.length; i++){
			   populus[i][0] = rand.nextInt(500)+(circSize/2);
			   populus[i][1] = rand.nextInt(400)+(circSize/2);
		   }
		   System.out.println("reset");
		 setChanged(); notifyObservers(theAction);
	  }
	 
	 public int[][] getPopulus(){
		 return populus;
	 }
	
}
