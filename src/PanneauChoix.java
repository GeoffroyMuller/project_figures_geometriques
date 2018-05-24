
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class PanneauChoix extends JPanel{
	private JRadioButton rbnew = new JRadioButton("Nouvelle figure");
	private JRadioButton rbmain = new JRadioButton("Tracés à main levée");
	private JRadioButton rbmanip = new JRadioButton("Manipulations");
	private JComboBox cbfigue= new JComboBox(new String[]{"Rectangle","Triangle"});
	private JComboBox cbcolor= new JComboBox(new String[]{"Bleu","Rouge","Vert"});
	private DessinModel dm = new DessinModel();

	private ButtonGroup bg = new ButtonGroup();

	public PanneauChoix() {
		setLayout(new BorderLayout());
		JPanel rb = new JPanel();
		JPanel cb = new JPanel();
		bg.add(rbnew);
		bg.add(rbmain);
		bg.add(rbmanip);
		rb.add(rbnew);
		rb.add(rbmain);
		rb.add(rbmanip);
		cb.add(cbfigue);
		cb.add(cbcolor);
		rb.setBackground(new Color(70,97,110));
		cb.setBackground(new Color(47,66,75));
		add(rb, BorderLayout.NORTH);
		add(cb, BorderLayout.CENTER);
		cbfigue.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}                           

}
