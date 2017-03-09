/*cette classe affiche le menu et appelle les classe lors des évènements*/


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;


public class Home extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 4648688787386404371L;
	public static Home ui;
	
	private ActionListener listener;
	private List<Drawable> object = new ArrayList<>();
	private long id = 0;
	
	Dimension size ;
	

	
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
		
	
	
	/*        MENU CAMERA */
	private final JMenu cameraMenu = new JMenu();
	private final JMenuItem propertyMenu = new JMenuItem();
	private final JMenu modeProjectionMenu = new JMenu();
	private final JMenuItem perspectiveMenu = new JMenuItem();
	private final JMenuItem orthogonalMenu = new JMenuItem();

	private JPanel jTabbedPane=null;
	
	MyDrawing drawPanel = new MyDrawing();
	

	/*    Constructor of Home class   */
	public Home() {
		super();
		setBounds(150, 100,1000,600);
		setTitle("SanKhrys application graphic ");
		jTabbedPane=new JPanel();
		jTabbedPane.add("Sans titre",drawPanel); 
		     
		size = getSize();
		getContentPane().add(drawPanel);
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
		saveAsMenu.addActionListener(this);
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


	/* LISTENER DES JMENUITEM*/
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(openMenu))	{
			onOpenMenu();
		}else if(e.getSource().equals(newFileMenu)){
			onNewFileMenu();			
		}else if(e.getSource().equals(saveMenu )){
			onSaveMenu();			
		}else if(e.getSource().equals(saveAsMenu)){
			onSaveAsMenu();
		}else if(e.getSource().equals(quitMenu)){
			onQuitMenu();			
		}else if(e.getSource().equals(undoMenu)){
			onUndoMenu();			
		}else if(e.getSource().equals(redoMenu)){
			onRedoMenu();			
		}else if(e.getSource().equals(importMenu )){
			
			
			//listener.onImport();
			
			
		}else if(e.getSource().equals(exportMenu)){
			onExport();
		}else if(e.getSource().equals(filterMenu)){
			onFilter();
		}else if(e.getSource().equals(tintMenu)){
			onTint();
		}else if(e.getSource().equals(pointMenu)){
			onPoint(size.getWidth()/4, size.getHeight()/4);
		}else if(e.getSource().equals(rectangleMenu)){
			onRectangle();
		}else if(e.getSource().equals(lineMenu)){
			onLine();
		}else if(e.getSource().equals(squareMenu)){
			onSquare();
		}else if(e.getSource().equals(triangleMenu)){
			onTriangle();
		}else if(e.getSource().equals(quadrilateralMenu)){
			onQuadrilateral();
		}else if(e.getSource().equals(ellipseMenu)){
			onEllipse();
		}else if(e.getSource().equals(curveMenu)){
			onCurve();
		}else if(e.getSource().equals(fillMenu)){
			onFill();
		}else if(e.getSource().equals(aboutMenu)){
			onAbout();
		}else if(e.getSource().equals(oneStroke)){
			onOneStroke();
		}else if(e.getSource().equals(twoStroke)){
			onTwoStroket();
		}else if(e.getSource().equals(treeStroke)){
			onTreeStroke();
		}else if(e.getSource().equals(fourStroke)){
			onFourStroke();
		}else if(e.getSource().equals(noStroke)){
			onNoStroke();
		}else if(e.getSource().equals(cubeMenu)){
			onCubeMenu();
		}else if(e.getSource().equals(tetrahedronMenu)){
			onTetrahedronMenu();
		}else if(e.getSource().equals(dodecahedronMenu)){
			onDodecahedronMenu();
		}else if(e.getSource().equals(perspectiveMenu)){
			onPerspectiveMenu();
		}else if(e.getSource().equals(orthogonalMenu)){
			onOrthogonalMenu();
		}
		
	}
	public void askSave() {
		int answer = showChoiceDialog("Voulez-vous sauvegarder?", "oui","non");
		if( answer == 0){
			onSaveAsMenu();
		}	
		System.exit(0);
	}
	
	public int showChoiceDialog(String text, String choice1, String choice2){
		Object[] options = {choice1,choice2};
		int choice = JOptionPane.showOptionDialog(this, text,null, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,options,options[0]);
        if(choice == 0){
        	return 0;
        }
        else return 1;
	}
	
	public void showMessageDialog(String text, String buttonText){
		 int dialogButton = JOptionPane.OK_OPTION;
        JOptionPane.showMessageDialog (null, text,"Information",0);

        if(dialogButton == JOptionPane.OK_OPTION){ //The ISSUE is here
        }
	}
	
	

	private void onNewFileMenu() {
		// TODO Auto-generated method stub
		
	}

	private void onOpenMenu() {
		// TODO Auto-generated method stub
		
	}

	private void onSaveMenu() {
		
		
	}

	private void onQuitMenu() {
		// TODO Auto-generated method stub
		
	}

	private void onSaveAsMenu() {
		String PathToSave = null;
		
		JFileChooser fc = new JFileChooser();
		fc.setCurrentDirectory(new File(System.getProperty("user.home")));
		int response = fc.showSaveDialog(null);
		if(response == JFileChooser.APPROVE_OPTION){
			PathToSave = fc.getSelectedFile().toString();
			if (!PathToSave.isEmpty())
			{
				onSaveAs(PathToSave);
			}
		}
		else {
			showMessageDialog("Sauvegarde annuler", "Ok");
		}		
		
	}

	private void onSaveAs(String pathToSave) {
		try {
			File f = new File(pathToSave+".ser");
			System.out.println();
			if(f.exists()){
				int answer = ui.showChoiceDialog(pathToSave+".ser exite déjà, voulez-vous l'écraser?","Oui", "Non");
				if( answer == 0){
					performSerialization(jTabbedPane, pathToSave);
				}
			}
			if (!f.exists()) {
				performSerialization(jTabbedPane, pathToSave);
			}			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	private  static void performSerialization(JPanel jTabbedPane2, String pathToSave) throws IOException {
		FileOutputStream fos=new FileOutputStream(new File(pathToSave+".ser")) ;
        ObjectOutputStream out=new ObjectOutputStream(fos);
        out.writeObject(jTabbedPane2);
        out.close();
		
	}

	private void onUndoMenu() {
		// TODO Auto-generated method stub
		
	}

	private void onRedoMenu() {
		// TODO Auto-generated method stub
		
	}

	private void onOrthogonalMenu() {
		// TODO Auto-generated method stub
		
	}

	private void onPerspectiveMenu() {
		// TODO Auto-generated method stub
		
	}

	private void onDodecahedronMenu() {
		// TODO Auto-generated method stub
		
	}

	private void onTetrahedronMenu() {
		// TODO Auto-generated method stub
		
	}

	private void onCubeMenu() {
		// TODO Auto-generated method stub
		
	}

	private void onNoStroke() {
		// TODO Auto-generated method stub
		
	}

	private void onFourStroke() {
		// TODO Auto-generated method stub
		
	}

	private void onTreeStroke() {
		// TODO Auto-generated method stub
		
	}

	private void onTwoStroket() {
		// TODO Auto-generated method stub
		
	}

	private void onOneStroke() {
		// TODO Auto-generated method stub
		
	}

	private void onAbout() {
		// TODO Auto-generated method stub
		
	}

	private void onFill() {
		// TODO Auto-generated method stub
		
	}

	private void onCurve() {
		// TODO Auto-generated method stub
		
	}

	private void onEllipse() {
		// TODO Auto-generated method stub
		
	}

	private void onQuadrilateral() {
		// TODO Auto-generated method stub
		
	}

	private void onTriangle() {
		// TODO Auto-generated method stub
		
	}

	private void onSquare() {
		// TODO Auto-generated method stub
		
	}

	private void onLine() {
		// TODO Auto-generated method stub
		
	}

	private void onRectangle() {
		// TODO Auto-generated method stub
		
	}

	private void onPoint(double x, double y) {
		
		PointElement point = new PointElement(getCurrentId(),x,y);
		object.add(point);
		
	}

	private long getCurrentId() {
		id++;
		return id;
	}

	private void onTint() {
		// TODO Auto-generated method stub
		
	}

	private void onFilter() {
		// TODO Auto-generated method stub
		
	}

	private void onExport() {
		// TODO Auto-generated method stub
		
	}

	/* POUR PARLER AVEC LE CONTROLLER*/	
	public ActionListener getListener(){
		return this.listener;
	}
	
	public void addListener(ActionListener listener){
		this.listener = listener;
		
	}

		
	
	/************************************************************************************************************************************
	 * 									Functions general
	 */
	
	class MyDrawing extends JPanel{
		/**
		 * 
		 */
		private static final long serialVersionUID = -7607914951091976874L;

		/* Faire dessiner le tableau de composant ici*/
		public void paintComponent(Graphics g) {
			for (Drawable d : object){
		        d.draw(g);
		    }
		}
	}
	public void paintComponent(Graphics g) {
		Graphics2D graphics2d = (Graphics2D)g;
	}

}
