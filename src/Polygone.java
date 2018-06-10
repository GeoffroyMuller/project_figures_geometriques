import java.awt.Graphics;
import java.awt.Polygon;
import java.util.*;

public abstract class Polygone extends FigureColoree{
	private Polygon p;
	public Polygone() {
		super();
	}
	/**
	 * affichage de base pour les polygone
	 */
	public void affiche(Graphics g){
		super.affiche(g);
		System.out.println("affiche poly");
		int[] xPoints = new int[tab_mem.size()];
		int[] yPoints = new int[tab_mem.size()];
		for(int i=0;i<tab_mem.size();i++){
			xPoints[i]=tab_mem.get(i).rendreX();
			yPoints[i]=tab_mem.get(i).rendreY();
		}
		p = new Polygon(xPoints, yPoints, tab_mem.size());
		//System.out.println(tab_mem);
		g.fillPolygon(xPoints, yPoints, tab_mem.size());
	}

	/**
	 * @return int qui correspond au nombres de Clics
	 */
	public int nbClics(){
		return this.nbPoint();

	}
	
	/**
	 * permet de modifier les Points d'une liste de Point donnee en parametre
	 * @param ptab_mem Arraylist de Point aui viens re;plqcer lq liste de point qctuelle de le figure
	 */
	public void modifierPoints(java.util.ArrayList<Point> ptab_mem) {
		this.tab_mem= ptab_mem;
	};
	@Override
	public abstract int nbPoint();
	
	
	/**
	 * methode permettant de savoir si les coordonnés passées en paramètre sont dans une figure
	 * à l'aide de la méthode contains de Polygon
	 * @param a : coord en x
	 * @param b : coord en y
	 * @return true si les coordonné sont à l'interieur d'une figure
	 */
	@Override
	public boolean estDedans(int a, int b) {
		return this.p.contains(a,b);
	}

	public Polygon getP() {
		return p;
	}
	


}
