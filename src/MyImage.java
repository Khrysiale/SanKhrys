/**
 * @author Sandra
 * @param 
 *
 * precondtion: 
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * MyImage
 * Cree une image
 * param[in] pImage image choisi
 * param[in] pFile le nom du fichier image
 */
public class MyImage extends JPanel implements Drawable { //public class Image implements Drawable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8871673203084539139L;
	//public Image image = null;//ok
	//public File imageSrc;//
	public BufferedImage bImg = null;
	public String imgName; //add
	private long id;

	//constructor1
	public MyImage(long id){//public MyImage(Image pimage, String pimgName) {
		//image = pimage;//new
       // imgName = pimgName;
        //fileName = pFile;//new
        super();
        setBounds(100,100,200,200);
        this.id = id;
	}
	
	//constructor2
		//public MyImage(String pfileName) {
			//this.image = getToolkit().getImage(pfileName);//new
	        //fileName = pFile;//new
	        //super();
		//}
	
	@Override
	public void draw(Graphics g) {
		 Graphics2D g2 = (Graphics2D) g;
		if(bImg != null){
			g2.drawImage(bImg,0,0,this);
			g2.finalize();
		}
	}

		
	protected void importImage(File imgFile)	//protected void ajouterImage(File imgFile)
	{   // importe une image	
		try {
			imgName = imgFile.getName();
			bImg = ImageIO.read(imgFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		/*int w = bImg.getWidth(null);
		int h = bImg.getHeight(null);
		BufferedImage bi = new
		    BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		Graphics g = bi.getGraphics();
		g.drawImage(bImg, 0, 0, null);*/
		repaint(); 
	}
	
	
	
	protected BufferedImage getImagePanel()
	{   // recupere image affichee
		int width  = this.getWidth();
		int height = this.getHeight();
		BufferedImage image = new BufferedImage(width, height,  BufferedImage.TYPE_INT_RGB);
		Graphics2D g = image.createGraphics();

		this.paintAll(g);
		g.dispose();
		return image;
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
	 

	

	//rend une image flou 
	protected void filterImage()
	{
		BufferedImage imgBlurry = new BufferedImage(bImg.getWidth(),bImg.getHeight(), bImg.getType());
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

	

	protected void exportImage(File imgFile)//protected void enregistrerImage(File fichierImage)
	{
		String format ="png";
		BufferedImage image = getImagePanel();
		try {
			ImageIO.write(image, format, imgFile);
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