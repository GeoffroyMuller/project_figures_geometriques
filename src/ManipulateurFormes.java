import javax.swing.*;

import java.util.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
public class ManipulateurFormes {
	private ArrayList<FigureColoree> lfip;
	private DessinModel dm;
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
				// TODO Auto-generated method stub
				boolean res =false;//dm.getlfi().get(0).estDedans(e.getX(), e.getY());;
				int i=0;
				while(res==false && i < dm.getlfi().size()){
				res = dm.getlfi().get(i).estDedans(e.getX(), e.getY());
				if(!res){
					i++;
				}
				}
				
				if(res){
					System.out.println("selection:"+dm.getlfi().get(i));
				}
				else{
					System.out.println("pas de selection");
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
				System.out.println("draggg");
				
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
