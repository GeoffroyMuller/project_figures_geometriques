import javax.swing.*;

import java.util.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class FabricantFigures {
	private int nbClics;
	private Point point;
	MouseListener ml;

	private ArrayList<Point> lp= new ArrayList<Point>();
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
				System.out.println("clicked");
				point = new Point(e.getX(),e.getY());

				if(nbClics < fc.nbClics()){
					lp.add(point);
					System.out.println("addp"+nbClics);
				}else{
					if(nbClics == fc.nbClics()){
						lp.add(point);
						fc.modifierPoints(lp);//a changer
						System.out.println("addpFinal"+nbClics);
						System.out.println("insertion dans fc");
						dm.ajoute(fc);

					}
				}
				
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
