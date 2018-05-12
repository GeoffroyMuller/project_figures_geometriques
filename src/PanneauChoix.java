
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class PanneauChoix extends JPanel{
	private JRadioButton rbnew = new JRadioButton("Nouvelle figure");
	private JRadioButton rbmain = new JRadioButton("Tracés à main levée");
	private JRadioButton rbmanip = new JRadioButton("Manipulations");
	private JComboBox cbfigue= new JComboBox();
	private JComboBox cbcolor= new JComboBox();
	
	public PanneauChoix() {
		setLayout(new BorderLayout());
		JPanel rb = new JPanel();
		JPanel cb = new JPanel();
		rb.add(rbnew);
		rb.add(rbmain);
		rb.add(rbmanip);
		cb.add(cbfigue);
		cb.add(cbcolor);
		rb.setBackground(new Color(70,97,110));
		cb.setBackground(new Color(47,66,75));
		add(rb, BorderLayout.NORTH);
		add(cb, BorderLayout.CENTER);
	}
	
}
