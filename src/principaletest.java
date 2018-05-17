import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseListener;

import javax.swing.JFrame;


public class principaletest {

	public principaletest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame f=new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		PanneauChoix pc = new PanneauChoix();
		VueDessin vd = new VueDessin();
		DessinModel dm = new DessinModel();
		dm.construit(new FigureColoree() {
			
			@Override
			public int nbPoint() {
				// TODO Auto-generated method stub
				return 5;
			}
			
			@Override
			public int nbClics() {
				// TODO Auto-generated method stub
				return 5;
			}
			
			@Override
			public void modifierPoints(Point[] tp) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean estDedans(int a, int b) {
				// TODO Auto-generated method stub
				return false;
			}
		});
		vd.addMouseListener(dm.ff.ml);
		f.getContentPane().setLayout(new BorderLayout());
		f.getContentPane().add(pc, BorderLayout.NORTH);
		f.getContentPane().add(vd, BorderLayout.CENTER);
		f.setPreferredSize(new Dimension(700, 700));
		f.pack();
		f.setVisible(true);
	}

}
