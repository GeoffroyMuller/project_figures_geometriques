import java.util.ArrayList;

public class Carre extends Quadrilatere{

	public Carre() {
		super();
	}

	public void modifierPoints(ArrayList<Point> ptab_mem){
		this.tab_mem= ptab_mem;
		Point p1 = tab_mem.get(0);
		Point p2 = tab_mem.get(1);

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
		p4.translation(p1.rendreX()+v.rendreX(), p1.rendreY()+v.rendreY());

		Point p3 = new Point();
		p3.translation(p2.rendreX()+v.rendreX(),p2.rendreY()+v.rendreY());
		tab_mem.add(p3);
		tab_mem.add(p4);
		System.out.println("==============");
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p1.distance(p2));
		System.out.println(p3);
		System.out.println(p4);
		System.out.println("===================");
		System.out.println(up1p2);
		System.out.println(v);
		System.out.println("/////////////");

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
		if(p.distance(p2)<TAILLE_CARRE_SELECTION) {
			Point up0p2 = new Point();//vecteur
			up0p2.modifierX(p2.rendreX()-p0.rendreX());
			up0p2.modifierY(p2.rendreY()-p0.rendreY());

			Point up3p1 = new Point();//vecteur
			up3p1.modifierX(p1.rendreX()-p3.rendreX());
			up3p1.modifierY(p1.rendreY()-p3.rendreY());

			while(Math.abs(up3p1.rendreX())!=Math.abs(up0p2.rendreX())) {
				if(up3p1.rendreX()>=0){


					p1.translation(1, 0);
				}
				else {
					p1.translation(-1, 0);
				}
				System.out.println("iteration sur x");
				up3p1.modifierX(p1.rendreX()-p3.rendreX());
			}
			
			while(Math.abs(up3p1.rendreY())!=Math.abs(up0p2.rendreY())) {
				if(up3p1.rendreY()>=0){


					p1.translation(0, 1);
				}
				else {
					p1.translation(0, -1);
				}
				System.out.println("iteration sur y");
				up3p1.modifierX(p1.rendreY()-p3.rendreY());
			}


		}
		else {
			if(p.distance(p3)<TAILLE_CARRE_SELECTION) {

			}
			else {
			}
		}
		ptab_mem.add(p0);
		ptab_mem.add(p1);
		this.modifierPoints(ptab_mem);
	}


	public int nbClics() {
		return 2;
	}


}
