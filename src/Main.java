import javax.swing.JFrame;

public class Main {
	

	public static void main (String args[]){
		JFrame window = new JFrame();
		window.setTitle("Infection vs Vaccination");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ProgramModel model = new ProgramModel();
		ProgramView view = new ProgramView(window);
		ProgramController cont = new ProgramController(model,view);
		view.setController(cont);
		
		model.addObserver(view);
		
		window.setVisible(true);
		
	}

}
