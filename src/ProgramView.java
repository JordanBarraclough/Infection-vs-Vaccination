import java.awt.Container;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;
import javax.swing.RootPaneContainer;


public class ProgramView implements Observer{

	private static final int HEIGHT = 600;       // Height of window pixels
	private static final int WIDTH = 600;       // Width  of window pixels
	
	private final JButton startBt = new JButton("Start");
	private final JButton stopBt = new JButton("Stop");
	private final JButton resetBt = new JButton("Reset");
	private final JTextField theInputPcnt = new JTextField();
	private DrawCanvas canvas;
	
	private ProgramController cont = null;
	
	public ProgramView(RootPaneContainer rpc){
		
		 Container cp         = rpc.getContentPane();    // Content Pane
		    Container rootWindow = (Container) rpc;         // Root Window
		    cp.setLayout(null);                             // No layout manager
		    rootWindow.setSize(WIDTH, HEIGHT);                     // Size of Window
		    
		    
		    startBt.setBounds(10, 10, 80, 40);   		   // Start button 
		    startBt.addActionListener(                     // Call back code
		      e -> cont.start(theInputPcnt.getText()) );
		    cp.add(startBt); 
		    
		    stopBt.setBounds(100, 10, 80, 40);   		   // Start button 
		    stopBt.addActionListener(                     // Call back code
		      e -> cont.stop() );
		    cp.add(stopBt);
		    
		    resetBt.setBounds(190, 10, 80, 40);   		   // Start button 
		    resetBt.addActionListener(                     // Call back code
		      e -> cont.reset("10"));
		    cp.add(resetBt);
		    
		    theInputPcnt.setBounds(280, 10, 200, 40);         // Input Area
		    theInputPcnt.setText("0");                           // Blank
		    cp.add(theInputPcnt); 
		    
		    canvas = new DrawCanvas();
		    canvas.setBounds(10, 60, 550, 450);
		    cp.add(canvas);
	}
	
	
	public void setController(ProgramController c) {
	    cont = c;
	  }


	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
	
}
