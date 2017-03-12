import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/*public interface MouseAdapter {

}*/


//L'interface IMovableDrawable qui permet de faire se déplacer un drawable : IMovableDrawable. 
import java.awt.Point;

/*public interface IMovableDrawable extends IDrawable{
	
	void setPosition(Point p);
	
	Point getPosition();

}


//modifier la classe FormDrawable pour la faire implémenter cette interface.
public abstract class FormDrawable implements IMovableDrawable {}


//écouteurs d'évenement de souris
public class JCanvasMouseAdapter extends JCanvasMouseListener implements MouseMotionListener{

	public JCanvasMouseAdapter(JCanvas canvas) {
		super(canvas);
		canvas.addMouseMotionListener(this);
		
	}

	public void mouseDragged(MouseEvent e) {
			
	}

	
	public void mouseMoved(MouseEvent e) {
			
	}
}

//déplacer une forme pou image
public class MoveDrawableMouseListener extends JCanvasMouseAdapter {

	protected IMovableDrawable drawable;

	
	public MoveDrawableMouseListener(JCanvas canvas) {
		super(canvas);
	}

	
	public void mouseDragged(MouseEvent e) {
		if (drawable != null) {
			drawable.setPosition(e.getPoint());
			canvas.repaint();
		}
	}

	
	public void mousePressed(MouseEvent e) {
		List selectedDrawables = canvas.findDrawables(e.getPoint());
		if (selectedDrawables.size() == 0)
			return;
		drawable = (IMovableDrawable) selectedDrawables.get(0);
	}

	public void mouseReleased(MouseEvent e) {
		drawable = null;
	}
}

//vérifie ^pour ne pas dépolacr une forme sur une autre
public class NonOverlapMoveAdapter extends MoveDrawableMouseListener{
	
	private Point initialLocation;

	
	public NonOverlapMoveAdapter(JCanvas canvas) {
		super(canvas);
		
	}

	
	public void mouseReleased(MouseEvent e) {
		if(drawable== null) return ;
		if( !canvas.isAlone(drawable)){
			drawable.setPosition(initialLocation);

		}
		initialLocation =null;
		drawable=null;
		canvas.repaint();
	}

	
	public void mousePressed(MouseEvent e) {
		super.mousePressed(e);
		if(drawable!=null) {
			initialLocation=drawable.getPosition();
		}
	}
}*/