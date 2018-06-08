
import java.awt.*;
import java.util.ArrayList;


public abstract class FigureColoree implements Cloneable{
	
	public static final int TAILLE_CARRE_SELECTION=10;
	public static final int PERIPHERIE_CARRE_SELECTION=20;
	private boolean selected;
	private Color couleur;
	ArrayList<Point> tab_mem;
	
	public FigureColoree() {
		selected = false;
		couleur = Color.gray;
		tab_mem = new ArrayList<Point>();
	}
	
	public abstract int nbPoint();
	
	public abstract int nbClics();
	
	public abstract boolean estDedans(int a,int b);

	
	public abstract void modifierPoints(ArrayList<Point> tab_mem);
	
	public void affiche(Graphics g){
		g.setColor(couleur);
		System.out.println("affiche fc");
		if(selected) {
			g.setColor(Color.black);
			for(int i=0; i<tab_mem.size();i++) {
				Point p = tab_mem.get(i);
				int decal = TAILLE_CARRE_SELECTION/2;
				g.fillOval(p.rendreX()-decal,p.rendreY()-decal, TAILLE_CARRE_SELECTION, TAILLE_CARRE_SELECTION);
			}
			g.setColor(couleur);
		}
		/*g.drawRect(10, 10, 10, 10);
		int [] xd = {10,20,30};
		int [] yd = {10,60,30};
		g.drawPolygon(xd, yd, 3);*/
	}
	
	public void translation(int tx,int ty){
		for (int i = 0; i < tab_mem.size(); i++) {
			tab_mem.get(i).translation(tx, ty);
			
		}
		
	}
	
	public void deformation(int tx,int ty,Point p){
		p.translation(tx, ty);
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

	public boolean isSelected() {
		return selected;
	}
	
	public FigureColoree cloner(){
		FigureColoree res= null;
		try {
		res = (FigureColoree)this.clone();
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
		
		return res;
	}

	public boolean estSurCarreSelection(int a,  int b) {
		boolean res = false;
		Point p = new Point(a, b);
		for (int i = 0; i < tab_mem.size(); i++) {
			if(tab_mem.get(i).distance(p)<= FigureColoree.PERIPHERIE_CARRE_SELECTION) {
				res = true;
			}
		}
		
		return res;
	}
	
	public Point pointDeSelection(int a, int b) {
		Point p = new Point(a,b);
		Point res = null;
		if (estSurCarreSelection(a, b)) {
			for (int i = 0; i < tab_mem.size(); i++) {
				if(tab_mem.get(i).distance(p)<= FigureColoree.PERIPHERIE_CARRE_SELECTION) {
					res=tab_mem.get(i);
				}
			}
		}
		return res;
	}
	
	

	
}
