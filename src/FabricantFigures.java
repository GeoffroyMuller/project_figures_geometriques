import javax.swing.*;

import java.util.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class FabricantFigures {
	private int nbClics;
	private Point point;
	MouseListener ml;

	private ArrayList<Point> lp;
	public FabricantFigures(FigureColoree fc,DessinModel dm) {
		ml = new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

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
				nbClics++;
				
				point = new Point(e.getX(),e.getY());
				lp = new ArrayList<Point>();

				if(nbClics < fc.nbClics()){
					lp.add(point);
					System.out.println("addp"+nbClics);
				}else{
					if(nbClics == fc.nbClics()){
						lp.add(point);
						fc.modifierPoints(lp);//a changer
						dm.ajoute(fc);
						System.out.println("addp"+nbClics);
						System.out.println("insertion dans fc");
					}
				}
				System.out.println("clicked");
			}
		};
	}

	public MouseListener getMl() {
		return ml;
	}

	public ArrayList<Point> getLp() {
		return lp;
	}

	
	





}
