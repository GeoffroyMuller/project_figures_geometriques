import java.awt.Graphics;
import java.util.ArrayList;


public class Trait extends FigureColoree{

	@Override
	public int nbPoint() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int nbClics() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean estDedans(int a, int b) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void modifierPoints(ArrayList<Point> ptab_mem) {
		this.tab_mem= ptab_mem;
		
	}
	
	/**
	 * affichage graphique de this
	 */
	public void affiche(Graphics g){
		super.affiche(g);

		System.out.println(tab_mem);
		for(int i=0;i<this.tab_mem.size()-1;i++){
			int x1 =this.tab_mem.get(i).rendreX();
			int y1 =this.tab_mem.get(i).rendreY();
			int x2 =this.tab_mem.get(i+1).rendreX();
			int y2 =this.tab_mem.get(i+1).rendreY();
			//System.out.println("coord x :"+x);
			//System.out.println("coord y :"+y);


			g.drawLine(x1, y1, x2, y2);
		}
	}

}
