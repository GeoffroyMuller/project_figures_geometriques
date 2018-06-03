import java.util.ArrayList;

public class Carre extends Rectangle{
	
	public Carre() {
		super();
	}
		
		public void modifierPoints(ArrayList<Point> ptab_mem){
			this.tab_mem= ptab_mem;
			Point p1 = tab_mem.get(0);
			Point p2 = tab_mem.get(1);
			int dist = (int)tab_mem.get(0).distance(tab_mem.get(1));
			Point np1 = new Point(p2.rendreX(),p2.rendreY()+dist);
			Point np2 = new Point(p1.rendreX(),p1.rendreY()+dist);
			tab_mem.add(np1);
			tab_mem.add(np2);

		}
	

}
