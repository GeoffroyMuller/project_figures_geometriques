import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseListener;

import javax.swing.JFrame;


public class Principaletest {

	public Principaletest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
