
import java.awt.*;
import java.util.*;

import javax.swing.*;



public class VueDessin extends JPanel implements Observer{
	private ArrayList<FigureColoree> lfi;
	private DessinModel dm;
	public VueDessin() {
		lfi = new ArrayList<FigureColoree>();
		dm = new DessinModel();
		setBackground(Color.white);
		dm.construit(new Quadrilatere());//a mettre dans panneau choix
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
		for (int i = 0; i < lfi.size(); i++) {
			lfi.get(i).affiche(g);
			System.out.println("afficher figure num :"+i);
		}

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
