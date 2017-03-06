
public class main {

	public static void main(String args[]) 
	{
		try {
			Acceuil frame = new Acceuil();
			Controller controller = new Controller(frame);
			
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
