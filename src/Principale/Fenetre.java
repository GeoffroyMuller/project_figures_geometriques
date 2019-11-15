package Principale;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

import Controleur.PanneauChoix;
import Model.DessinModel;
import Vue.VueDessin;


public class Fenetre {

	public Fenetre() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame f=new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		DessinModel dm = new DessinModel();
		PanneauChoix pc = new PanneauChoix(dm);
		VueDessin vd = new VueDessin(dm);

		f.getContentPane().setLayout(new BorderLayout());
		f.getContentPane().add(pc, BorderLayout.NORTH);
		f.getContentPane().add(vd, BorderLayout.CENTER);
		f.setPreferredSize(new Dimension(700, 700));
		f.pack();
		f.setVisible(true);
		
	}

}