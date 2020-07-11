package Basic;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class addUI {
	

	public void addUI_button(JButton button,String t,int width, int height,Font font){
		
		
		button.setIcon(findImage("BigButtonRegular.png",width,height));
		button.setRolloverIcon(findImage("BigButtonHover.png",width,height));
		button.setPressedIcon(findImage("BigButtonPressed.png",width,height));
		button.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel text = new JLabel(t);
		text.setFont(font);
		text.setForeground(Color.BLACK);
		text.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		button.add(text);
		
	}
	
	private ImageIcon findImage(String imageName,int width, int height){
		BufferedImage image = null;
		try{
			image = ImageIO.read(getClass().getClassLoader().getResource(imageName));
		}catch(IOException e){
			
		}
		Image img = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		ImageIcon newImage = new ImageIcon(img);
		return newImage;
	}
}
