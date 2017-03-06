
public class main {

	public static void main(String args[]) 
	{
		try {
			Accueil frame = new Accueil();
			Controller controller = new Controller(frame);
			
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
