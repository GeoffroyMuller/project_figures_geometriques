import java.util.ArrayList;


public class Losange extends Quadrilatere{

	public Losange() {
		// TODO Auto-generated constructor stub
		super();
	}
	public void modifierPoints(ArrayList<Point> ptab_mem){
		this.tab_mem= ptab_mem;
		if(tab_mem.size()>=2 && tab_mem.size()<4) {
			tab_mem.add(null);
			tab_mem.add(null);
		}
		Point p1 = tab_mem.get(0);
		Point p2 = tab_mem.get(1);
		int dist = (int)tab_mem.get(0).distance(tab_mem.get(1));
		Point np1 = new Point(p2.rendreX(),p2.rendreY()+dist);
		Point np2 = new Point(p1.rendreX(),p1.rendreY()+dist);
		tab_mem.set(2,np1);
		tab_mem.set(3,np2);
	}

	public int nbClics() {
		return 2;
	}

	public void deformation(int tx,int ty,Point p) {

		
		ArrayList<Point> ptab_mem = new ArrayList<Point>();
		ptab_mem.add(null);
		ptab_mem.add(null);
		ptab_mem.add(null);
		ptab_mem.add(null);
		
		
		Point p0,p1,p2,p3;
		p0=tab_mem.get(0);
		p1=tab_mem.get(1);
		p2=tab_mem.get(2);
		p3=tab_mem.get(3);
		super.deformation(tx, ty, p);
		if(p==p0 || p==p1) {
			
			ptab_mem.set(0,p0);
			ptab_mem.set(1,p1);

			this.modifierPoints(ptab_mem);
		}
		else {
			ptab_mem.set(2,p2);
			ptab_mem.set(3,p3);

			this.modifierPointsInverse(ptab_mem);
		}


	}
	
	public void modifierPointsInverse(ArrayList<Point> ptab_mem){
		this.tab_mem= ptab_mem;
		Point p1 = tab_mem.get(2);
		Point p2 = tab_mem.get(3);
		int dist = (int)tab_mem.get(2).distance(tab_mem.get(3));
		Point np1 = new Point(p2.rendreX(),p2.rendreY()-dist);
		Point np2 = new Point(p1.rendreX(),p1.rendreY()-dist);
		tab_mem.set(0,np1);
		tab_mem.set(1,np2);
	}





}


