/**
 * 
 * Class qui génère un simple point en x, y .
 * 
 * */


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;

public class PointElement  extends Point2D.Double implements Drawable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2815801024727347338L;
	private double x,y;
	

	private long id;
	private boolean visible;
	Graphics2D g2;
	Point2D.Double point ;
	
	
	public PointElement(long id, double x, double y){
		this.id=id;
		this.x = x;
		this.y = y;
		this.visible = true;
		point = new Point2D.Double(this.x,this.y);
		
	}


	@Override
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		((Graphics2D) g).setStroke(new BasicStroke(2.0f));
		g.drawLine((int)this.x,(int)this.y,(int)this.x,(int)this.y);
		
	}

	
}
