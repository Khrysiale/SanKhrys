import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ImageElement {
	
	BufferedImage image;;
	long id;
		
	
	public ImageElement(long id,JPanel pan){
		
		System.out.println("Dans ImageElement ok");
		this.id = id;
		JFileChooser fileOpenImage = new JFileChooser();
		fileOpenImage.setAcceptAllFileFilterUsed(false);
		String ext [] = {"bmp","jpg","jpeg","png"};
		FileFilter imgFilter = new FileNameExtensionFilter("bmp, gif, jpg, jpeg, png",ext);
		fileOpenImage.addChoosableFileFilter(imgFilter);
		
		if(fileOpenImage.showOpenDialog(pan)== JFileChooser.APPROVE_OPTION){
			File[] files = fileOpenImage.getSelectedFiles();
		}
	}

	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		
	}
	
}


