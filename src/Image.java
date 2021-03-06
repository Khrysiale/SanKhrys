/**
 * @author Sandra
 * @param 
 *
 * precondtion: 
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.awt.image.RescaleOp;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class Image extends JPanel  {

	BufferedImage imgSrc = null;

	public Image() {
		super();
	}

	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		if(imgSrc != null)
			g.drawImage(imgSrc, 0, 0, null);
	}

	protected void colorSpace(){
		int red = 255;
		int blue = 0;
		int green = 0;
		 
		float[] hsbValues = new float[3];
		 
		// conversion
		Color.RGBtoHSB(red, green, blue, hsbValues);
		 
		// Voici comment construire un objet Color en HSB
		Color hsbColor = Color.getHSBColor(hsbValues[0], hsbValues[1], hsbValues[2]);
		 
		// On teste que les deux objets d�crivent la meme couleur
		//System.out.println(rgbColor);
		//System.out.println(hsbColor);
		 
		//if(rgbColor.equals(hsbColor))
		  //System.out.println("Les couleurs sont les m�mes");
		
	}
	 
	/*protected void agrandirImage()
	{
		BufferedImage imageZoomer = new BufferedImage((int)(imgSrc.getWidth()*1.5),(int)( imgSrc.getHeight()*1.5), imgSrc.getType());
		AffineTransform agrandir = AffineTransform.getScaleInstance(1.5, 1.5);
		int interpolation = AffineTransformOp.TYPE_BICUBIC;
		AffineTransformOp retaillerImage = new AffineTransformOp(agrandir, interpolation);
		retaillerImage.filter(imgSrc, imageZoomer );
		imgSrc = imageZoomer ;
		repaint();
	}*/

	//rend une image flou 
	protected void filterImage()
	{
		BufferedImage imgBlurry = new BufferedImage(imgSrc.getWidth(),imgSrc.getHeight(), imgSrc.getType());
		float[ ] maskBlurry = 
		{
				0.1f, 0.1f, 0.1f,
				0.1f, 0.2f, 0.1f,
				0.1f, 0.1f, 0.1f
		};

		Kernel mask = new Kernel(3, 3, maskBlurry);
		ConvolveOp operation = new ConvolveOp(mask);
		operation.filter(imgSrc, imgBlurry);
		imgSrc = imgBlurry;
		//System.out.println("convolution effectuee");
		repaint();
	}


	/*protected void imageEnNiveauGris()
	{
		BufferedImage imageGris = new BufferedImage(imgSrc.getWidth(), imgSrc.getHeight(), BufferedImage.TYPE_USHORT_GRAY);
		Graphics2D surfaceimgSrc = imageGris.createGraphics();
		surfaceimgSrc.drawImage(imgSrc, null, null);	      
		imgSrc = imageGris;
		repaint(); 
	}*/

	protected void importImage(File imgFile)	//protected void ajouterImage(File imgFile)
	{   // importe une image	
		try {
			imgSrc = ImageIO.read(imgFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		repaint(); 
	}

	protected BufferedImage getImagePanel()//protected BufferedImage getImagePanneau()
	{   // recupere image affichee
		int width  = this.getWidth();
		int height = this.getHeight();
		BufferedImage imgDest = new BufferedImage(width, height,  BufferedImage.TYPE_INT_RGB);
		Graphics2D g = imgDest.createGraphics();

		this.paintAll(g);
		g.dispose();
		return imgDest;
	}

	protected void exportImage(File imgFile)//protected void enregistrerImage(File fichierImage)
	{
		String format ="png";
		BufferedImage imgDest = getImagePanel();
		try {
			ImageIO.write(imgDest, format, imgFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}