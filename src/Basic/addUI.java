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
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class addUI {
	
	public ImageIcon findImage(String imageName,int width, int height){
		BufferedImage image = null;
		try{
			image = ImageIO.read(getClass().getClassLoader().getResource(imageName));
		}catch(IOException e){
			
		}
		Image img = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		ImageIcon newImage = new ImageIcon(img);
		return newImage;
	}
	
	public Image findImages(String imageName){
		BufferedImage image = null;
		try{
			image = ImageIO.read(getClass().getClassLoader().getResource(imageName));
		}catch(IOException e){
			
		}
		return image;
		
	}

}


