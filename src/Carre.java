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
		
		//v.modifierX((int)(d*Math.sqrt(1/(1+((up1p2.rendreX()*up1p2.rendreX())/(up1p2.rendreY()*up1p2.rendreY()))))));
		
		
		
		//v.modifierY((int)(v.rendreX()*(0-(up1p2.rendreX())/up1p2.rendreY())));

		
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
		
		ArrayList<Point> ptab_mem = new ArrayList<Point>();
		if(p.distance(tab_mem.get(2))<TAILLE_CARRE_SELECTION) {
			tab_mem.get(1).translation(tx, 0);
		}
		
		if(p.distance(tab_mem.get(3))<TAILLE_CARRE_SELECTION) {
			
			tab_mem.get(0).translation(tx, 0);
		}
		ptab_mem.add(tab_mem.get(0));
		ptab_mem.add(tab_mem.get(1));
		this.modifierPoints(ptab_mem);
	}

	
	public int nbClics() {
		return 2;
	}


}
