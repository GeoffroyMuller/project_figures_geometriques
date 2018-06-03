
import java.awt.*;
import java.util.*;

import javax.swing.*;





public class VueDessin extends JPanel implements Observer{

	/*
	 * mettre des concstante avec des nom
	 * 0 pas de changement
	 *
	 *
	 *
	 * liste des param de update 
	 * 100 :  remove FrabricantFigure
	 * 101 : add ManipulateurForme 
	 * 
	 * 200 : add FrabricantFigure
	 * 201 : remove ManipulateurForme
	 * 
	 * 
	 */
	public static final int SUP_FF = 100;
	public static final int ADD_FF = 101;
	public static final int NO_CHANGE = 0;
	public static final int SUP_MF = 200;
	public static final int ADD_MF = 201;


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
		case NO_CHANGE :
			break;

		case SUP_FF :
			removeMouseListener(dm.ff.getMl());
			System.out.println("remove listener ff");
			repaint();
			break;

		case ADD_FF:
			addMouseListener(dm.ff.getMl());
			System.out.println("ajout listener ff");
			break;

		case ADD_MF:
			addMouseListener(dm.mf.getMlmf());
			addMouseMotionListener(dm.mf.getMml());
			System.out.println("ajout des listenner de manipulation");
			break;

		case SUP_MF:
			removeMouseListener(dm.mf.getMlmf());
			removeMouseMotionListener(dm.mf.getMml());
			System.out.println("remove des listenner de manipulation");
			
			break;

		default:
			break;
		}
		repaint();

	}

}
