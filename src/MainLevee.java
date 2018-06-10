import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.SwingUtilities;
public class MainLevee {
	MouseListener mlml;
	MouseMotionListener mml;
	private ArrayList<Point> lp= new ArrayList<Point>();


	/**
	 * construction du controlleur mainLevee
	 * @param fc figure coloré du controlleur
	 * @param dm Dessin model du controleur
	 */
	public MainLevee(FigureColoree fc, DessinModel dm){
		mml=new MouseMotionListener(){




			@Override
			public void mouseDragged(MouseEvent e){	
					Point p= new Point(e.getX(),e.getY());
					lp.add(p);
					fc.modifierPoints(lp);
					dm.rafraichir();
					
			}
			@Override
			public void mouseMoved(MouseEvent e){

			}

		};

		 mlml = new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				//dm.ajoute(fc);
				//lp.clear();
				dm.initNouveauTrait(fc);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Point p = new Point(e.getX(),e.getY());
				lp.add(p);
				dm.ajoute(fc);
				//System.out.println("envent listener mouse clicked");

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		};


	}


	public MouseListener getMlml() {
		return mlml;
	}


	public MouseMotionListener getMml() {
		return mml;
	}

	
}




