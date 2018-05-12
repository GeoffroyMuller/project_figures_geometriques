import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;



public class Fenetre {

	public Fenetre() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args){
		JFrame f=new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		PanneauChoix pc = new PanneauChoix();
		VueDessin vd = new VueDessin();
		f.getContentPane().setLayout(new BorderLayout());
		f.getContentPane().add(pc, BorderLayout.NORTH);
		f.getContentPane().add(vd, BorderLayout.CENTER);
		f.setPreferredSize(new Dimension(700, 700));
		f.pack();
		f.setVisible(true);
	}

}
