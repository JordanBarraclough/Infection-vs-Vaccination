import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.util.Random;

class DrawCanvas extends JPanel {
	

	
   @Override   
   public void paintComponent(Graphics g) {
      super.paintComponent(g);  // paint background
      setBackground(Color.white);
      g.setColor(Color.black);
      for(int i = 0; i<populus.length; i++){
    	  g.fillOval(populus[i][0],populus[i][1],circSize,circSize);
      }
   }
   
}