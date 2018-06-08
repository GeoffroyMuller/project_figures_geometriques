import java.awt.Graphics;
import java.awt.Polygon;
import java.util.*;

public abstract class Polygone extends FigureColoree{
	private Polygon p;
	public Polygone() {
		super();
	}

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
		System.out.println(tab_mem);
		g.fillPolygon(xPoints, yPoints, tab_mem.size());
	}

	public int nbClics(){
		return this.nbPoint();

	}

	public void modifierPoints(java.util.ArrayList<Point> ptab_mem) {
		this.tab_mem= ptab_mem;
	};
	@Override
	public abstract int nbPoint();

	@Override
	public boolean estDedans(int a, int b) {
		return this.p.contains(a,b);
	}

	public Polygon getP() {
		return p;
	}
	


}
