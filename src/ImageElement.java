import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
/* classe permettant de modifier une image chargee
 */
public class ImageElement extends JPanel{
	
	public BufferedImage bImg = null; //image chargee dans le panneau
	long id;
		
	
	public ImageElement(long id){
		
		System.out.println("Dans ImageElement ok");
		this.id = id;
		
	}

	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		
	}
	
}


