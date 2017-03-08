import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.WindowConstants;






public class Accueil extends JFrame implements ActionListener, CavenasListener {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4648688787386404371L;

	public static Accueil ui;
	


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
	
	
	
	
	/*   MENU AND SUB MENU IMAGES*/
	private final JMenu imageMenu = new JMenu();
		private final JMenuItem importMenu = new JMenuItem();
	private final JMenuItem exportMenu = new JMenuItem();	
	private final JMenuItem  filterMenu = new JMenuItem();
	private final JMenuItem  tintMenu = new JMenuItem();
	
	
	/*        MENU AND SUB MENU FORM */
	private final JMenu formMenu = new JMenu();
	private final JMenu drawing2DMenu = new JMenu();
	private final JMenu drawing3DMenu = new JMenu();
	private final JMenuItem  pointMenu = new JMenuItem();
	private final JMenuItem  rectangleMenu = new JMenuItem();
	private final JMenuItem  lineMenu = new JMenuItem();
	private final JMenuItem  triangleMenu = new JMenuItem();
	private final JMenuItem  squareMenu = new JMenuItem();
	private final JMenuItem  quadrilateralMenu = new JMenuItem();
	private final JMenuItem  ellipseMenu = new JMenuItem();	
	private final JMenuItem  curveMenu = new JMenuItem();
	private final JMenuItem cubeMenu = new JMenuItem();
	private final JMenuItem tetrahedronMenu = new JMenuItem();
	private final JMenuItem dodecahedronMenu = new JMenuItem();
	
	
	/*     MENU AND SUB MENU OUTILS*/
	private final JMenu toolsMenu = new JMenu();
	private final JMenuItem strokeMenu = new JMenu();
	private final JMenuItem strokeColorMenu = new JMenuItem();
	private final JMenu strokeWeightMenu = new JMenu();
	private final JMenuItem oneStroke =new JMenuItem();
	private final JMenuItem twoStroke =new JMenuItem();
	private final JMenuItem treeStroke =new JMenuItem();
	private final JMenuItem fourStroke =new JMenuItem();
	private final JMenuItem noStroke =new JMenuItem();
	private final JMenuItem fillMenu = new JMenuItem();
	

	/*        MENU AND SUB MENU HELP*/
	private final JMenu helpMenu = new JMenu();
	private final JMenuItem aboutMenu = new JMenuItem();
	private final Canevas cavenas=new Canevas();	
	private   PanelImage panneau =null;
	
	/*        MENU CAMERA */
	private final JMenu cameraMenu = new JMenu();
	private final JMenuItem propertyMenu = new JMenuItem();
	private final JMenu modeProjectionMenu = new JMenu();
	private final JMenuItem perspectiveMenu = new JMenuItem();
	private final JMenuItem orthogonalMenu = new JMenuItem();
	
	
	

	

	private JPanel jTabbedPane=null;


	public Accueil() {
		super();
		setBounds(150, 100,1000,600);
		setTitle("SanKhrys application graphic ");
		jTabbedPane=new JPanel();
	
      
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
		
		createToolsMenu();
		createCameraMenu();
		createHelpMenu();
		
	}

	private void createCameraMenu() {
		
		menuBar.add(cameraMenu);
		cameraMenu.add(modeProjectionMenu);
		modeProjectionMenu.add(perspectiveMenu);
		modeProjectionMenu.add(orthogonalMenu);
		perspectiveMenu.setText("Perspective");
		perspectiveMenu.addActionListener(this);
		orthogonalMenu.setText("Orthogonale");
		orthogonalMenu.addActionListener(this);
	
		
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

	}


	private void createImageMenu(){
		menuBar.add(imageMenu);
		imageMenu.setText("Image");		
		

		
		imageMenu.add(importMenu);
		imageMenu.add(exportMenu);
		
		importMenu.addActionListener(this);
		importMenu.setText("Importer");
		exportMenu.addActionListener(this);
		exportMenu.setText("Exporter");
		
		imageMenu.addSeparator();

		
		

		imageMenu.add(filterMenu);
		filterMenu.setText("Filtre");
		filterMenu.addActionListener(this);
		imageMenu.addSeparator();

		imageMenu.add(tintMenu);
		tintMenu.addActionListener(this);
		tintMenu.setText("Teinte");
	}


	private void createFormMenu(){
		menuBar.add(formMenu);
		formMenu.setText("Formes");
		formMenu.add(drawing2DMenu);
		drawing2DMenu.setText("Dessins 2D");
		drawing3DMenu.setText("Dessins 3D");
		formMenu.add(drawing3DMenu);
		drawing2DMenu.add(pointMenu);
		pointMenu.addActionListener(this);
		pointMenu.setText("Point");
		drawing2DMenu.add(lineMenu);
		lineMenu.addActionListener(this);
		lineMenu.setText("Ligne");
		drawing2DMenu.add(rectangleMenu);
		rectangleMenu.addActionListener(this);
		rectangleMenu.setText("Rectangle");

		drawing2DMenu.add(triangleMenu);
		triangleMenu.addActionListener(this);
		triangleMenu.setText("Triangle");
		drawing2DMenu.add(squareMenu);
		squareMenu.addActionListener(this);
		squareMenu.setText("Carré");
		drawing2DMenu.add(quadrilateralMenu);
		quadrilateralMenu.addActionListener(this);
		quadrilateralMenu.setText("Qualidratère");		
		drawing2DMenu.add(ellipseMenu);
		ellipseMenu.addActionListener(this);
		ellipseMenu.setText("Ellipse");
		drawing2DMenu.add(curveMenu);
		curveMenu.addActionListener(this);
		curveMenu.setText("Arc");
		
		drawing3DMenu.add(cubeMenu);
		cubeMenu.setText("Cube");
		cubeMenu.addActionListener(this);
		drawing3DMenu.add(tetrahedronMenu);
		tetrahedronMenu.setText("Tetrahedron");
		tetrahedronMenu.addActionListener(this);
		drawing3DMenu.add(dodecahedronMenu);
		dodecahedronMenu.setText("Dodecahedron");
		dodecahedronMenu.addActionListener(this);
		

	}


	private void createToolsMenu(){
		menuBar.add(toolsMenu);
		toolsMenu.setText("Format");


		toolsMenu.add(fillMenu);
		fillMenu.addActionListener(this);
		fillMenu.setText("Remplissage");
		toolsMenu.addSeparator();

		toolsMenu.add(strokeMenu);
		strokeMenu.addActionListener(this);
		strokeMenu.setText("Contour");
		strokeMenu.add(strokeColorMenu);
		strokeColorMenu.setText("Couleur");
		strokeColorMenu.addActionListener(this);
		strokeMenu.add(strokeWeightMenu);
		strokeWeightMenu.setText("Epaisseur");
		
		;
		strokeWeightMenu.add(oneStroke);
		strokeWeightMenu.add(twoStroke);
		strokeWeightMenu.add(treeStroke);
		strokeWeightMenu.add(fourStroke);
		strokeWeightMenu.add(noStroke);
		oneStroke.addActionListener(this);
		twoStroke.addActionListener(this);
		treeStroke.addActionListener(this);
		fourStroke.addActionListener(this);
		noStroke.addActionListener(this);
		oneStroke.setText("1");
		twoStroke.setText("2");
		treeStroke.setText("3");
		fourStroke.setText("4");
		noStroke.setText("Sans contour");

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
		}else if(e.getSource().equals(importMenu )){
			listener.onImport();
		}else if(e.getSource().equals(exportMenu)){
			listener.onExport();
		}else if(e.getSource().equals(filterMenu)){
			listener.onFilter();
		}else if(e.getSource().equals(tintMenu)){
			listener.onTint();
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
		}else if(e.getSource().equals(ellipseMenu)){
			listener.onEllipse();
		}else if(e.getSource().equals(curveMenu)){
			listener.onCurve();
		}else if(e.getSource().equals(fillMenu)){
			listener.onFill();
		}else if(e.getSource().equals(aboutMenu)){
			listener.onAbout();
		}else if(e.getSource().equals(oneStroke)){
			listener.onOneStroke();
		}else if(e.getSource().equals(twoStroke)){
			listener.onTwoStroket();
		}else if(e.getSource().equals(treeStroke)){
			listener.onTreeStroke();
		}else if(e.getSource().equals(fourStroke)){
			listener.onFourStroke();
		}else if(e.getSource().equals(noStroke)){
			listener.onNoStroke();
		}else if(e.getSource().equals(cubeMenu)){
			listener.onCubeMenu();
		}else if(e.getSource().equals(tetrahedronMenu)){
			listener.onTetrahedronMenu();
		}else if(e.getSource().equals(dodecahedronMenu)){
			listener.onDodecahedronMenu();
		}else if(e.getSource().equals(perspectiveMenu)){
			listener.onPerspectiveMenu();
		}else if(e.getSource().equals(orthogonalMenu)){
			listener.onOrthogonalMenu();
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

}
