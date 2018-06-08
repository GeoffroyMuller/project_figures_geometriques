import javax.swing.*;

import java.util.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
public class ManipulateurFormes {
	private ArrayList<FigureColoree> lfip;
	private DessinModel dm;
	private  FigureColoree figureselec;
	private boolean surCarreDeSelection;
	private Point pointDeSelection;
	ArrayList<Point> tabP = new ArrayList<Point>();
	MouseListener mlmf;
	MouseMotionListener mml;
	public ManipulateurFormes(DessinModel dme) {
		dm=dme;
		mlmf = new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				tabP = new ArrayList<Point>();

			}

			@Override
			public void mousePressed(MouseEvent e) {
				if(figureselec!=null) {
					if(figureselec.estSurCarreSelection(e.getX(), e.getY())) {
						System.out.println("sur carre de selection"+figureselec);
						surCarreDeSelection=true;
						pointDeSelection=figureselec.pointDeSelection(e.getX(), e.getY());
					}
					else {
						figureselec=dm.selectionner(e.getX(),e.getY());
						surCarreDeSelection=false;
					}
				}
				else {
					figureselec=dm.selectionner(e.getX(),e.getY());
					surCarreDeSelection=false;
				}

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

			}
		};
		mml = new MouseMotionListener() {

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseDragged(MouseEvent e) {
				Point p = new Point(e.getX(),e.getY());
				if(surCarreDeSelection) {
					if(figureselec!=null) {
						tabP.add(p);
						dm.deformer(tabP, figureselec, pointDeSelection);
					}
				}
				else {
					if(figureselec!=null) {
						tabP.add(p);
					}
					System.out.println("draggg");
					dm.translater(tabP, figureselec);

					// TODO Auto-generated method stub

				}
			}
		};
	}

	public DessinModel getDm() {
		return dm;
	}

	public MouseListener getMlmf() {
		return mlmf;
	}

	public MouseMotionListener getMml() {
		return mml;
	}



}
