
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class PanneauChoix extends JPanel{
	private JRadioButton rbnew = new JRadioButton("Nouvelle figure");
	private JRadioButton rbmain = new JRadioButton("Trac�s � main lev�e");
	private JRadioButton rbmanip = new JRadioButton("Manipulations");
	private JComboBox cbfigue= new JComboBox(new String[]{"Rectangle","Triangle"});
	private JComboBox cbcolor= new JComboBox(new String[]{"Bleu","Rouge","Vert"});
	private DessinModel dm;

	private ButtonGroup bg = new ButtonGroup();

	public PanneauChoix(DessinModel dme) {
		dm = dme;
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
		ActionListener acl = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(rbnew.isSelected()){
					cbfigue.setEnabled(true);
					cbcolor.setEnabled(true);
					creeFigure();
					determineCouleur();
				}
				if(rbmain.isSelected()){
					cbfigue.setEnabled(false);
					cbcolor.setEnabled(true);
					determineCouleur();
				}
				if(rbmanip.isSelected()){
					cbfigue.setEnabled(false);
					cbcolor.setEnabled(false);
				}
			}
		};
		rbnew.addActionListener(acl);
		rbmain.addActionListener(acl);
		rbmanip.addActionListener(acl);
		cbcolor.addActionListener(acl);
		cbfigue.addActionListener(acl);
	}

	private void creeFigure(){
		switch(cbfigue.getSelectedIndex()){
		case 0 :
			System.out.println("Rectangle");
			dm.construit(new Quadrilatere());
			
			break;
		case 1 :
			System.out.println("Triangle");
			break;
		default :
			System.out.println("default");
		}
	}
	
	private void determineCouleur(){
		switch(cbcolor.getSelectedIndex()){
		case 0 :
			System.out.println("Bleu");
			break;
		case 1 :
			System.out.println("Rouge");
			break;
		case 2 :
			System.out.println("Vert");
			break;
		default :
			System.out.println("default");
		}
	}

	public DessinModel getDm() {
		return dm;
	}
	
	

}
