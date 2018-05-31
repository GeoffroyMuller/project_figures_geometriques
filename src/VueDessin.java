
import java.awt.*;
import java.util.*;

import javax.swing.*;





public class VueDessin extends JPanel implements Observer{
	private ArrayList<FigureColoree> lfi;
	private DessinModel dm;
	private FigureColoree figureEnCours;
	public VueDessin(DessinModel dme) {
		lfi = new ArrayList<FigureColoree>();
		dm = dme;
		setBackground(Color.white);
		//dm.construit(new Quadrilatere());
		dm.addObserver(this);
		//addMouseListener(dm.ff.getMl());
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
		int cas =(int)arg;

		switch(cas){
		case 0 :
			break;

		case 100 :
			removeMouseListener(dm.ff.getMl());
			System.out.println("remove listener");
			repaint();
			break;

		case 101:
			addMouseListener(dm.ff.getMl());
			System.out.println("ajout listener");
			break;

		case 201:
			addMouseListener(dm.mf.getMlmf());
			addMouseMotionListener(dm.mf.getMml());
			System.out.println("ajout des listenner de manipulation");
			break;
			
		case 200:
			removeMouseListener(dm.mf.getMlmf());
			removeMouseMotionListener(dm.mf.getMml());
			break;

		default:
			break;
		}

	}

}
