import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Line2D;


public class Line extends Line2D.Double implements Drawable, java.io.Serializable{

	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3361557485568862916L;
	
	private long id;

	public Line(long id){
		this.id = id;
	}
	
	
	@Override
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		((Graphics2D) g).setStroke(new BasicStroke(2.0f));
		((Graphics2D) g).draw(new Line2D.Double(300,300,200,200));
		
	}

	@Override
	public void setPosition(Point p) {
		// TODO Auto-generated method stub
		
	}

}
