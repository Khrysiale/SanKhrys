import java.awt.image.BufferedImage;


import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ImageElement extends DrawableElements{
	
	
	private BufferedImage image;
	private Canevas parent;
	
	public ImageElement(){
		super();
		System.out.println("Dans ImageElement ok");
		JFileChooser fileOpenImage = new JFileChooser();
		fileOpenImage.setAcceptAllFileFilterUsed(false);
		String ext [] = {"bmp","jpg","jpeg","png"};
		FileFilter imgFilter = new FileNameExtensionFilter("bmp, gif, jpg, jpeg, png",ext);
		fileOpenImage.addChoosableFileFilter(imgFilter);
		
		if(fileOpenImage.showOpenDialog(parent)== JFileChooser.APPROVE_OPTION){
			
		}
		
        
	}
}


