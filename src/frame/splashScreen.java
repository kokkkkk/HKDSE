package frame;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


	 
public class splashScreen{
    private JFrame window;
    
    frame.title title;
    boolean t = false;

    public splashScreen() {
      addUI();
    }
    
    public splashScreen(frame.title title) {
        addUI();
        this.title = title;
        t = true;
      }
    
    private void addUI(){
    	  window = new JFrame();
          ImageIcon image = new ImageIcon(getClass().getClassLoader().getResource("loading.gif"));
          window.getContentPane().setBackground(Color.BLACK);
          window.getContentPane().add(new JLabel("", image, SwingConstants.CENTER));
          window.setBounds(0,0,800,600);
          window.setVisible(true);
    }

    public void show() {
    	if(t){
    		title.window.setVisible(false);
    		window.setBounds(title.window.getBounds());
    	}
    	
        window.setVisible(true);
    }

    public void hide() {
    	
    	window.dispose();
        
        if(t){
        	title.window.setBounds(window.getBounds());
        	
    		title.window.setVisible(true);
       	}
        
    }

}