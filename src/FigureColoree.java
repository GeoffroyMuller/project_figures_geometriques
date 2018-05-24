
import java.awt.*;
import java.util.ArrayList;


public abstract class FigureColoree {
	
	public static final int TAILLE_CARRE_SELECTION=4;
	public static final int PERIPHERIE_CARRE_SELECTION=4;
	private boolean selected;
	private Color couleur;
	ArrayList<Point> tab_mem;
	
	public FigureColoree() {
		selected = false;
		couleur = Color.blue;
		tab_mem = new ArrayList<Point>();
	}
	
	public abstract int nbPoint();
	
	public abstract int nbClics();
	
	public abstract boolean estDedans(int a,int b);

	
	public abstract void modifierPoints(ArrayList<Point> tab_mem);
	
	public void affiche(Graphics g){
		g.setColor(couleur);
		/*g.drawRect(10, 10, 10, 10);
		int [] xd = {10,20,30};
		int [] yd = {10,60,30};
		g.drawPolygon(xd, yd, 3);*/
	}
	
	public void translation(int tx,int ty){
		for (int i = 0; i < tab_mem.size(); i++) {
			tab_mem.get(i).translation(tx, ty);;
		}
	}
	
	public void transformation(int a,int b,int c){
		
	}
	
	public int carreDeSelection(int a,int b){
		return 0;
	}
	
	public void selectionne(){
		selected = true;
	}
	
	public void deSelectionne(){
		selected = false;
	}
	
	public void changeCouleur(Color c){
		couleur = c;
	}


	
	

	
}
