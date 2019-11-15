package Model;

import java.awt.*;
import java.util.ArrayList;


public abstract class FigureColoree implements Cloneable{
	
	public static final int TAILLE_CARRE_SELECTION=10;
	public static final int PERIPHERIE_CARRE_SELECTION=20;
	private boolean selected;
	private Color couleur;
	ArrayList<Point> tab_mem;
	
	/**
	 * Constructeur Vide
	 */
	public FigureColoree() {
		selected = false;
		couleur = Color.gray;
		tab_mem = new ArrayList<Point>();
	}
	
	/**
	 * retourne le nombre de point de la FigureColoree
	 * @return nbPoint
	 */
	public abstract int nbPoint();
	
	/**
	 * retourne le nombre de clics (correspondant au nombre de clics bresoin a la creation de la FigureColoree)
	 * @return nbClics
	 */
	public abstract int nbClics();
	
	/**
	 * test si les coordonnees passer en parametre sont dans la FigureColoree
	 * @param a abscisse
	 * @param b ordonnee
	 * @return true si les coordonnee sont dans la FiqureColoree et false dans le cas contraire
	 */
	public abstract boolean estDedans(int a,int b);

	/**
	 * permet la modification d'un Point se trouvant dans une ArryList passer en parametre
	 * @param tab_mem Arrylist de Point 
	 */
	public abstract void modifierPoints(ArrayList<Point> tab_mem);
	
	/**
	 * affiche graphiquement la FigureColoree this
	 * @param g Graphics
	 */
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

	}
	
	/**
	 * Methode de translation de toute la figure
	 * @param tx translation en x
	 * @param ty translation en y

	 */
	public void translation(int tx,int ty){
		for (int i = 0; i < tab_mem.size(); i++) {
			tab_mem.get(i).translation(tx, ty);
			
		}
		
	}
	
	/**
	 * deformation basique
	 * @param tx déformation en x
	 * @param ty déformation en y
	 * @param p Point à défromer
	 */
	public void deformation(int tx,int ty,Point p){
		p.translation(tx, ty);
	}
	
	/**
	 * selection this
	 */
	public void selectionne(){
		selected = true;
	}
	
	/**
	 * deselection this
	 */
	public void deSelectionne(){
		selected = false;
	}
	
	/**
	 * Change la couleur de this
	 * @param c
	 */
	public void changeCouleur(Color c){
		couleur = c;
	}

	/**
	 * retourne le boolean selected
	 * @return selected
	 */
	public boolean isSelected() {
		return selected;
	}
	
	/**
	 * 
	 * @return une figure coloree clone de celle passe en paremetre ou null si erreur
	 */
	public FigureColoree cloner(){
		FigureColoree res= null;
		try {
		res = (FigureColoree)this.clone();
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
		
		return res;
	}
	
	/**
	 * 
	 * @param a coordonne x du listnner souris
	 * @param b coordonne y du listener souris
	 * @return true si le pointeur est sur un des carre de selection
	 */
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
	
	/**
	 * 
	 * @param acoordonne x du listnner souris
	 * @param b coordonne y du listener souris
	 * @return le point actuellment selectionner
	 */
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
