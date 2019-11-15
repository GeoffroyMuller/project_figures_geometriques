package Controleur;
import javax.swing.*;

import Model.DessinModel;
import Model.FigureColoree;
import Model.Point;

import java.util.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class FabricantFigures {
	private int nbClics;
	private Point point;
	MouseListener ml;

	private ArrayList<Point> lp= new ArrayList<Point>();
	
	/**
	 * Constructeur principal
	 * @param fc FigureColoree a fabriquer
	 * @param dm DessinModel auquel s'ajoute la FigureColoree
	 */
	public FabricantFigures(FigureColoree fc,DessinModel dm) {
		ml = new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				nbClics++;
				point = new Point(e.getX(),e.getY());

				if(nbClics < fc.nbClics()){
					lp.add(point);
					System.out.println("Click num: "+nbClics);
				}else{
					if(nbClics == fc.nbClics()){
						lp.add(point);
						fc.modifierPoints(lp);//a changer
						System.out.println("insertion de la figure");
						dm.ajoute(fc);

					}
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
	}
	
	/**
	 * get MouseListener Ml
	 * @return MouseListener Ml
	 */
	public MouseListener getMl() {
		return ml;
	}
	
	/**
	 * get ArrayList de Point
	 * @return ArrayList de Point
	 */
	public ArrayList<Point> getLp() {
		return lp;
	}








}
