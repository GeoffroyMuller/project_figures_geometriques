
import java.awt.*;
import java.util.ArrayList;


public class FigureColoree {
	
	private boolean selection;
	private Color couleur;
	private ArrayList<Point> tabp;
	
	public FigureColoree() {
		selection = false;
		couleur = Color.blue;
		tabp = new ArrayList<Point>();
	}
	
	public int nbPoint(){
		return 0;
	}
	
	public int nbClics(){
		return 0;
	}
	
	public boolean estDedans(int a,int b){
		return false;
	}
	
	public void modifierPoints(Point[] tp){
		
	}
	
	public void affiche(Graphics g){
		
	}
	
	public void translation(int a,int b){
		
	}
	
	public void transformation(int a,int b,int c){
		
	}
	
	public int carreDeSelection(int a,int b){
		return 0;
	}
	
	public void selectionne(){
		selection = true;
	}
	
	public void deSelectionne(){
		selection = false;
	}
	
	public void changeCouleur(Color c){
		couleur = c;
	}

}
