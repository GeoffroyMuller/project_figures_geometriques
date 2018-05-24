import java.awt.Graphics;
import java.util.*;

public abstract class Polygone extends FigureColoree{
	private Polygone p;
	public Polygone() {
		super();
	}
	
	public void affiche(Graphics g){
		super.affiche(g);
		
		int[] xPoints = new int[tab_mem.size()];
		int[] yPoints = new int[tab_mem.size()];
		for(int i=0;i<tab_mem.size();i++){
			xPoints[i]=tab_mem.get(i).rendreX();
			yPoints[i]=tab_mem.get(i).rendreY();
		}
		System.out.println(tab_mem);
		g.drawPolygon(xPoints, yPoints, tab_mem.size());
	}
	
	public int nbClics(){
		return this.nbPoint();
	}
	
	public void modifierPoints(java.util.ArrayList<Point> tab_mem) {
		this.tab_mem= tab_mem;
	};
	@Override
	public abstract int nbPoint();

	@Override
	public boolean estDedans(int a, int b) {
		return false;
	}

}
