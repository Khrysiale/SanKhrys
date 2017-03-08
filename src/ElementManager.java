import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;


public class ElementManager implements DrawableElements{
	
	private List<DrawableElements> elements ;
	private long idCurrentPoint;
	private CavenasListener listener;
	private Canevas canevas;
	public ElementManager(){
		this.elements = new ArrayList<>();
		this.listener = listener;
	}
	
	/**
	 * 
	 * Initialisation de la liste d'éléments vide
	 * 
	 */
	public void init(){
		this.elements.clear();
	}
	
	
	/**
	 * ajouter un éléments dans la liste
	 * 
	 */
	public void addElement(DrawableElements elem){
		
		this.elements.add(elem);
	}
	
	
	/**
	 * Supprimer un élément de la liste
	 * 
	 */
	public void deleteElement(DrawableElements elem){
		this.elements.remove(elem);
	}
	


	public long getIdCurrentPoint() { 
		idCurrentPoint++; 
		return idCurrentPoint; 
	} 
	
	public void incrementIdCurrentPoint() { 
        idCurrentPoint++; 
    } 
	
	public void setIdCurrentPoint(long idCurrentPoint) { 
        this.idCurrentPoint = idCurrentPoint; 
    } 

	/**
	 * Mise à jour des id des éléments contenu dans la scene
	 * 
	 */
	public void updateID(){
		this.idCurrentPoint = 1; 

		for (int i = 0; i < this.elements.size(); i++) { 

			DrawableElements elem = this.elements.get(i); 

			if (elem instanceof DrawableElements) { 

				PointElement[] pts = elem.getPoints(); 

				if (pts != null) { 

					for (int j = 0; j < pts.length; j++) { 
						long id = pts[j].getId(); 

						if (id > this.idCurrentPoint) { 
							idCurrentPoint = id; 
						} 
					} 
				} 
			} 
		} 
	}


	/**
	 * Renvoie les valeurs posXMin, posYmin, posXMax, posYMax sous la forme d'un tableau
	 */
	public double[] getTab(){
		double tab[] = new double[4];
		
		tab[0] = Double.POSITIVE_INFINITY;//posXmin
		tab[1] = Double.NEGATIVE_INFINITY;//posXmax  
		tab[2] = Double.POSITIVE_INFINITY;//posYmin
		tab[3] = Double.NEGATIVE_INFINITY;//posYmax
		
		for(DrawableElements current : this.elements){
			double [] myTab = current.getTab();
			
			if (myTab [0] < tab[0]) { 
                tab[0] = myTab [0]; 
            } 
            if (myTab [1] > tab[1]) { 
                tab[1] = myTab [1]; 
            } 
            if (myTab [2] < tab[2]) { 
                tab[2] = myTab [2]; 
            } 
            if (myTab [3] > tab[3]) { 
                tab[3] = myTab [3]; 
            } 
        } 
 
        return tab; 
	}
	
	/**
	 * Fonction pour dessiner les éléments de la listes
	 * @param g
	 * @param canevas
	 */

	public void draw(Graphics g, Canevas canevas) {
		for(DrawableElements current : this.elements){
			current.draw(g,canevas);
		}		
	}

	public void importImagesElement() {
		System.out.println("Dans ElementManager ok");
		ImageElement img = new ImageElement();
		elements.add(img);
		
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
	public long getId() {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
