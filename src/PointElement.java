import java.awt.Color;
import java.awt.Graphics;

public class PointElement implements DrawableElements{
	
	private double x,y;
	private long id;
	private boolean visible;
	private Canevas canevas;
	
	public PointElement(long id, double x, double y){
		this.id=id;
		this.x = x;
		this.y = y;
		this.visible = true;
	}
	
	public PointElement(){
		this.id = 0;
		this.x = 0;
		this.y = 0;
		this.visible = false;
	}

	@Override
	public double[] getTab() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void draw(Graphics g, Canevas canevas) {
		if(this.isVisible()){
			int xPos = canevas.getScreenLocalX(this.x);
			int yPos = canevas.getScreenLocalY(this.y);
			
			int[] xPoints = {xPos+5, xPos-5, xPos -5, xPos+5,xPos+5};
			int[] yPoints = {yPos+5, yPos-5, yPos -5, yPos+5,yPos+5};
			
			g.setColor(Color.BLACK);
			g.drawPolyline(xPoints, yPoints, 5);
		}
		
	}

	@Override
	public void setVisible(boolean flag) {
		this.visible = flag; 
		
	}

	@Override
	public boolean isVisible() {
		return this.visible; 
	}

	@Override
	public PointElement[] getPoints() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double[] tab() {
		return new double[]{this.x,this.x,this.y,this.y}; 
	}
	
	public void setId(long id){
		this.id = id;
	}

	@Override
	public long getId() {
		return this.id;
	}
	
	public void setX(double x){
		this.x = x;
	}
	
	public double getX(){
		return x;
	}
	
	public void setY(double y){
		this.y = y;
	}
	
	public double getY(){
		return y;
	}
	
	

}
