// Etape 1 :
// Importation des packages Java 2
/*import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Frame;

import javax.swing.Box;

// Etape 2 :
// Importation des packages Java 3D
import com.sun.j3d.utils.applet.MainFrame;
import com.sun.j3d.utils.geometry.*;
import com.sun.j3d.utils.universe.*;

/*public class Box3D extends Applet {

  public Box3D() {
    this.setLayout(new BorderLayout());

    // Etape 3 :
    // Creation du Canvas 3D
    Canvas3D canvas3D = new Canvas3D(SimpleUniverse.getPreferredConfiguration());
    this.add(canvas3D, BorderLayout.CENTER);

    // Etape 4 :
    // Creation d'un objet SimpleUniverse
    SimpleUniverse simpleU = new SimpleUniverse(canvas3D);

    // Etape 5 :
    // Positionnement du point d'observation pour avoir une vue correcte de la
    // scene 3D
    simpleU.getViewingPlatform().setNominalViewingTransform();

    // Etape 6 :
    // Creation de la scene 3D qui contient tous les objets 3D que l'on veut visualiser
    BranchGroup scene = createSceneGraph();

    // Etape 7 :
    // Compilation de la scene 3D
    scene.compile();

    // Etape 8:
    // Attachement de la scene 3D a l'objet SimpleUniverse
    simpleU.addBranchGraph(scene);
  }

  /**
   * Creation de la scene 3D qui contient tous les objets 3D
   * @return scene 3D
   */
 /* public BranchGroup createSceneGraph() {
    // Creation de l'objet parent qui contiendra tous les autres objets 3D
    BranchGroup parent = new BranchGroup();

    /************ Partie de code concernant l'animation du cube *************/
    /* Elle sera expliquee en details dans les chapitres relatifs aux
       transformations geometriques et aux animations */
    /*TransformGroup objSpin = new TransformGroup();
    objSpin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
    Alpha rotationAlpha = new Alpha(-1, 4000);
    RotationInterpolator rotator =
    new RotationInterpolator(rotationAlpha, objSpin);
    BoundingSphere bounds = new BoundingSphere();
    rotator.setSchedulingBounds(bounds);
    objSpin.addChild(rotator);
    /*************** Fin de la partie relative a l'animation ***************/

    // Arriere plan en blanc
   /* Background background = new Background(1, 1, 1);
    background.setApplicationBounds(new BoundingBox());
    parent.addChild(background);

     // Construction du parallelepipede
    objSpin.addChild(new Box(0.5f, 0.5f, 0.2f, null));
    parent.addChild(objSpin);

    return parent;
  }

  /**
   * Etape 9 :
   * Methode main() nous permettant d'utiliser cette classe comme une applet
   * ou une application.
   * @param args
   */
 /* public static void main(String[] args) {
    Frame frame = new MainFrame(new Box3D(), 256, 256);
  }
}*/