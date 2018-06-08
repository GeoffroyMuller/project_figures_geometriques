import java.awt.Graphics;
import java.util.ArrayList;


public class Rectangle extends Quadrilatere
{
	public Rectangle(){
		super();
	}

	@Override
	public int nbClics() {
		return 2;
	}
	
	public void modifierPoints(ArrayList<Point> ptab_mem){
		this.tab_mem= ptab_mem;
		Point p1 = new Point(tab_mem.get(1).rendreX(),tab_mem.get(0).rendreY());
		Point p2 = new Point(tab_mem.get(0).rendreX(),tab_mem.get(1).rendreY());
		tab_mem.add(1,p1);
		tab_mem.add(p2);

	}
	

	
	public void deformation(int tx,int ty,Point p) {
		super.deformation(tx, ty, p);
		ArrayList<Point> ptab_mem = new ArrayList<Point>();
		if(p.distance(tab_mem.get(1))<TAILLE_CARRE_SELECTION) {
			tab_mem.get(0).translation(0, ty);
			tab_mem.get(2).translation(tx, 0);
		}
		
		if(p.distance(tab_mem.get(3))<TAILLE_CARRE_SELECTION) {
			tab_mem.get(0).translation(tx, 0);
			tab_mem.get(2).translation(0, ty);
		}
		ptab_mem.add(tab_mem.get(0));
		ptab_mem.add(tab_mem.get(2));
		this.modifierPoints(ptab_mem);
	}
}
