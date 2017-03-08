import java.awt.Graphics;



public interface DrawableElements {

	public double[] getTab();

	public void draw(Graphics g, Canevas canevas);
	
	public void setVisible(boolean flag);
	public boolean isVisible();
	
	public PointElement[] getPoints();
	 public double[] tab(); 
	public long getId();
	
	
	

}
