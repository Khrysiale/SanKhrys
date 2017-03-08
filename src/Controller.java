import java.util.ArrayList;




public class Controller implements ApplicationListener{
	
	private static Accueil ui;
	private ElementManager manager;
	private int selectedId;
	private int selectedIdIndex;
	private static ArrayList<byte[]> maByteArray = new ArrayList<byte[]>();
	private static int current;
	
	public Controller (Accueil ui){
		Controller.ui = ui;
		Controller.ui.addListener(this);
		this.manager = new ElementManager();
		this.selectedId = -1;
		this.selectedIdIndex = -1;
		
	}

	

	@Override
	public void onInit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onOpenMenu() {
		
		
	}



	@Override
	public void onNewFileMenu() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void onSaveMenu() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void onSaveAsMenu() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void onQuitMenu() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void onUndoMenu() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void onRedoMenu() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void onAbout() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onCurve() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onEllipse() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onQuadrilateral() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void onTriangle() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void onSquare() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void onLine() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void onRectangle() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void onPoint() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void onExport() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void onImport() {
		System.out.println("Dans controller ok");
		manager.importImages();
		
	}



	@Override
	public void onFilter() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void onTint() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void onNoStroke() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void onFourStroke() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void onTreeStroke() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void onTwoStroket() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void onOneStroke() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void onDodecahedronMenu() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void onTetrahedronMenu() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void onCubeMenu() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void onFill() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void onPerspectiveMenu() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void onOrthogonalMenu() {
		// TODO Auto-generated method stub
		
	}


}
