import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

public class Rectangle implements Drawable, java.io.Serializable{

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6587323653420355697L;
	
	private long id;
	Dimension dim;
	
	public Rectangle(long id){
		
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawRect(150,150,50,50);
				
	}

	@Override
	public void setPosition(Point p) {
		// TODO Auto-generated method stub
		
	}

}
