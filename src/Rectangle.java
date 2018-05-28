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
	

	
	public void transformation(int a,int b,int c){
		
	}
}
