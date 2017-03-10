/**
 * @author Sandra
 * @param 
 *
 * precondtion: 
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * MyImage
 * Cree une image
 * param[in] pImage image choisi
 * param[in] pFile le nom du fichier image
 */
public class MyImage extends JPanel implements Drawable {

	private static final long serialVersionUID = -8871673203084539139L;
	private BufferedImage bImg = null;
	private String imgName = "";
	private long id = 0;
	private int imgWidth = 0;
	private int imgHeight = 0;
	
	//constructor
	public MyImage(long id){
		super();
        setBounds(100,100,200,200);
        this.id = id;
	}
	
	@Override
	public void draw(Graphics g) {
		 Graphics2D g2 = (Graphics2D) g;
		if(bImg != null){
			g2.drawImage(bImg,0,0,this);
			g2.finalize();
		}
	}

	protected void importImage(File imgFile)	
	{   // importe image dans le buffer	
		try {
			imgName = imgFile.getName();
			bImg = ImageIO.read(imgFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("image importee");		

		imgWidth = bImg.getWidth();
		imgHeight = bImg.getHeight();
		
		BufferedImage bi = new
		    BufferedImage(imgWidth, imgHeight, BufferedImage.TYPE_INT_RGB);
		Graphics g = bi.getGraphics();
		g.drawImage(bImg, 0, 0, null);

		repaint(); 
	}
	
	protected BufferedImage getImagePanel()
	{   // recupere image affichee
				
		BufferedImage image = new BufferedImage(imgWidth, imgHeight,  BufferedImage.TYPE_INT_RGB);
		Graphics2D g2D = image.createGraphics();
		//on demande au panel de se dessiner sur les graphics de l'image
		this.paintAll(g2D);
		g2D.dispose();
		return image;
	}
	
	/*protected void colorSpace(){
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
		
	}*/
	 

	//rend une image flou 
	protected void filterImage()
	{
		BufferedImage imgBlurry = new BufferedImage(imgWidth, imgHeight, bImg.getType());
		float[ ] maskBlurry = 
		{
				0.1f, 0.1f, 0.1f,
				0.1f, 0.2f, 0.1f,
				0.1f, 0.1f, 0.1f
		};

		Kernel mask = new Kernel(3, 3, maskBlurry);
		ConvolveOp operation = new ConvolveOp(mask);

		operation.filter(bImg, imgBlurry);
		bImg = imgBlurry;
		
		System.out.println("filtrage fait");
		repaint();
	}

	//convertie image en vert
	protected void tintGreenImage()
	{
		int width = bImg.getWidth();
		int height = bImg.getHeight();
		
		BufferedImage imgGreen = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		for(int y = 0; y < height; y++){
			for(int x = 0; x < width; x++){
				int p = imgGreen.getRGB(x, y);
				int a = (p >> 24)&0xff;
				int g = (p >>8)&0xff;
				
				//nouvelle couleur
				p = (a<<24) | (0<<16) | (g<<8) | 0;
				
				imgGreen.setRGB(x,  y,  p);
			}
		}
		
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

	
	//enregistre image modifiee sur disque
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

	@Override
	public void setPosition(Point p) {
		// TODO Auto-generated method stub
		
	}

	

	
	
	/*protected void reduireImage()
	{
		BufferedImage imageReduite = new BufferedImage((int)(imgSrc.getWidth()*0.5),(int)( imgSrc.getHeight()*0.5), imgSrc.getType());
		AffineTransform reduire = AffineTransform.getScaleInstance(0.5, 0.5);
		int interpolation = AffineTransformOp.TYPE_BICUBIC;
		AffineTransformOp retaillerImage = new AffineTransformOp(reduire, interpolation);
		retaillerImage.filter(imgSrc, imageReduite );
		imgSrc = imageReduite ;
		repaint();
	}*/



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
	
	/*protected void imageEnNiveauGris()
	{
		BufferedImage imageGris = new BufferedImage(imgSrc.getWidth(), imgSrc.getHeight(), BufferedImage.TYPE_USHORT_GRAY);
		Graphics2D surfaceimgSrc = imageGris.createGraphics();
		surfaceimgSrc.drawImage(imgSrc, null, null);	      
		imgSrc = imageGris;
		repaint(); 
	}*/
	
}