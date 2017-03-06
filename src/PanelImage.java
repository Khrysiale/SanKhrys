import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.color.ColorSpace;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.awt.image.Raster;
import java.awt.image.RescaleOp;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;



public class PanelImage extends JPanel {
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    
    BufferedImage monImage=null, histogramme=null;
    BufferedImage imageOri=null;
    String nomImage;
	public PanelImage() {
		super();
		setBounds(100,100,200,200);
		// TODO Auto-generated constructor stub
	}
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		if(monImage != null)
			g.drawImage(monImage,200,10,null);
	}
	protected boolean ExisteImage(){
		 if(monImage==null) return false;
		  else return true;
	}
	protected void reduireImage()
	{
		BufferedImage imageReduite = new BufferedImage((int)(monImage.getWidth()*0.5),(int)( monImage.getHeight()*0.5), monImage.getType());
		AffineTransform reduire = AffineTransform.getScaleInstance(0.5, 0.5);
		int interpolation = AffineTransformOp.TYPE_BICUBIC;
		AffineTransformOp retaillerImage = new AffineTransformOp(reduire, interpolation);
		retaillerImage.filter(monImage, imageReduite );
		monImage = imageReduite ;
		repaint();
	}
	protected void agrandirImage()
	{
		BufferedImage imageZoomer = new BufferedImage((int)(monImage.getWidth()*1.5),(int)( monImage.getHeight()*1.5), monImage.getType());
		AffineTransform agrandir = AffineTransform.getScaleInstance(1.5, 1.5);
		int interpolation = AffineTransformOp.TYPE_BICUBIC;
		AffineTransformOp retaillerImage = new AffineTransformOp(agrandir, interpolation);
		retaillerImage.filter(monImage, imageZoomer );
		monImage = imageZoomer ;
		repaint();
	}

	protected void filterMoyenneur()
	{
		BufferedImage image = new BufferedImage(monImage.getWidth(),monImage.getHeight(), monImage.getType());
		float[ ] masqueMedian = 
		{
				1/9f, 1/9f, 1/9f,
				1/9f, 1/9f, 1/9f,
				1/9f, 1/9f, 1/9f
		};
       
		Kernel masque = new Kernel(3, 3, masqueMedian);
		ConvolveOp operation = new ConvolveOp(masque);
		operation.filter(monImage, image);
		monImage = image;
		System.out.println("convolution effectuee");
		repaint();

	}
	protected void filterMedian()
	{
		BufferedImage image = new BufferedImage(monImage.getWidth(),monImage.getHeight(), monImage.getType());
		float[ ] masqueMedian = 
		{
				1/9f, 1/9f, 1/9f,
				1/9f, 1/9f, 1/9f,
				1/9f, 1/9f, 1/9f
		};
       
		Kernel masque = new Kernel(3, 3, masqueMedian);
		ConvolveOp operation = new ConvolveOp(masque);
		operation.filter(monImage, image);
		monImage = image;
		System.out.println("convolution effectu�e");
		repaint();

	}
	protected void filterGaussian()
	{
		BufferedImage image = new BufferedImage(monImage.getWidth(),monImage.getHeight(), monImage.getType());
		float[ ] masqueMedian = 
		{
				1/9f, 1/9f, 1/9f,
				1/9f, 1/9f, 1/9f,
				1/9f, 1/9f, 1/9f
		};
       
		Kernel masque = new Kernel(3, 3, masqueMedian);
		ConvolveOp operation = new ConvolveOp(masque);
		operation.filter(monImage, image);
		monImage = image;
		System.out.println("convolution effectu�e");
		repaint();

	}
	protected void filterSobbel()
	{
		BufferedImage imageX = new BufferedImage(monImage.getWidth(),monImage.getHeight(), monImage.getType());
		float[ ] masqueSoblX = 
		{
				-1f, 0f, 1f,
				-2f, 0f, 2f,
				-1f, 0f, 1f
		};
       
		Kernel masqueX = new Kernel(3, 3, masqueSoblX);
		ConvolveOp operation = new ConvolveOp(masqueX);
		operation.filter(monImage, imageX);
		
		BufferedImage imageY = new BufferedImage(monImage.getWidth(),monImage.getHeight(), monImage.getType());
		float[ ] masqueSoblY = 
		{
			    -1f, -2f, 1f,
				0f, 0f, 0f,
				1f, 2f, 1f
		};
       
		Kernel masqueY = new Kernel(3, 3, masqueSoblY);
		ConvolveOp operation1 = new ConvolveOp(masqueY);
		operation1.filter(monImage, imageY);
		
		monImage = imageX;
		System.out.println("convolution effectu�e");
		repaint();

	}
	protected void filterPrwitt()
	{
	


  	
		
		try {
		
		

  int [][] pixel= new int[monImage.getWidth()][monImage.getHeight()];
  

   
  	  		int x,y,g;
  	
  	
  	
//***************************************************
//Conversion enniveau du Gris


	for (int i = 0; i < monImage.getWidth(); i++) {
		for (int j = 0; j < monImage.getHeight(); j++) {

	

	
		Color pixelcolor= new Color(monImage.getRGB(i,j));

	
		int r=pixelcolor.getRed();
		int gb=pixelcolor.getGreen();
		int b=pixelcolor.getBlue();
		
int hy=(r+gb+b)/3;
		  
			
	int rgb=new Color(hy,hy,hy).getRGB();
		
		// changer la couleur de pixel avec la nouvelle couleur invers�e
		monImage.setRGB(i, j, rgb);

		}
	}	
	


//***************************************************  	
  	

		// parcourir les pixels de l'image
	for (int i = 0; i < monImage.getWidth(); i++) 
	{
		for (int j = 0; j < monImage.getHeight(); j++) 
		{
		
		// recuperer couleur de chaque pixel
		Color pixelcolor= new Color(monImage.getRGB(i, j));

		
		// recuperer les valeur rgb (rouge ,vert ,bleu) de cette couleur
		 pixel[i][j]=monImage.getRGB(i, j);

	
		}
    }

//*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*

	for (int i = 1; i < monImage.getWidth()-2; i++) 
	{
		for (int j = 1; j < monImage.getHeight()-2; j++) 
		{
			
//pixel[i][j]=(pixel[i-1][j-1]+pixel[i-1][j]+pixel[i-1][j+1]+pixel[i][j-1]+pixel[i][j]+pixel[i][j+1]+pixel[i+1][j-1]+pixel[i+1][j]+pixel[i+1][j+1])/9;			
			
x=(pixel[i][j+2]+pixel[i+1][j+2]+pixel[i+2][j+2])-(pixel[i][j]+pixel[i+1][j]+pixel[i+2][j]);
y = (pixel[i + 2][j] + pixel[i + 2][j + 1] + pixel[i + 2][j + 2]) - (pixel[i][j] +  pixel[i][j + 1] + pixel[i][j + 2]);
            
g=Math.abs(x)+Math.abs(y);	


//System.out.println(g);
pixel[i][j]=g;

	}
    }



//*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*





//**********************************************************************************	
		
		
		
		for (int i = 0; i < monImage.getWidth(); i++) {
		for (int j = 0; j < monImage.getHeight(); j++) {

	

	
		Color pixelcolor= new Color(pixel[i][j]);

	
		int r=pixelcolor.getRed();
		int gb=pixelcolor.getGreen();
		int b=pixelcolor.getBlue();
		

		  
			
	int rgb=new Color(r,gb,b).getRGB();
		
		// changer la couleur de pixel avec la nouvelle couleur invers�e
		monImage.setRGB(i, j, rgb);

		}
	}	
	


	

	}
	
	
	 catch (Exception e) {
		System.err.println("erreur -> "+e.getMessage());
	}
	
	System.out.println("fin");
	repaint();

	}

	protected void filterLaplacien()
	{
		try {
			
			

	  int [][] pixel= new int[monImage.getWidth()][monImage.getHeight()];
	  

	   
	  	  		int x,y,g;
	  	
	  	
	  	
	//***************************************************
	//Conversion enniveau du Gris


		for (int i = 0; i < monImage.getWidth(); i++) {
			for (int j = 0; j < monImage.getHeight(); j++) {

		

		
			Color pixelcolor= new Color(monImage.getRGB(i,j));

		
			int r=pixelcolor.getRed();
			int gb=pixelcolor.getGreen();
			int b=pixelcolor.getBlue();
			
	int hy=(r+gb+b)/3;
			  
				
		int rgb=new Color(hy,hy,hy).getRGB();
			
			// changer la couleur de pixel avec la nouvelle couleur invers�e
			monImage.setRGB(i, j, rgb);

			}
		}	
		


	//***************************************************  	
	  	

			// parcourir les pixels de l'image
		for (int i = 0; i < monImage.getWidth(); i++) 
		{
			for (int j = 0; j < monImage.getHeight(); j++) 
			{
			
			// recuperer couleur de chaque pixel
			Color pixelcolor= new Color(monImage.getRGB(i, j));

			
			// recuperer les valeur rgb (rouge ,vert ,bleu) de cette couleur
			 pixel[i][j]=monImage.getRGB(i, j);

		
			}
	    }

	//*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*

		for (int i = 1; i < monImage.getWidth()-2; i++) 
		{
			for (int j = 1; j < monImage.getHeight()-2; j++) 
			{
				
				
	x=-pixel[i][j]-pixel[i+1][j]-pixel[i+2][j]-pixel[i+1][j]+8*pixel[i+1][j+1]-pixel[i+1][j+2]-pixel[i+2][j]-pixel[i+2][j+1]-pixel[i+2][j+2];


	pixel[i][j]=x;

		}
	    }



	//*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*





	//**********************************************************************************	
			
			
			
			for (int i = 0; i < monImage.getWidth(); i++) {
			for (int j = 0; j < monImage.getHeight(); j++) {

		

		
			Color pixelcolor= new Color(pixel[i][j]);

		
			int r=pixelcolor.getRed();
			int gb=pixelcolor.getGreen();
			int b=pixelcolor.getBlue();
			

			  
				
		int rgb=new Color(r,gb,b).getRGB();
			
			// changer la couleur de pixel avec la nouvelle couleur invers�e
			monImage.setRGB(i, j, rgb);

			}
		}	
		

		
			// enregistrement d'image
        repaint();
			


		}
		
		
		 catch (Exception e) {
			System.err.println("erreur -> "+e.getMessage());
		}
		repaint();

	}
	protected void filterCanny(){
  
  	
		
		try {
		

  int [][] pixel= new int[monImage.getWidth()][monImage.getHeight()];
  

   
  	  		int x,y,g;
  	
  	
  	
//***************************************************
//Conversion enniveau du Gris


	for (int i = 0; i < monImage.getWidth(); i++) {
		for (int j = 0; j < monImage.getHeight(); j++) {

	

	
		Color pixelcolor= new Color(monImage.getRGB(i,j));

	
		int r=pixelcolor.getRed();
		int gb=pixelcolor.getGreen();
		int b=pixelcolor.getBlue();
		
int hy=(r+gb+b)/3;
		  
			
	int rgb=new Color(hy,hy,hy).getRGB();
		
		// changer la couleur de pixel avec la nouvelle couleur invers�e
		monImage.setRGB(i, j, rgb);

		}
	}	
	


//***************************************************  	
  	

		// parcourir les pixels de l'image
	for (int i = 0; i < monImage.getWidth(); i++) 
	{
		for (int j = 0; j < monImage.getHeight(); j++) 
		{
		
		// recuperer couleur de chaque pixel
		Color pixelcolor= new Color(monImage.getRGB(i, j));

		
		// recuperer les valeur rgb (rouge ,vert ,bleu) de cette couleur
		 pixel[i][j]=monImage.getRGB(i, j);

	
		}
    }

//*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*

	for (int i = 1; i < monImage.getWidth()-2; i++) 
	{
		for (int j = 1; j < monImage.getHeight()-2; j++) 
		{
			
//pixel[i][j]=(pixel[i-1][j-1]+pixel[i-1][j]+pixel[i-1][j+1]+pixel[i][j-1]+pixel[i][j]+pixel[i][j+1]+pixel[i+1][j-1]+pixel[i+1][j]+pixel[i+1][j+1])/9;			
			
x=-pixel[i][j]+pixel[i][j+2];
y=pixel[i][j]-pixel[i+2][j];            
g=Math.abs(x)+Math.abs(y);	


//System.out.println(g);
pixel[i][j]=g;

	}
    }



//*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*





//**********************************************************************************	
		
		
		
		for (int i = 0; i < monImage.getWidth(); i++) {
		for (int j = 0; j < monImage.getHeight(); j++) {

	

	
		Color pixelcolor= new Color(pixel[i][j]);

	
		int r=pixelcolor.getRed();
		int gb=pixelcolor.getGreen();
		int b=pixelcolor.getBlue();
		

		  
			
	int rgb=new Color(r,gb,b).getRGB();
		
		// changer la couleur de pixel avec la nouvelle couleur invers�e
		monImage.setRGB(i, j, rgb);

		}
	}	
	

	
		// enregistrement d'imag		
		repaint();

	}
	
	
	 catch (Exception e) {
		System.err.println("erreur -> "+e.getMessage());
	}
	
	System.out.println("fin");
	}
	protected void imageEclaircie()
	{
		/*
		 *    RescaleOp brillance = new RescaleOp(A, K, null);
		 *    1.  A< 1, l�image devient plus sombre.
   			  2.  A > 1, l�image devient  plus brillante.
   			  3. K est compris entre 0 et 256 et ajoute un �clairement .
		 */
		BufferedImage imgBrillant = new BufferedImage(monImage.getWidth(), monImage.getHeight(), BufferedImage.TYPE_INT_RGB);
		RescaleOp brillance = new RescaleOp(1.2f, 0, null);
		brillance.filter(monImage, imgBrillant);
		monImage = imgBrillant;
		repaint();


	}

	protected void imageSombre()
	{
		/* RescaleOp assombrir = new RescaleOp(A, K, null);
		 *    
		 *    1.  A < 1, l�image devient plus sombre.
   			  2.  A > 1, l�image devient  plus brillante.
   			  3.  K est compris entre 0 et 256 et ajoute un �clairement .
		 *    
		 */		
		BufferedImage imgSombre = new BufferedImage(monImage.getWidth(), monImage.getHeight(), BufferedImage.TYPE_INT_RGB);
		RescaleOp assombrir = new RescaleOp(0.7f, 10, null);
		assombrir.filter(monImage, imgSombre);
		monImage = imgSombre;
		System.out.println("assombrir effectu�e");
		repaint();
	}

	protected void imageBinaire()
	{   
		BufferedImage imgBinaire = new BufferedImage(monImage.getWidth(), monImage.getHeight(), BufferedImage.TYPE_BYTE_BINARY);
		Graphics2D surfaceImg = imgBinaire.createGraphics();
		surfaceImg.drawImage(monImage, null, null);   
		monImage = imgBinaire;
		repaint();
	}

	protected void imageEnNiveauGris()
	{
		BufferedImage imageGris = new BufferedImage(monImage.getWidth(), monImage.getHeight(), BufferedImage.TYPE_USHORT_GRAY);
		Graphics2D surfaceImg = imageGris.createGraphics();
		surfaceImg.drawImage(monImage, null, null);	      
		monImage = imageGris;
		repaint(); 
	}
	protected void imagelab()
	{
		BufferedImage imagelab = new BufferedImage(monImage.getWidth(), monImage.getHeight(), BufferedImage.TYPE_USHORT_GRAY);
		ColorConvertOp conv=new ColorConvertOp(ColorSpace.getInstance(ColorSpace.TYPE_Lab),null);
		conv.filter(monImage,imagelab);
		monImage=imagelab;
	}
	protected void imageHCV()
	{
		
	}

	protected void ajouterImage(File fichierImage)
	{  
		try {
			 nomImage=fichierImage.getName();
			monImage = ImageIO.read(fichierImage);
			imageOri= ImageIO.read(fichierImage);

		} catch (IOException e) {
			e.printStackTrace();
		}
		repaint(); 
	
	}

	protected BufferedImage getImagePanneau()
	{      // r�cup�rer une image du panneau
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
	protected  void afficheHistograme(){
		JFrame f=new JFrame();
		f.setTitle("Histogramme RGB");
		f.setBounds(365,200, 500,500);
		Histogramme hist=new Histogramme(monImage);
		f.add(hist);
		f.setVisible(true);
		
	}
	protected void Retour(){
		monImage=imageOri;
		repaint();
		
	}

}
