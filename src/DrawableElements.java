import java.awt.Graphics;

import Model.pointElement;

public interface DrawableElements {
	
	
	/** 
     * Dessine l'élément graphique 
     * @param g l'élément Graphics sur lequel dessiner 
     * @param cavenas panel sur lequel dessiner 
     */ 

	void draw(Graphics g, Canevas canevas);
	
	
	/** 
     * Renvoie la liste des points définissant l'élément graphique 
     * @return la liste des points 
     */ 
    public pointElement[] getPoints(); 

    
    /** 
    * Renvoie l'identité de l'élément graphique 
    * @return l'identité de l'élément graphique 
    */ 
   public int getId(); 
    

   /** 
    * Renvoie la boite englobante de l'élément graphique 
    * @return un tableau de 4 double: posXmin, posXmax, posYmin, posYmax 
    */ 
	double[] getTab();

}
