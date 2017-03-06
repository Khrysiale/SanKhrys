/******
 * 
 * 
 * Class définissant un JPanel
 * Sert de zone d'affichage à l'application. 
 * Permet l'afficahge d'une grille 2D (axe X et Y , quadrillage horizontale et vertical 
 * Permet l'affichage d'objets graphiques 2D
 * Affichage intéractif. L'utilisateur peut déplacer la vue et des zones 
 * 
 * 
 */




import java.awt.Color; 
import java.awt.Graphics; 
import java.awt.Graphics2D; 
import java.awt.event.MouseEvent; 
import java.awt.event.MouseListener; 
import java.awt.event.MouseMotionListener; 
import javax.swing.JPanel; 

public class Canevas extends JPanel implements MouseListener, MouseMotionListener{

	private static final long serialVersionUID = 1L;
	
	
	private ElementManager manager;  //gestionnaire d'objets 
	private float posXLast, posYLast; // ppoint précédent
	private float posXCurrent, posYCurrent; // point de départ
	private CavenasListener listener;
	private int mode ; // VIEW - DRAG OR SCALE 
	private double scales; //échelles
	private static double SCALES_BASE = 100;  // échelle de base 
	private double offsetX, offsetY; // décalage de la vue
	private static int VIEW = 0;
	private static int DRAG = 1; 
	private static int SCALE = 2; 
	private static double stepX=10, stepY=10; // pas des quadrillages sens X et sens Y 

	
	/**
	 * This is the default constructor
	 */
	public Canevas() {
		super();
		this.mode = VIEW;
		this.offsetX = 0;
		this.offsetY = 0;
		this.scales = SCALES_BASE;
		
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
	}

	/**
	 * Get manager
	 * 
	 * @return manager
	 */
	private ElementManager getManager(){
		return manager;
		
	}
	
	/**
	 * Set manager
	 * 
	 * @return void
	 */
	
	public void setManager(ElementManager manager){
		this.manager = manager;
	}
	
	/**
	 * recenterViwe pour recentrer la vue sur les éléments
	 * @param tab tableau de 4 double posXmin, posYmin, posXmax, posYmax en coordonnées réelles de l'élément à recentrer
	 * 
	 */
	public void recenter(double[] tab){
		
		//s'il n'y a rien à afficher, on passe pas besoin de recentrer
		if((tab[1] - tab[0] != Double.NEGATIVE_INFINITY) && (tab[3] - tab[2] != Double.NEGATIVE_INFINITY)){
			double scaleX = (this.getWidth() - 50) * SCALES_BASE / (tab[1] - tab[0]); 
			double scaleY = (this.getHeight() - 50) * SCALES_BASE / (tab[3] - tab[2]); 

			this.scales = Math.min(scaleX, scaleY); 

			this.offsetX = -(this.getScreenLocalX((tab[1] + tab[0]) / 2) - this.getScreenLocalX(0)); 
			this.offsetY = -(this.getScreenLocalY((tab[3] + tab[2]) / 2) - this.getScreenLocalY(0)); 

			this.repaint(); 
		}
	}

	/**
	 * La fonction principale de cette classe est d'afficher des objets que l'utilisateur souhaite afficher. Pour ce faire, il faut convertir
	 * les coordonnées réelles des objets vers les coordonnées de la zone d'affichages sur l'écran.
	 * 
	 * On a besoin de 4 méthodes
	 * getScreenX, getScreenY, getElementX, getElementY
	 * 
	 * La conversion s'effectue ainsi :
	 *  la valeur de la coordonnée réelle de l'élément * SCALE_BASE
	 *  il faut multiplier par -1 si on calcule une valeur Y pour orienter vers l'axe du bas
	 *  et il faut ajouter W/2 et H/2 si on calcule une valeur X ou Y pour se positionner au centre de la zone
	 *  enfin  on ajoute le décalage offset pour décaler l'origine à sa position réelle dans la zone d'affichage 
	 */

	
	/**
	 * getScreenX 
	 * @param x : l'abscisse x réelle de l'élément
	 * @return ll'abscisse de la zone d'affichage (ScreenX)
	 */
	public int getScreenLocalX(double x){
		return (int) Math.round(this.getWidth() / 2 + this.offsetX + x * this.scales / SCALES_BASE); 
	}
	
	/**
	 * getScreenY 
	 * @param y : l'ordonnée y réelle de l'élément
	 * @return l'ordonnée de la zone d'affichage (ScreenY)
	 */
	public int getScreenLocalY(double y){
		return (int) Math.round(this.getHeight() / 2 + this.offsetY - y * this.scales / SCALES_BASE);
	}
	
	/**
	 * getElementX 
	 * @param x : l'abscisse x de la zone d'affichage
	 * @return l'abscisse réel de l'élément (ElementX)
	 */
	public double getElementX(int x){
		return (x - (this.getWidth() / 2 + this.offsetX)) * SCALES_BASE / this.scales; 
	}
	
	/**
	 * getElementY 
	 * @param y : l'ordonnée y de la zone d'affichage
	 * @return l'ordonnée réel de l'élément (ElementY)
	 */
	public double getElementY(int y){
		return (y - (this.getHeight() / 2 + this.offsetY)) * -SCALES_BASE / this.scales; 
	}
	
	
	/**
	 * Surcharge de la méthode paintComponent
	 * Permet de personnaliser la fenêtre d'affichage
	 * et d'afficher les éléments choisis par l'utilisateur
	 */
	@Override
	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D) g; 
		
		int h = this.getHeight(); 
        int w = this.getWidth(); 
        
        //fond blanc
        g.setColor(Color.WHITE);
        g.fillRect(0,0,w,h);
        
       if (this.manager != null){
    	   this.manager.draw(g,this);
       }
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if(this.mode == DRAG){
			int x = e.getX();
			int y = getY();
			
			this.offsetX = this.offsetX + (x - this.posXLast);
			this.offsetY = this.offsetY + (y - this.posYLast);
			
			this.posXLast = x;
			this.posYLast = y;
			
			this.repaint();
			
		}else if (this.mode == SCALE){
			int x = e.getX();
			int y = e.getY();
			
			int dX = (int) (x - this.posXLast);
			int dY = (int) (y - this.posYLast);
			
			int delta;
			if(Math.abs(dX) > Math.abs(dY)){
				delta = dX;
			}else{
				delta = dY;
			}
			
			double newScale = Math.max(1,  this.scales * Math.pow(1.01,  delta));
			double newOffsetX = this.offsetX + this.getElementX((int) this.posXCurrent) / SCALES_BASE * (this.scales - newScale); 
            double newOffsetY = this.offsetY - this.getElementY((int) this.posYCurrent) / SCALES_BASE * (this.scales - newScale);
            
            this.offsetX = newOffsetX; 
            this.offsetY = newOffsetY; 
            this.scales = newScale; 
 
            this.posXLast = x; 
            this.posYLast = y; 
 
            this.repaint(); 
			
		}
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		this.posXLast = e.getX(); 
        this.posYLast = e.getY(); 
 
        if (e.getButton() == MouseEvent.BUTTON1) { 
            this.mode = DRAG; 
        } else if (e.getButton() == MouseEvent.BUTTON2) { 
            this.mode = SCALE; 
            this.posXCurrent = e.getX(); 
            this.posYCurrent = e.getY(); 
        } else { 
            this.mode = VIEW; 
        } 
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		this.mode = VIEW; 
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void addElements() {
		// TODO Auto-generated method stub
		
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
