import javax.swing.*;

import java.util.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class FabricantFigures {
	private int nbClics;
	private Point point;
	MouseListener ml;
	public FabricantFigures(FigureColoree fc) {
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
				ArrayList<Point> lp = new ArrayList<Point>();
				if(nbClics<=fc.nbClics()){
					lp.add(point);
					System.out.println("addp"+nbClics);
				}
				System.out.println("clicked");
			}
		};
	}
	
	
	

}
