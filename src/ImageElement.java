import java.awt.Graphics;
import java.awt.image.BufferedImage;


import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ImageElement implements DrawableElements{
	
	BufferedImage image;
	Canevas canevas;
	long id;
		
	
	public ImageElement(long id){
		
		System.out.println("Dans ImageElement ok");
		this.id = id;
		JFileChooser fileOpenImage = new JFileChooser();
		fileOpenImage.setAcceptAllFileFilterUsed(false);
		String ext [] = {"bmp","jpg","jpeg","png"};
		FileFilter imgFilter = new FileNameExtensionFilter("bmp, gif, jpg, jpeg, png",ext);
		fileOpenImage.addChoosableFileFilter(imgFilter);
		
		if(fileOpenImage.showOpenDialog(canevas)== JFileChooser.APPROVE_OPTION){
			
		}
	}

	@Override
	public double[] getTab() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void draw(Graphics g, Canevas canevas) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setVisible(boolean flag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public PointElement[] getPoints() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double[] tab() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getIdCurrentElement() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public Elements[] getElement() {
		// TODO Auto-generated method stub
		return null;
	}

	
		
		
        
	
}


