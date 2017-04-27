import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.util.Random;

class DrawCanvas extends JPanel {
	
	private int[][] populus = null;
	private int circSize = 20;
	
	
	
   @Override   
   public void paintComponent(Graphics g) {
      super.paintComponent(g);  // paint background
      setBackground(Color.white);
      g.setColor(Color.black);
      if (populus == null){
    	  initPop();
      }
      for(int i = 0; i<populus.length; i++){
    	  g.fillOval(populus[i][0],populus[i][1],circSize,circSize);
      }
   }
   
   public void setPopulus(int[][] pop){
	   populus = pop;
   }
   
   private void initPop(){
	    populus = new int[1][3];
		populus[0][0]=1;
		populus[0][1]=1;
		populus[0][2]=1;
   }
   
}