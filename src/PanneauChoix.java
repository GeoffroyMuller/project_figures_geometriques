
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class PanneauChoix extends JPanel{
	private JRadioButton bnew = new JRadioButton("Nouvelle figure");
	private JRadioButton bmain = new JRadioButton("Trac�s � main lev�e");
	private JRadioButton bmanip = new JRadioButton("Manipulations");
	public PanneauChoix() {
		add(bnew);
		add(bmain);
		add(bmanip);
	}
}
