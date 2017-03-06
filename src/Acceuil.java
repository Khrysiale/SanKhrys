import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.WindowConstants;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;



public class Acceuil extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JMenuBar menuBar = new JMenuBar();
	private final JMenu fileMenu = new JMenu();
	private final JMenuItem openMenu = new JMenuItem();
	private final JMenuItem saveMenu = new JMenuItem();
	private final JMenuItem quitMenu = new JMenuItem();
	
	private final JMenu     EditMenu = new JMenu();
	private final JMenuItem ReturnMenu = new JMenuItem();
	private final JMenuItem enlargeMenu = new JMenuItem();
	private final JMenuItem reduceMenu = new JMenuItem();
	
	private final JMenu imageMenu = new JMenu();
	private final JMenuItem histogrammeMenu = new JMenuItem();
	private final JMenuItem ConversionMenu = new JMenuItem();
	private final JMenuItem  stretchMenu = new JMenuItem();
	private final JMenuItem  equalizeMenu = new JMenuItem();
	
	private final JMenu filterMenu = new JMenu();
	
	private final JMenuItem filtermoyenneurMenu = new JMenuItem();
	private final JMenuItem filtermedianMenu = new JMenuItem();
	private final JMenuItem filtergaussienMenu = new JMenuItem();
	private final JMenuItem filterCannytMenu = new JMenuItem();
	private final JMenuItem filterSobelMenu = new JMenuItem();
	private final JMenuItem filterlaplacienMenu = new JMenuItem();
	private final JMenuItem filterpriwittMenu = new JMenuItem();

	private final JMenu traitementMenu = new JMenu();
	private final JMenuItem niveauGrisMenu = new JMenuItem();
	private final JMenuItem assombrirMenu = new JMenuItem();
	private final JMenuItem brillanceMenu = new JMenuItem();
	private final JMenuItem binarisationMenu = new JMenuItem();
	

	
	private final JMenu aideMenu = new JMenu();
	private final JMenuItem aproposMenu = new JMenuItem();
	private final Welcome  panel=new Welcome();
	
	private   PanelImage panneau =null;
	

	

	private JTabbedPane jTabbedPane=null;


	public Acceuil() {
		super();
		setBounds(150, 100,1000,600);
		setTitle("Traitement d'image ");
		jTabbedPane=new JTabbedPane();
	
      
		jTabbedPane.add("Accueil",panel);	
		getContentPane().add(jTabbedPane);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		try {
			creerMenu();
			desactiveMenu();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		//
	}
	public void quitter(){
		setVisible(false);
	}
	private void creerMenu() throws Exception {

		// construction du menu
		setJMenuBar(menuBar);	
		menuBar.add(fileMenu);
		fileMenu.setText("Fichier");
		fileMenu.add(openMenu);
		openMenu.addActionListener((ActionListener)this);
		openMenu.setText("Ouvrir");
		fileMenu.addSeparator();

		fileMenu.add(saveMenu);
		saveMenu.addActionListener((ActionListener)this);
		saveMenu.setText("Enregistrer Sous");
		fileMenu.addSeparator();
		
		fileMenu.add(quitMenu);
		quitMenu.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				quitter();
				
			}
		});
		quitMenu.setText("Quitter");
		
		menuBar.add(EditMenu);
		EditMenu.setText("Edition");
		EditMenu.add(ReturnMenu);
		ReturnMenu.setText("Retour");
		ReturnMenu.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				panneau.Retour();
			}
		});
		EditMenu.addSeparator();
		
		EditMenu.add(enlargeMenu);
		enlargeMenu.addActionListener((ActionListener)this);
		enlargeMenu.setText("Agrandir");
		EditMenu.add(reduceMenu);
		reduceMenu.addActionListener((ActionListener)this);
		reduceMenu.setText("Réduire");
		imageMenu.addSeparator();
		
		menuBar.add(imageMenu);
		imageMenu.setText("Image");
		
		
		
		
		
		
		imageMenu.add(niveauGrisMenu);
		niveauGrisMenu.addActionListener((ActionListener)this);
		niveauGrisMenu.setText("Niveau de Gris");
		imageMenu.addSeparator();
		
		imageMenu.add(ConversionMenu);
		ConversionMenu.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				panneau.setSize(600, 600);
				Convesrsion f =new Convesrsion(panneau);
				f.setVisible(true);
			}
		});
		ConversionMenu.setText("Convesion");
	    imageMenu.add(histogrammeMenu);
	    histogrammeMenu.setText("Histogramme");
	    histogrammeMenu.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				panneau.afficheHistograme();
				
			}
		});
		imageMenu.addSeparator();
		
		imageMenu.add(stretchMenu);
		stretchMenu.setText("Etirer");
		imageMenu.addSeparator();
	    
		imageMenu.add(equalizeMenu);
		equalizeMenu.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
		});
		equalizeMenu.setText("Egaliser");
		
		menuBar.add(filterMenu);	
		filterMenu.setText("Filtre");
		
		filterMenu.add(filtermoyenneurMenu);
		filtermoyenneurMenu.setText("Filtre Moyenneur");
		filtermoyenneurMenu.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
			panneau.filterMoyenneur();
			}
		});
		
		

		filterMenu.add(filtergaussienMenu);
		filtergaussienMenu.setText("Filtre Gaussien");
		filtermedianMenu.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
			//
			}
		});
	
		
		
		filterMenu.add(filtermedianMenu);
		filtermedianMenu.setText("Filtre Médian");
		filtermedianMenu.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
			//panneau.filterMoyenneur();
			}
		});
		filterMenu.addSeparator();
		
		
		filterMenu.add(filterSobelMenu);
		filterSobelMenu.setText("Filtre Sobel");
		filterSobelMenu.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
			panneau.filterSobbel();
			}
		});
		
		
		filterMenu.add(filterpriwittMenu);
		filterpriwittMenu.setText("Filtre Priwitt");
		filterpriwittMenu.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
			panneau.filterPrwitt();
			}
		});
	
		
		filterMenu.add(filterlaplacienMenu);
		filterlaplacienMenu.setText("Filtre Laplacien");
		filterlaplacienMenu.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
			panneau.filterLaplacien();
			}
		});
	
		
		
		filterMenu.add(filterCannytMenu);
		filterCannytMenu.setText("Filtre Canny");
		filterCannytMenu.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
			panneau.filterCanny();
			}
		});
		
		
        menuBar.add(traitementMenu);
        traitementMenu.setText("Traitement");
		

		traitementMenu.add(binarisationMenu);
		binarisationMenu.addActionListener((ActionListener)this);
		binarisationMenu.setText("Binarisation");
		traitementMenu.addSeparator();

		traitementMenu.add(assombrirMenu);
		assombrirMenu.addActionListener((ActionListener)this);
		assombrirMenu.setText("Assombrir");
		traitementMenu.addSeparator();

	    traitementMenu.add(brillanceMenu);
		brillanceMenu.addActionListener((ActionListener)this);
		brillanceMenu.setText("Brillance");
		
		
        menuBar.add(aideMenu);
        aideMenu.setText("Aide");
        aideMenu.add(aproposMenu);
        aproposMenu.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				String txt="Projet de Traitement d'image en Java oubrou abderrahmane";
				JOptionPane.showMessageDialog(null,txt);
				
			}
		});
        aproposMenu.setText("A propos");
		

		// ajouter le panneau de dessin 
        
		
	}  
	private  void  desactiveMenu(){
		saveMenu.setEnabled(false);
		ReturnMenu.setEnabled(false);
		histogrammeMenu.setEnabled(false);
	    ConversionMenu .setEnabled(false);
		stretchMenu.setEnabled(false);
	    equalizeMenu.setEnabled(false);
	    filtermoyenneurMenu.setEnabled(false);
		filtermedianMenu.setEnabled(false);
	    filtergaussienMenu.setEnabled(false);
		filterCannytMenu.setEnabled(false);
		 filterSobelMenu.setEnabled(false);
		filterlaplacienMenu.setEnabled(false);
	    filterpriwittMenu.setEnabled(false);

	    niveauGrisMenu.setEnabled(false);
		assombrirMenu.setEnabled(false);
		 brillanceMenu.setEnabled(false);
		binarisationMenu.setEnabled(false);
		
		 enlargeMenu.setEnabled(false);
		 reduceMenu.setEnabled(false);
		
		
	}
	private  void  activeMenu(){
		saveMenu.setEnabled(true);
		ReturnMenu.setEnabled(true);
		histogrammeMenu.setEnabled(true);
	    ConversionMenu .setEnabled(true);
		stretchMenu.setEnabled(true);
	    equalizeMenu.setEnabled(true);
	    filtermoyenneurMenu.setEnabled(true);
		filtermedianMenu.setEnabled(true);
	    filtergaussienMenu.setEnabled(true);
		filterCannytMenu.setEnabled(true);
		filterSobelMenu.setEnabled(true);
		filterlaplacienMenu.setEnabled(true);
	    filterpriwittMenu.setEnabled(true);

	    niveauGrisMenu.setEnabled(true);
		assombrirMenu.setEnabled(true);
		 brillanceMenu.setEnabled(true);
		binarisationMenu.setEnabled(true);
		
		 enlargeMenu.setEnabled(true);
		 reduceMenu.setEnabled(true);
		
		
	}
	
	public void actionPerformed(ActionEvent cliqueMenu) {
		if (cliqueMenu.getSource().equals(openMenu))
		{
			JFileChooser fileOuvrirImage = new JFileChooser();
			fileOuvrirImage.setAcceptAllFileFilterUsed(false);
			String exetension[]={"bmp", "gif", "jpg", "jpeg", "png"};
			FileFilter imagesFilter = new FileNameExtensionFilter("bmp,gif,jpg,jpeg, png",exetension);
            fileOuvrirImage.addChoosableFileFilter(imagesFilter);
	        
			if (fileOuvrirImage.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
				   panneau = new PanelImage();
				   panneau.ajouterImage(new File(fileOuvrirImage.getSelectedFile()
					 		.getAbsolutePath()));
				   jTabbedPane.add(panneau.nomImage,panneau);
				   jTabbedPane.setSelectedComponent(panneau);
				   getContentPane().add(jTabbedPane);
				   activeMenu();
				
				
			}
		} else if (cliqueMenu.getSource().equals(saveMenu)) {
			JFileChooser fileEnregistrerImage = new JFileChooser();
			if (fileEnregistrerImage.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
				File fichierEnregistrement = new File(fileEnregistrerImage.getSelectedFile().getAbsolutePath()+ ".JPG");
				panneau.enregistrerImage(fichierEnregistrement);
			}
			
		} else
			if (cliqueMenu.getSource().equals(niveauGrisMenu)) {
				
				panneau.imageEnNiveauGris();
			} else if (cliqueMenu.getSource().equals(brillanceMenu)) {
				panneau.imageEclaircie();
			} else if (cliqueMenu.getSource().equals(binarisationMenu)) {
				panneau.imageBinaire();
			}  else if (cliqueMenu.getSource().equals(enlargeMenu)) {
				panneau.agrandirImage();
			} else if (cliqueMenu.getSource().equals(reduceMenu)) {
				panneau.reduireImage();
			}else if(cliqueMenu.getSource().equals(assombrirMenu)){
				panneau.imageSombre();	
			}
	}

	public static void main(String args[]) 
	{
		try {
			Acceuil frame = new Acceuil();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
