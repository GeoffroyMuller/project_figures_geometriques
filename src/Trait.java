import java.awt.Graphics;
import java.util.ArrayList;


public class Trait extends FigureColoree{

	/**
	 * methode inutile pour trait mais implementation necessaire pour pouvoir implementer figureColoree
	 */
	@Override
	public  int nbPoint() {
		return 0;
	}

	/**
	 * methode inutile pour trait mais implementation necessaire pour pouvoir implementer figureColoree
	 */
	@Override
	public int nbClics() {
		return 0;
	}

	@Override
	/**
	 * methode inutile pour trait mais implementation necessaire pour pouvoir implementer figureColoree
	 */
	public boolean estDedans(int a, int b) {
		return false;
	}
	
	
	/**
	 * permet de modifier les Points d'une liste de Point donnee en parametre
	 * @param ptab_mem Arraylist de Point aui viens re;plqcer lq liste de point qctuelle de le figure
	 */
	@Override
	public void modifierPoints(ArrayList<Point> ptab_mem) {
		this.tab_mem= ptab_mem;
		
	}
	
	/**
	 * Methode d'affichage propre au trait
	 */
	public void affiche(Graphics g){
		super.affiche(g);

		for(int i=0;i<this.tab_mem.size()-1;i++){
			int x1 =this.tab_mem.get(i).rendreX();
			int y1 =this.tab_mem.get(i).rendreY();
			int x2 =this.tab_mem.get(i+1).rendreX();
			int y2 =this.tab_mem.get(i+1).rendreY();


			g.drawLine(x1, y1, x2, y2);
		}
	}

}
