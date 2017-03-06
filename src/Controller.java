import java.util.ArrayList;

import Model.Elements;



public class Controller implements ApplicationListener{
	
	private static Acceuil ui;
	private Elements elements;
	private int selectedId;
	private int selectedIdIndex;
	private static ArrayList<byte[]> maByteArray = new ArrayList<byte[]>();
	private static int current;
	
	public Controller (Acceuil ui){
		Controller.ui = ui;
		Controller.ui.addListener(this);
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
	public void onBinariation() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void onBrillance() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void onAssombrir() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void onFilterPriwitt() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void onFilterLaplacien() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void onFilterSobel() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void onFilterCanny() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void onFilterGaussien() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void onFilterMedian() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void onFilterMoyenneur() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void onCurve() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void onCircle() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void onEllipse() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void onPolygon() {
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
	public void onEqualize() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void onStretch() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void onConversion() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void onHistogramme() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void onExport() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void onImport() {
		ui.importImages(elements.addImages());
		
	}



	@Override
	public void onShadesOfGreys() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void onReduce() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void onEnlage() {
		// TODO Auto-generated method stub
		
	}

}
