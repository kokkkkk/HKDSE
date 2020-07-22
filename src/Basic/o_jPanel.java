package Basic;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class o_jPanel extends JPanel{

	private static final long serialVersionUID = 3834957256981320801L;

	Basic.addUI addUI = new Basic.addUI();
	
	private Image image;
	private Image img;
	
	
	boolean initial = false;
	
	public o_jPanel(int type){
		super();
		
		image = addUI.findImages("label_" + type + ".png");
		
	}
	
	@Override
	protected void paintComponent(Graphics g){
		if(!initial){
			img = image.getScaledInstance(getWidth(), getHeight(), Image.SCALE_FAST);
			this.setOpaque(false);
			initial = true;
		}
		
		g.drawImage(img,0,0,null);
		super.paintComponent(g);
	}
}
