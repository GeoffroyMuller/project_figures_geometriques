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
	ArrayList<Point> tabP = new ArrayList<Point>();
	MouseListener mlmf;
	MouseMotionListener mml;
	public ManipulateurFormes(DessinModel dme) {
		dm=dme;
		mlmf = new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				figureselec=dm.selectionner(e.getX(),e.getY());
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
				tabP.add(p);
				System.out.println("draggg");
				if(figureselec!=null) {
					System.out.println(figureselec);
					if(tabP.size()>2) {
						int tx,ty;
						System.out.println("translation");
						tx=tabP.get(tabP.size()-2).rendreX()-tabP.get(tabP.size()-1).rendreX();
						ty=tabP.get(tabP.size()-2).rendreY()-tabP.get(tabP.size()-1).rendreY();
						figureselec.translation(tx, ty);

					}
				}
				else {
					System.out.println("dragg mais pas de selection");
				}

				// TODO Auto-generated method stub

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
