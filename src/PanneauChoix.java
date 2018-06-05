
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.Delayed;

import javax.swing.*;

public class PanneauChoix extends JPanel{
	private JRadioButton rbnew = new JRadioButton("Nouvelle figure");
	private JRadioButton rbmain = new JRadioButton("Tracés à main levée");
	private JRadioButton rbmanip = new JRadioButton("Manipulations");
	private JComboBox cbfigue= new JComboBox(new String[]{"Quadrilatere","Triangle","Rectangle","Carre","Losange","Elipse"});
	private JComboBox cbcolor= new JComboBox(new String[]{"Bleu","Rouge","Vert"});
	private DessinModel dm;
	private Color c;
	private boolean rbnewact = false;//true si rbnew a ete selectionner au moin une foie
	private boolean rbmanipact = false;
	private boolean rbmainact = false;

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
					System.out.println("=====new figure=====");
					dm.deSelectionnerTout();
					cbfigue.setEnabled(true);
					cbcolor.setEnabled(true);
					creeFigure();
					determineCouleur();
					rbnewact = true;
					if(rbmanipact) {
						dm.finManipulation();
					}
					if(rbmainact){
						dm.finDessinMainLevee();
					}
					//rbnew.doClick();
				}
				if(rbmain.isSelected()){
					System.out.println("=====trait main=====");
					dm.deSelectionnerTout();
					cbfigue.setEnabled(false);
					cbcolor.setEnabled(true);
					creerTrait();
					determineCouleur();
					rbmainact=true;
					if(rbmanipact){
					dm.finManipulation();
					}
					if(rbnewact){
						
					dm.finCreation();
					}
				}
				if(rbmanip.isSelected()){
					System.out.println("=====manipulation=====");
					cbfigue.setEnabled(false);
					cbcolor.setEnabled(false);
					modifierFigure();
					rbmanipact = true;
					if(rbnewact) {
						dm.finCreation();
					}
					if(rbmainact){
						dm.finDessinMainLevee();
					}
				}
			}
		};
		rbnew.addActionListener(acl);
		rbmain.addActionListener(acl);
		rbmanip.addActionListener(acl);
		cbcolor.addActionListener(acl);
		cbfigue.addActionListener(acl);
	}
	
	private void creerTrait(){
		this.determineCouleur();
		System.out.println("//////new trait///////");
		Trait t = new Trait();
		t.changeCouleur(c);
		dm.construit(t);
	}

	private void creeFigure(){
		this.determineCouleur();
		switch(cbfigue.getSelectedIndex()){
		case 0 :
			System.out.println("Quadrilatere");
			Quadrilatere q =new Quadrilatere();
			q.changeCouleur(c);
			dm.construit(q);
			break;
		case 1 :
			System.out.println("Triangle");
			Triangle t =new Triangle();
			t.changeCouleur(c);
			dm.construit(t);
			break;

		case 2 :
			System.out.println("Rectangle");
			Rectangle r = new Rectangle();
			r.changeCouleur(c);
			dm.construit(r);
			break;
			
		case 3 :
			System.out.println("Carre");
			Carre car = new Carre();
			car.changeCouleur(c);
			dm.construit(car);
			break;
			
		case 4 : 
			System.out.println("Losange");
			Losange los = new Losange();
			los.changeCouleur(c);
			dm.construit(los);
			break;
			
		case 5 : 
			System.out.println("Elipse");
			Elipse eli= new Elipse();
			eli.changeCouleur(c);
			dm.construit(eli);
			break;
			
		default :
			System.out.println("default");
		}
		
		
	}
	


	public void modifierFigure(){
		this.determineCouleur();
		//ManipulateurFormes mpf = new ManipulateurFormes(this.dm);
		dm.manipuler();
	}

	private void determineCouleur(){
		switch(cbcolor.getSelectedIndex()){
		case 0 :
			System.out.println("Bleu");
			c=Color.blue;

			break;
		case 1 :
			System.out.println("Rouge");
			c=Color.red;
			break;
		case 2 :
			System.out.println("Vert");
			c=Color.green;
			break;
		default :
			System.out.println("default");
		}
	}

	public DessinModel getDm() {
		return dm;
	}



}
