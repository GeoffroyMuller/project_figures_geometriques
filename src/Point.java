import java.util.*;
public class Point {
	private int x,y;
	
	/**
	 * Constructeur par default
	 */
	public Point(){
		x=0;
		y=0;
	}
	
	/**
	 * Constructeur a 2 parametre
	 * @param px abscisse
	 * @param py ordonnee
	 */
	public Point(int px , int py){
		x=px;
		y=py;
	}
	
	/**
	 * calcule la distance entre le Point this et le Point p passer en parametre
	 * @param p Point 
	 * @return la distance entre les deux Points
	 */
	public double distance(Point p){
		int px = p.rendreX();
		int py = p.rendreY();
		Double res = Math.sqrt((px-x)*(px-x)+(py-y)*(py-y));

		return res;
	}

	/**
	 * @return abscisse
	 */
	public int rendreX(){
		return x;
	}

	/**
	 * @return ordonnee
	 */
	public int rendreY(){
		return y;
	}

	/**
	 * incremente l'abscisse
	 */
	public void incrementerX(){
		x=x+1;
	}

	/**
	 * incremente l'ordonnee
	 */
	public void incrementerY(){
		y=y+1;
	}

	/**
	 * modifie l'abscisse
	 * @param mod 
	 */
	public void modifierX(int mod){
		x=mod;
	}

	/**
	 * modifie l'ordonnee
	 * @param mod
	 */
	public void modifierY(int mod){
		y=mod;
	}

	/**
	 * translation du Point this
	 * @param tx 
	 * @param ty
	 */
	public void translation(int tx,int ty){
		x=x+tx;
		y=y+ty;
	}
	
	public String toString() {
		return " Point "+this.x+":"+this.y+" ";
	}

}
