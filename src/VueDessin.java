
import java.awt.*;
import java.util.*;

import javax.swing.*;



public class VueDessin extends JPanel implements Observer{
	private ArrayList<FigureColoree> lfi;
	private DessinModel dm;
	public VueDessin() {
		dm = new DessinModel();
		setBackground(Color.white);
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
			public boolean estDedans(int a, int b) {
				// TODO Auto-generated method stub
				return false;
			}
		});
		dm.addObserver(this);
		addMouseListener(dm.ff.getMl());
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.black);
		/*g.drawRect(10, 10, 10, 10);
		int [] xd = {10,20,30};
		int [] yd = {10,60,30};
		g.drawPolygon(xd, yd, 3);*/
		lfi.get(0).affiche(g);
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		DessinModel dm = (DessinModel)o;
		lfi = dm.getlfi();
		removeMouseListener(dm.ff.getMl());
		System.out.println("remove listener");
		repaint();
	}

	public DessinModel getDm() {
		return dm;
	}
	

}
