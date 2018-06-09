import java.util.ArrayList;

public class Carre extends Quadrilatere{
	boolean manipInverse;
	public Carre() {
		super();
	}

	public void modifierPoints(ArrayList<Point> ptab_mem){
		System.out.println("modif normal");
		this.tab_mem= ptab_mem;
		Point p1 = tab_mem.get(0);
		Point p2 = tab_mem.get(1);
		if(tab_mem.size()>=2 && tab_mem.size()<4) {
			tab_mem.add(null);
			tab_mem.add(null);
		}

		//vecteur u utiliser pour la creation du carre
		Point up1p2 = new Point();
		up1p2.modifierX(p2.rendreX()-p1.rendreX());
		up1p2.modifierY(p2.rendreY()-p1.rendreY());

		double d = p1.distance(p2);

		//vecteur v pour translation
		Point v = new Point();

		


		v.modifierX(up1p2.rendreY());
		v.modifierY(0-up1p2.rendreX());

		Point p4 = new Point();
		p4.translation(p1.rendreX()-v.rendreX(), p1.rendreY()-v.rendreY());

		Point p3 = new Point();
		p3.translation(p2.rendreX()-v.rendreX(),p2.rendreY()-v.rendreY());
		tab_mem.set(2,p3);
		tab_mem.set(3,p4);

		System.out.println(tab_mem);

	}

	public void deformation(int tx,int ty,Point p) {
		super.deformation(tx, ty, p);
		Point p0,p1,p2,p3;
		p0=tab_mem.get(0);
		p1=tab_mem.get(1);
		p2=tab_mem.get(2);
		p3=tab_mem.get(3);
		double dist;
		ArrayList<Point> ptab_mem = new ArrayList<Point>();
		ptab_mem.add(null);
		ptab_mem.add(null);
		ptab_mem.add(null);
		ptab_mem.add(null);
		
		if((p!=p0 && p!=p1)) {
			ptab_mem.set(3,p3);
			ptab_mem.set(2,p2);
			this.modifierPointsInverse(ptab_mem);
		}
		else {
		ptab_mem.set(0,p0);
		ptab_mem.set(1,p1);
		this.modifierPoints(ptab_mem);
		}
		
	}


	public int nbClics() {
		return 2;
	}
	
	public void modifierPointsInverse(ArrayList<Point> ptab_mem){
		System.out.println("modif inverse");
		this.tab_mem= ptab_mem;
		Point p1 = tab_mem.get(2);
		Point p2 = tab_mem.get(3);

		//vecteur u utiliser pour la creation du carre
		Point up1p2 = new Point();
		up1p2.modifierX(p2.rendreX()-p1.rendreX());
		up1p2.modifierY(p2.rendreY()-p1.rendreY());

		double d = p1.distance(p2);

		//vecteur v pour translation
		Point v = new Point();

		


		v.modifierX(up1p2.rendreY());
		v.modifierY(0-up1p2.rendreX());

		Point p4 = new Point();
		p4.translation(p1.rendreX()-v.rendreX(), p1.rendreY()-v.rendreY());

		Point p3 = new Point();
		p3.translation(p2.rendreX()-v.rendreX(),p2.rendreY()-v.rendreY());
		tab_mem.set(0,p3);
		tab_mem.set(1,p4);

		System.out.println(tab_mem);

	}


}
