import java.util.*;
import java.util.Observable;

public class DessinModel extends Observable{
	private ArrayList<FigureColoree> lfi;
	FabricantFigures ff;
	ManipulateurFormes mf;

	public DessinModel() {
		lfi = new ArrayList<FigureColoree>();
	}

	public void ajoute(FigureColoree fc){
		lfi.add(fc);
		System.out.println("dessin modele updater");
		setChanged();	
		notifyObservers(VueDessin.SUP_FF);//remove Fabricant
	}

	public void construit(FigureColoree fc){
		if(ff!=null){
			System.out.println("-remove deb construit");
			setChanged();	
			notifyObservers(VueDessin.SUP_FF);//remove Fabricant
		}
		ff = new FabricantFigures(fc, this);
		setChanged();	
		notifyObservers(VueDessin.ADD_FF);//add fabricant
	}

	public void manipuler(){
		/*if(mf!=null) {
		}

		mf = new ManipulateurFormes(this);
		setChanged();	
		notifyObservers(VueDessin.ADD_MF);//add Manipulateur*/
		if(mf!=null){
			System.out.println("-remove deb modification");
			setChanged();	
			notifyObservers(VueDessin.SUP_MF);//remove Fabricant
		}
		mf = new ManipulateurFormes(this);
		setChanged();	
		notifyObservers(VueDessin.ADD_MF);//add fabricant
	}


	public void finManipulation(){
		setChanged();
		notifyObservers(VueDessin.SUP_MF);
	}

	public void finCreation(){
		setChanged();
		notifyObservers(VueDessin.SUP_FF);
	}

	public ArrayList<FigureColoree> getlfi(){
		return lfi;
	}

	public FigureColoree selectionner(int x, int y) {
		boolean res =false;//dm.getlfi().get(0).estDedans(e.getX(), e.getY());;
		int i=0;
		while(res==false && i < getlfi().size()){
			res = getlfi().get(i).estDedans(x,y);
			if(!res){
				i++;
			}
		}

		if(res){

			System.out.println("selection:"+lfi.get(i));
			lfi.get(i).selectionne();
			setChanged();
			notifyObservers(VueDessin.NO_CHANGE);
			return lfi.get(i);
		}
		else{
			System.out.println("pas de selection");
			return null;
		}

	}

	public void translater(ArrayList<Point> lp, FigureColoree fc) {
		if(fc!=null) {
			System.out.println(fc);
			if(lp.size()>2) {
				int tx,ty;
				System.out.println("translation");
				tx=lp.get(lp.size()-1).rendreX()-lp.get(lp.size()-2).rendreX();
				ty=lp.get(lp.size()-1).rendreY()-lp.get(lp.size()-2).rendreY();
				fc.translation(tx, ty);
				setChanged();
				notifyObservers(VueDessin.NO_CHANGE);

			}
		}
		
		else {
			System.out.println("dragg mais pas de selection");
		}

	}

}
