
public class ProgramController {
	
	private ProgramModel model = null;
	private ProgramView view = null;

	  public ProgramController( ProgramModel model, ProgramView view )
	  {
	    this.view  = view;
	    this.model = model;
	  }
	  
	  /**
	   * Start the program
	   */
	  public void start(){
		  model.start();
	  }
	  
	  public void stop(){
		  model.stop();
	  }
	  
	  public void reset(String percent){
		  model.reset(percent);
	  }
	
}
