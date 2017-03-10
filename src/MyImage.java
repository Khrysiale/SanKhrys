/**
 * author Sandra
 * class MyImage
 * effectue des traitements sur une image
 * 
 * precondtion: une image ouverte du disque
 * postcondition une image ayant subie un traitement
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
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


public class MyImage extends JPanel implements Drawable { 

	private static final long serialVersionUID = -8871673203084539139L;
	private BufferedImage bufferImg = null;
	//private String imgName; 
	private long id;

	//constructor
	public MyImage(long id){
		super();
        setBounds(100,100,200,200);
        this.id = id;
	}
	
	
	public long getId() {
		return id;
	}

	
	public void setId(long id) {
		this.id = id;
	}

	
	@Override
	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		if(bufferImg != null){
			g2.drawImage(bufferImg,0,0,this);
			g2.finalize();
		}
	}

	
	//lit une image du disque	
	protected void importImage(File imgFile)	
	{   
		try {
			bufferImg = ImageIO.read(imgFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("image importee");		
		repaint(); 
	}
	
	
	//obtient image modifiee du panneau
	protected BufferedImage getImagePanel()
	{   
		int width  = this.getWidth();
		int height = this.getHeight();
		BufferedImage image = new BufferedImage(width, height,  BufferedImage.TYPE_INT_RGB);
		Graphics2D g = image.createGraphics();//getGraphics
		this.paintAll(g);
		g.dispose();
		
		return image;
	}
	
	
	//rend une image flou 
	protected void filterImage()
	{
		BufferedImage imgBlurry = new BufferedImage(bufferImg.getWidth(),bufferImg.getHeight(), bufferImg.getType());
		float[ ] maskBlurry = 
		{
				0.1f, 0.1f, 0.1f,
				0.1f, 0.2f, 0.1f,
				0.1f, 0.1f, 0.1f
		};

		Kernel mask = new Kernel(3, 3, maskBlurry);
		ConvolveOp operation = new ConvolveOp(mask);
		operation.filter(bufferImg, imgBlurry);
		bufferImg = imgBlurry;
		
		System.out.println("filtrage fait");
		repaint();
	}

	//convertie image en vert
	protected void tintGreenImage()
	{
		int width = bufferImg.getWidth();
		int height = bufferImg.getHeight();
		
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
	
	
	//enregistre image modifiee sur disque
	protected void exportImage(File imgFile)
	{
		String format ="png";
		BufferedImage image = getImagePanel();
		try {
			ImageIO.write(image, format, imgFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

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
	
	
}