package Basic;

import java.awt.Graphics;

import javax.swing.JLabel;

public class o_jLabel extends JLabel{
	
	Basic.addUI addUI = new Basic.addUI();
	
	boolean initial = false;
	
	public o_jLabel(String t){
		super(t);

	}
	
	@Override
	protected void paintComponent(Graphics g){
		if(!initial){
			this.setIcon(addUI.findImage("label_1.png",getWidth(), getHeight()));
			this.setHorizontalTextPosition(JLabel.CENTER);
			initial = true;
		}
		
		super.paintComponent(g);
	}
	
}
