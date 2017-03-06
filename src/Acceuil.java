import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;
import javax.swing.WindowConstants;

import Model.imagesElements;




public class Acceuil extends JFrame implements ActionListener, ApplicationListener {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4648688787386404371L;

	public static Acceuil ui;
	


	private ApplicationListener listener;
	private DrawableElements elements;
	
	private final JMenuBar menuBar = new JMenuBar();
	
	/*   MENU AND SUB MENU FILE */
	private final JMenu fileMenu = new JMenu();
	private final JMenuItem openMenu = new JMenuItem();
	private final JMenuItem newFileMenu = new JMenuItem();
	private final JMenuItem saveMenu = new JMenuItem();
	private final JMenuItem saveAsMenu = new JMenuItem();
	private final JMenuItem quitMenu = new JMenuItem();
	
	
	/*   MENU AND SUB MENU EDIT */
	private final JMenu     EditMenu = new JMenu();
	private final JMenuItem undoMenu = new JMenuItem();
	private final JMenuItem redoMenu = new JMenuItem();
	private final JMenuItem enlargeMenu = new JMenuItem();
	private final JMenuItem reduceMenu = new JMenuItem();
	
	
	
	/*   MENU AND SUB MENU IMAGES*/
	private final JMenu imageMenu = new JMenu();
	private final JMenuItem shadesOfGrey = new JMenuItem();
	private final JMenuItem importMenu = new JMenuItem();
	private final JMenuItem exportMenu = new JMenuItem();
	private final JMenuItem histogrammeMenu = new JMenuItem();
	private final JMenuItem ConversionMenu = new JMenuItem();
	private final JMenuItem  stretchMenu = new JMenuItem();
	private final JMenuItem  equalizeMenu = new JMenuItem();
	
	
	/*        MENU AND SUB MENU FORM */
	private final JMenu formMenu = new JMenu();
	private final JMenu form2DMenu = new JMenu();
	private final JMenu form3DMenu = new JMenu();
	private final JMenuItem  pointMenu = new JMenuItem();
	private final JMenuItem  rectangleMenu = new JMenuItem();
	private final JMenuItem  lineMenu = new JMenuItem();
	private final JMenuItem  triangleMenu = new JMenuItem();
	private final JMenuItem  squareMenu = new JMenuItem();
	private final JMenuItem  quadrilateralMenu = new JMenuItem();
	private final JMenuItem  polygonMenu = new JMenuItem();
	private final JMenuItem  ellipseMenu = new JMenuItem();
	private final JMenuItem  circleMenu = new JMenuItem();
	private final JMenuItem  curveMenu = new JMenuItem();
	
	
	/*    MENU AND SUB MENU FILTER */
	private final JMenu filterMenu = new JMenu();
	private final JMenuItem filtermoyenneurMenu = new JMenuItem();
	private final JMenuItem filtermedianMenu = new JMenuItem();
	private final JMenuItem filtergaussienMenu = new JMenuItem();
	private final JMenuItem filterCannytMenu = new JMenuItem();
	private final JMenuItem filterSobelMenu = new JMenuItem();
	private final JMenuItem filterlaplacienMenu = new JMenuItem();
	private final JMenuItem filterpriwittMenu = new JMenuItem();
	
	
	/*     MENU AND SUB MENU TRAITEMENT*/
	private final JMenu traitementMenu = new JMenu();
	private final JMenuItem assombrirMenu = new JMenuItem();
	private final JMenuItem brillanceMenu = new JMenuItem();
	private final JMenuItem binarisationMenu = new JMenuItem();
	

	/*        MENU AND SUB MENU HELP*/
	private final JMenu helpMenu = new JMenu();
	private final JMenuItem aboutMenu = new JMenuItem();
	private final Canevas cavenas=new Canevas();
	
	private   PanelImage panneau =null;
	

	

	private JTabbedPane jTabbedPane=null;


	public Acceuil() {
		super();
		setBounds(150, 100,1000,600);
		setTitle("SanKhrys application graphic ");
		jTabbedPane=new JTabbedPane();
	
      
		jTabbedPane.add("Sans titre",cavenas);	
		getContentPane().add(jTabbedPane);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		try {
			createMenu();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	private void createMenu() throws Exception {
		
		createFileMenu();
		createEditMenu();
		createImageMenu();
		createFormMenu();
		createFilterMenu();
		createTraitementMenu();
		createHelpMenu();
	}

	private void createFileMenu() {
		// construction du menu
		setJMenuBar(menuBar);	
		menuBar.add(fileMenu);
		fileMenu.setText("Fichier");
		fileMenu.add(openMenu);
		fileMenu.add(newFileMenu);	
		newFileMenu.addActionListener(this);
		newFileMenu.setText("Nouveau");
		openMenu.addActionListener(this);
		openMenu.setText("Ouvrir");


		fileMenu.addSeparator();

		fileMenu.add(saveMenu);
		fileMenu.add(saveAsMenu);
		saveMenu.addActionListener(this);
		saveMenu.setText("Enregistrer");
		saveAsMenu.setText("Enregistrer Sous");
		fileMenu.addSeparator();

		fileMenu.add(quitMenu);
		quitMenu.addActionListener(this);
		quitMenu.setText("Quitter");

	}


	private void createEditMenu(){
		menuBar.add(EditMenu);
		EditMenu.setText("Edition");
		EditMenu.add(undoMenu);
		EditMenu.add(redoMenu);
		redoMenu.addActionListener(this);
		redoMenu.setText("Redo");
		undoMenu.setText("Undo");
		undoMenu.addActionListener(this);
		EditMenu.addSeparator();

		EditMenu.add(enlargeMenu);
		enlargeMenu.addActionListener(this);
		enlargeMenu.setText("Agrandir");
		EditMenu.add(reduceMenu);
		reduceMenu.addActionListener(this);
		reduceMenu.setText("Réduire");

	}


	private void createImageMenu(){
		menuBar.add(imageMenu);
		imageMenu.setText("Image");		
		imageMenu.addSeparator();

		imageMenu.add(shadesOfGrey);
		imageMenu.add(importMenu);
		imageMenu.add(exportMenu);
		shadesOfGrey.addActionListener(this);
		importMenu.addActionListener(this);
		importMenu.setText("Importer");
		exportMenu.addActionListener(this);
		exportMenu.setText("Exporter");
		shadesOfGrey.setText("Niveau de Gris");
		imageMenu.addSeparator();

		imageMenu.add(ConversionMenu);
		ConversionMenu.addActionListener(this);
		ConversionMenu.setText("Convesion");
		imageMenu.add(histogrammeMenu);
		histogrammeMenu.setText("Histogramme");
		histogrammeMenu.addActionListener(this);
		imageMenu.addSeparator();

		imageMenu.add(stretchMenu);
		stretchMenu.setText("Etirer");
		imageMenu.addSeparator();

		imageMenu.add(equalizeMenu);
		equalizeMenu.addActionListener(this);
		equalizeMenu.setText("Egaliser");
	}


	private void createFormMenu(){
		menuBar.add(formMenu);
		formMenu.setText("Formes");
		formMenu.add(form2DMenu);
		form2DMenu.setText("Formes 2D");
		form3DMenu.setText("Formes 3D");
		formMenu.add(form3DMenu);
		form2DMenu.add(pointMenu);
		pointMenu.addActionListener(this);
		pointMenu.setText("Point");
		form2DMenu.add(lineMenu);
		lineMenu.addActionListener(this);
		lineMenu.setText("Ligne");
		form2DMenu.add(rectangleMenu);
		rectangleMenu.addActionListener(this);
		rectangleMenu.setText("Rectangle");

		form2DMenu.add(triangleMenu);
		triangleMenu.addActionListener(this);
		triangleMenu.setText("Triangle");
		form2DMenu.add(squareMenu);
		squareMenu.addActionListener(this);
		squareMenu.setText("Carré");
		form2DMenu.add(quadrilateralMenu);
		quadrilateralMenu.addActionListener(this);
		quadrilateralMenu.setText("Qualidratère");
		form2DMenu.add(polygonMenu);
		polygonMenu.addActionListener(this);
		polygonMenu.setText("Polygone");
		form2DMenu.add(ellipseMenu);
		ellipseMenu.addActionListener(this);
		ellipseMenu.setText("Ellipse");
		form2DMenu.add(circleMenu);
		circleMenu.addActionListener(this);
		circleMenu.setText("Cercle");
		form2DMenu.add(curveMenu);
		curveMenu.addActionListener(this);
		curveMenu.setText("Arc");

	}


	private void createFilterMenu(){
		menuBar.add(filterMenu);	
		filterMenu.setText("Filtre");

		filterMenu.add(filtermoyenneurMenu);
		filtermoyenneurMenu.setText("Filtre Moyenneur");
		filtermoyenneurMenu.addActionListener(this);



		filterMenu.add(filtergaussienMenu);
		filtergaussienMenu.setText("Filtre Gaussien");
		filtermedianMenu.addActionListener(this);



		filterMenu.add(filtermedianMenu);
		filtermedianMenu.setText("Filtre Médian");
		filtermedianMenu.addActionListener(this);
		filterMenu.addSeparator();


		filterMenu.add(filterSobelMenu);
		filterSobelMenu.setText("Filtre Sobel");
		filterSobelMenu.addActionListener(this);


		filterMenu.add(filterpriwittMenu);
		filterpriwittMenu.setText("Filtre Priwitt");
		filterpriwittMenu.addActionListener(this);


		filterMenu.add(filterlaplacienMenu);
		filterlaplacienMenu.setText("Filtre Laplacien");
		filterlaplacienMenu.addActionListener(this);



		filterMenu.add(filterCannytMenu);
		filterCannytMenu.setText("Filtre Canny");
		filterCannytMenu.addActionListener(this);
	}


	private void createTraitementMenu(){
		menuBar.add(traitementMenu);
		traitementMenu.setText("Traitement");


		traitementMenu.add(binarisationMenu);
		binarisationMenu.addActionListener(this);
		binarisationMenu.setText("Binarisation");
		traitementMenu.addSeparator();

		traitementMenu.add(assombrirMenu);
		assombrirMenu.addActionListener(this);
		assombrirMenu.setText("Assombrir");
		traitementMenu.addSeparator();

		traitementMenu.add(brillanceMenu);
		brillanceMenu.addActionListener(this);
		brillanceMenu.setText("Brillance");
	}

	private void createHelpMenu(){
		menuBar.add(helpMenu);
		helpMenu.setText("Aide");
		helpMenu.add(aboutMenu);
		aboutMenu.addActionListener(this);
		aboutMenu.setText("A propos");

	}


	// ajouter le panneau de dessin 



	/* LISTENER DES JMENUITEM*/
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(openMenu))	{
			listener.onOpenMenu();

		}else if(e.getSource().equals(newFileMenu)){
			listener.onNewFileMenu();
			
		}else if(e.getSource().equals(saveMenu )){
			listener.onSaveMenu();
			
		}else if(e.getSource().equals(saveAsMenu)){
			listener.onSaveAsMenu();
		}else if(e.getSource().equals(quitMenu)){
			listener.onQuitMenu();
			
		}else if(e.getSource().equals(undoMenu)){
			listener.onUndoMenu();
			
		}else if(e.getSource().equals(redoMenu)){
			listener.onRedoMenu();
			
		}else if(e.getSource().equals(enlargeMenu)){
			listener.onEnlage();
		}else if(e.getSource().equals(reduceMenu)){
			listener.onReduce();
		}else if(e.getSource().equals(shadesOfGrey)){
			listener.onShadesOfGreys();
		}else if(e.getSource().equals(importMenu )){
			listener.onImport();
		}else if(e.getSource().equals(exportMenu)){
			listener.onExport();
		}else if(e.getSource().equals(histogrammeMenu)){
			listener.onHistogramme();
		}else if(e.getSource().equals(ConversionMenu)){
			listener.onConversion();
		}else if(e.getSource().equals(stretchMenu)){
			listener.onStretch();
		}else if(e.getSource().equals(equalizeMenu)){
			listener.onEqualize();
		}else if(e.getSource().equals(pointMenu)){
			listener.onPoint();
		}else if(e.getSource().equals(rectangleMenu)){
			listener.onRectangle();
		}else if(e.getSource().equals(lineMenu)){
			listener.onLine();
		}else if(e.getSource().equals(squareMenu)){
			listener.onSquare();
		}else if(e.getSource().equals(triangleMenu)){
			listener.onTriangle();
		}else if(e.getSource().equals(quadrilateralMenu)){
			listener.onQuadrilateral();
		}else if(e.getSource().equals(polygonMenu)){
			listener.onPolygon();
		}else if(e.getSource().equals(ellipseMenu)){
			listener.onEllipse();
		}else if(e.getSource().equals( circleMenu)){
			listener.onCircle();
		}else if(e.getSource().equals(curveMenu)){
			listener.onCurve();
		}else if(e.getSource().equals(filtermoyenneurMenu)){
			listener.onFilterMoyenneur();
		}else if(e.getSource().equals(filtermedianMenu)){
			listener.onFilterMedian();
		}else if(e.getSource().equals(filtergaussienMenu)){
			listener.onFilterGaussien();
		}else if(e.getSource().equals( filterCannytMenu)){
			listener.onFilterCanny();
		}else if(e.getSource().equals(filterSobelMenu)){
			listener.onFilterSobel();
		}else if(e.getSource().equals(filterlaplacienMenu)){
			listener.onFilterLaplacien();
		}else if(e.getSource().equals(filterpriwittMenu)){
			listener.onFilterPriwitt();
		}else if(e.getSource().equals(assombrirMenu)){
			listener.onAssombrir();
		}else if(e.getSource().equals(brillanceMenu)){
			listener.onBrillance();
		}else if(e.getSource().equals(binarisationMenu)){
			listener.onBinariation();
		}else if(e.getSource().equals(aboutMenu)){
			listener.onAbout();
		}

	}
	
	
	/* POUR PARLER AVEC LE CONTROLLER*/	
	public ApplicationListener getListener(){
		return this.listener;
	}
	
	public void addListener(ApplicationListener listener){
		this.listener = listener;
		this.listener.onInit();
	}
	
	
	/************************************************************************************************************************************
	 * 									Functions general
	 */

	@Override
	public void onInit() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onOpenMenu() {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		
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

	public void importImages(imagesElements addImages) {
		cavenas.addElements(elements.getId(), new imagesElements());
		
	}
}
