import javax.swing.JPanel;
import java.awt.Frame;
import java.awt.BorderLayout;
import javax.swing.JDialog;
import javax.swing.JRadioButton;
import java.awt.Rectangle;
import javax.swing.JLabel;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JEditorPane;

public class Conversion extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JRadioButton jRadioButtonRGB = null;
	private JRadioButton jRadioButtonHSV = null;
	private JRadioButton jRadioButtonLab = null;
	private JRadioButton jRadioButtonCMY = null;
	private JLabel jLabelRGB = null;
	private JLabel jLabelHSV = null;
	private JLabel jLabelLab = null;
	private JLabel jLabelCMY = null;
	private JButton jButtonok = null;
	private JEditorPane jEditorPane = null;  //  @jve:decl-index=0:visual-constraint="544,222"

	/**
	 * @param owner
	 */
	public Conversion(JPanel panel) {
		super();
		initialize();
		add(panel);
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		//this.setSize(417, 322);
		
		this.setBounds(400, 200, 500,400 );
		this.setContentPane(getJContentPane());
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabelCMY = new JLabel();
			jLabelCMY.setBounds(new Rectangle(134, 110, 38, 16));
			jLabelCMY.setText("CMY");
			jLabelLab = new JLabel();
			jLabelLab.setBounds(new Rectangle(134, 138, 38, 16));
			jLabelLab.setText("Lab");
			jLabelHSV = new JLabel();
			jLabelHSV.setBounds(new Rectangle(52, 129, 33, 23));
			jLabelHSV.setText("HSV");
			jLabelRGB = new JLabel();
			jLabelRGB.setBounds(new Rectangle(49, 104, 33, 17));
			jLabelRGB.setText("RGB");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJRadioButtonRGB(), null);
			jContentPane.add(getJRadioButtonHSV(), null);
			jContentPane.add(getJRadioButtonLab(), null);
			jContentPane.add(getJRadioButtonCMY(), null);
			jContentPane.add(jLabelRGB, null);
			jContentPane.add(jLabelHSV, null);
			jContentPane.add(jLabelLab, null);
			jContentPane.add(jLabelCMY, null);
			jContentPane.add(getJButtonok(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jRadioButtonRGB	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButtonRGB() {
		if (jRadioButtonRGB == null) {
			jRadioButtonRGB = new JRadioButton();
			jRadioButtonRGB.setBounds(new Rectangle(5, 106, 21, 21));
		}
		return jRadioButtonRGB;
	}

	/**
	 * This method initializes jRadioButtonHSV	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButtonHSV() {
		if (jRadioButtonHSV == null) {
			jRadioButtonHSV = new JRadioButton();
			jRadioButtonHSV.setBounds(new Rectangle(5, 133, 29, 21));
		}
		return jRadioButtonHSV;
	}

	/**
	 * This method initializes jRadioButtonLab	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButtonLab() {
		if (jRadioButtonLab == null) {
			jRadioButtonLab = new JRadioButton();
			jRadioButtonLab.setBounds(new Rectangle(101, 106, 21, 21));
		}
		return jRadioButtonLab;
	}

	/**
	 * This method initializes jRadioButtonCMY	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButtonCMY() {
		if (jRadioButtonCMY == null) {
			jRadioButtonCMY = new JRadioButton();
			jRadioButtonCMY.setBounds(new Rectangle(100, 133, 21, 21));
		}
		return jRadioButtonCMY;
	}

	/**
	 * This method initializes jButtonok	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonok() {
		if (jButtonok == null) {
			jButtonok = new JButton();
			jButtonok.setBounds(new Rectangle(53, 171, 77, 30));
			jButtonok.setText("ok");
		}
		return jButtonok;
	}

	/**
	 * This method initializes jEditorPane	
	 * 	
	 * @return javax.swing.JEditorPane	
	 */
	private JEditorPane getJEditorPane() {
		if (jEditorPane == null) {
			jEditorPane = new JEditorPane();
		}
		return jEditorPane;
	}

}  //  @jve:decl-index=0:visual-constraint="15,39"
