package Basic;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JTextArea;

public class o_textArea extends JTextArea{
		
	private static final long serialVersionUID = 2843669449721023104L;

		Basic.addUI addUI = new Basic.addUI();
		
		boolean initial = false;
		
		private Image image;
		private Image img;
		
		public o_textArea(){
			super();
			
			image = addUI.findImages("textArea.png");
		}
		
		@Override
		protected void paintComponent(Graphics g){
			
			if(!initial){
				img = image.getScaledInstance(getWidth(), getHeight(), Image.SCALE_FAST);
				this.setBackground(new Color(1,1,1,(float)0.01));
				initial = true;
			}
			
			g.drawImage(img,0,0,null);
			super.paintComponent(g);
		}
		
		
		
	}
