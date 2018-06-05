import java.awt.Graphics;
import java.awt.geom.Arc2D;
import java.util.ArrayList;
import java.awt.*;

public class Elipse extends FigureColoree{
	private Arc2D.Double o;
	
	public Elipse() {
		// TODO Auto-generated constructor stub
		super();
	}
	public void affiche(Graphics g){
		super.affiche(g);
		System.out.println("affiche elipse");
		int xa = tab_mem.get(0).rendreX();
		int ya = tab_mem.get(0).rendreY();
		o = new Arc2D.Double(xa, ya, 50, 70, 0, 360,Arc2D.OPEN); 
		g.fillArc(xa, ya, 50, 70, 0, 360);
	}

	@Override
	public int nbPoint() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public int nbClics() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public boolean estDedans(int a, int b) {
		// TODO Auto-generated method stub
		return this.o.contains(a, b);
	}

	@Override
	public void modifierPoints(ArrayList<Point> etab_mem) {
		// TODO Auto-generated method stub
		this.tab_mem = etab_mem;
	}
	public Arc2D.Double getO() {
		return o;
	}

	
	
	

}
