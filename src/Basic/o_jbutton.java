package Basic;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.SwingConstants;

public class o_jbutton extends JButton{

	private static final long serialVersionUID = -1111560679427958283L;

	Basic.addUI addUI = new Basic.addUI();
	
	boolean initial = false;
	
	public o_jbutton(String t){
		super(t);

	}
	
	@Override
	protected void paintComponent(Graphics g){
		
		if(!initial){
			this.setIcon(addUI.findImage("BigButtonRegular.png",getWidth()-5,getHeight()));
			this.setRolloverIcon(addUI.findImage("BigButtonHover.png",getWidth()-5,getHeight()));
			this.setPressedIcon(addUI.findImage("BigButtonPressed.png",getWidth()-5,getHeight()));
			this.setBackground(new Color(1,1,1,(float)0.01));
			this.setBorderPainted(false);
			this.setMargin(new Insets(0,0,0,0));
			this.setContentAreaFilled(false);
			this.setHorizontalAlignment(SwingConstants.LEFT);
			this.setHorizontalTextPosition(JButton.CENTER);
			initial = true;
		}
	
		super.paintComponent(g);
	}
}
