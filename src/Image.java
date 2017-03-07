/**
 * @author Sandra
 * @param 
 *
 * precondtion: 
 */

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

	BufferedImage myImage = null;

	public Image() {
		super();
	}

	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		if(myImage != null)
			g.drawImage(myImage, 0, 0, null);
	}


	protected void reduireImage()
	{
		BufferedImage imageReduite = new BufferedImage((int)(myImage.getWidth()*0.5),(int)( myImage.getHeight()*0.5), myImage.getType());
		AffineTransform reduire = AffineTransform.getScaleInstance(0.5, 0.5);
		int interpolation = AffineTransformOp.TYPE_BICUBIC;
		AffineTransformOp retaillerImage = new AffineTransformOp(reduire, interpolation);
		retaillerImage.filter(myImage, imageReduite );
		myImage = imageReduite ;
		repaint();
	}


	protected void agrandirImage()
	{
		BufferedImage imageZoomer = new BufferedImage((int)(myImage.getWidth()*1.5),(int)( myImage.getHeight()*1.5), myImage.getType());
		AffineTransform agrandir = AffineTransform.getScaleInstance(1.5, 1.5);
		int interpolation = AffineTransformOp.TYPE_BICUBIC;
		AffineTransformOp retaillerImage = new AffineTransformOp(agrandir, interpolation);
		retaillerImage.filter(myImage, imageZoomer );
		myImage = imageZoomer ;
		repaint();
	}

	//rend une image flou 
	protected void imgFilter()
	{
		BufferedImage imgFlou = new BufferedImage(myImage.getWidth(),myImage.getHeight(), myImage.getType());
		float[ ] maskFlou = 
		{
				0.1f, 0.1f, 0.1f,
				0.1f, 0.2f, 0.1f,
				0.1f, 0.1f, 0.1f
		};

		Kernel mask = new Kernel(3, 3, maskFlou);
		ConvolveOp operation = new ConvolveOp(mask);
		operation.filter(myImage, imgFlou);
		myImage = imgFlou;
		System.out.println("convolution effectuée");
		repaint();

	}

	protected void imageEclaircie()
	{
		/*
		 *    RescaleOp brillance = new RescaleOp(A, K, null);
		 *    1.  A< 1, l’image devient plus sombre.
   			  2.  A > 1, l’image devient  plus brillante.
   			  3. K est compris entre 0 et 256 et ajoute un éclairement .
		 */
		BufferedImage myImageBrillant = new BufferedImage(myImage.getWidth(), myImage.getHeight(), BufferedImage.TYPE_INT_RGB);
		RescaleOp brillance = new RescaleOp(1.2f, 0, null);
		brillance.filter(myImage, myImageBrillant);
		myImage = myImageBrillant;
		repaint();


	}

	protected void imageSombre()
	{
		/* RescaleOp assombrir = new RescaleOp(A, K, null);
		 *    
		 *    1.  A < 1, l’image devient plus sombre.
   			  2.  A > 1, l’image devient  plus brillante.
   			  3.  K est compris entre 0 et 256 et ajoute un éclairement .
		 *    
		 */		
		BufferedImage myImageSombre = new BufferedImage(myImage.getWidth(), myImage.getHeight(), BufferedImage.TYPE_INT_RGB);
		RescaleOp assombrir = new RescaleOp(0.7f, 10, null);
		assombrir.filter(myImage, myImageSombre);
		myImage = myImageSombre;
		System.out.println("assombrir effectuée");
		repaint();
	}

	protected void imageBinaire()
	{   
		BufferedImage myImageBinaire = new BufferedImage(myImage.getWidth(), myImage.getHeight(), BufferedImage.TYPE_BYTE_BINARY);
		Graphics2D surfacemyImage = myImageBinaire.createGraphics();
		surfacemyImage.drawImage(myImage, null, null);   
		myImage = myImageBinaire;
		repaint();
	}

	protected void imageEnNiveauGris()
	{
		BufferedImage imageGris = new BufferedImage(myImage.getWidth(), myImage.getHeight(), BufferedImage.TYPE_USHORT_GRAY);
		Graphics2D surfacemyImage = imageGris.createGraphics();
		surfacemyImage.drawImage(myImage, null, null);	      
		myImage = imageGris;
		repaint(); 
	}

	protected void ajouterImage(File fichierImage)
	{   // desiiner une image à l'ecran	
		try {
			myImage = ImageIO.read(fichierImage);
		} catch (IOException e) {
			e.printStackTrace();
		}
		repaint(); 
	}

	protected BufferedImage getImagePanneau()
	{      // récupérer une image du panneau
		int width  = this.getWidth();
		int height = this.getHeight();
		BufferedImage image = new BufferedImage(width, height,  BufferedImage.TYPE_INT_RGB);
		Graphics2D g = image.createGraphics();

		this.paintAll(g);
		g.dispose();
		return image;
	}

	protected void enregistrerImage(File fichierImage)
	{
		String format ="JPG";
		BufferedImage image = getImagePanneau();
		try {
			ImageIO.write(image, format, fichierImage);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}