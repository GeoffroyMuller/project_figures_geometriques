import java.util.*;
import java.util.Observable;

public class DessinModel extends Observable{
	private ArrayList<FigureColoree> lfi;
	FabricantFigures ff;
	ManipulateurFormes mf;
	MainLevee ml;

	public DessinModel() {
		lfi = new ArrayList<FigureColoree>();

	}

	public void ajoute(FigureColoree fc){
		lfi.add(fc);
		if(fc instanceof Trait){
			System.out.println("fin de ajout suppresion listener");
			setChanged();	
			notifyObservers(VueDessin.SUP_ML);//remove Fabricant	
		}
		else{
			System.out.println("fin de ajout suppresion listener");
			setChanged();	
			notifyObservers(VueDessin.SUP_FF);//remove Fabricant
		}
		constructionIterer(fc);


	}

	public void construit(FigureColoree fc){
		if(fc instanceof Trait){
			System.out.println("trait");
		}
		else{
			System.out.println("autre");
		}

		if(fc instanceof Trait){
			if(ml!=null){
				System.out.println("supreesion ml");
				setChanged();	
				notifyObservers(VueDessin.SUP_ML);//remove Fabricant
			}
			ml = new MainLevee(fc, this);
			setChanged();	
			notifyObservers(VueDessin.ADD_ML);//add fabricant
		}
		else{
			if(ff!=null){
				System.out.println("suppresion ff");
				setChanged();	
				notifyObservers(VueDessin.SUP_FF);//remove Fabricant
			}
			ff = new FabricantFigures(fc, this);
			setChanged();	
			notifyObservers(VueDessin.ADD_FF);//add fabricant
		}
	}


	public void constructionIterer(FigureColoree fc) {	
		FigureColoree nfc = fc.cloner();
		construit(nfc);
	}

	public void manipuler(){
		if(mf!=null){
			System.out.println("-remove deb modification");
			setChanged();	
			notifyObservers(VueDessin.SUP_MF);//remove manipuateur
		}
		mf = new ManipulateurFormes(this);
		setChanged();	
		notifyObservers(VueDessin.ADD_MF);//add manipulateur
	}






	public void finManipulation(){
		setChanged();
		notifyObservers(VueDessin.SUP_MF);
	}

	public void finCreation(){
		setChanged();
		notifyObservers(VueDessin.SUP_FF);
	}

	public void finDessinMainLevee(){
		setChanged();
		notifyObservers(VueDessin.SUP_ML);
	}




	public ArrayList<FigureColoree> getlfi(){
		return lfi;
	}

	public FigureColoree selectionner(int x, int y) {
		boolean res =false;//dm.getlfi().get(0).estDedans(e.getX(), e.getY());;
		int i=getlfi().size()-1;
		while(res==false && i >=0 ){
			res = getlfi().get(i).estDedans(x,y);
			if(!res){
				i--;
			}
		}

		if(res){
			for(int j=0;j<lfi.size();j++) {
				lfi.get(j).deSelectionne();
			}
			System.out.println("selection:"+lfi.get(i));
			lfi.get(i).selectionne();
			setChanged();
			notifyObservers(VueDessin.NO_CHANGE);
			return lfi.get(i);
		}
		else{
			System.out.println("pas de selection");
			deSelectionnerTout();
			return null;
		}

	}

	public void deSelectionnerTout() {
		for(int j=0;j<lfi.size();j++) {
			lfi.get(j).deSelectionne();
			setChanged();
			notifyObservers(VueDessin.NO_CHANGE);
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

	public void deformer(ArrayList<Point> lp, FigureColoree fc,Point p) {
		if(fc!=null) {
			System.out.println("deformation de "+fc);
			if(lp.size()>2) {
				int tx,ty;
				tx=lp.get(lp.size()-1).rendreX()-lp.get(lp.size()-2).rendreX();
				ty=lp.get(lp.size()-1).rendreY()-lp.get(lp.size()-2).rendreY();
				fc.deformation(tx, ty, p);
				setChanged();
				notifyObservers(VueDessin.NO_CHANGE);
			}
		}
	}
	
	public void effacerTout() {
		lfi.clear();
		setChanged();
		notifyObservers(VueDessin.NO_CHANGE);
	}
	
	public void rafraichir() {
		System.out.println("rafraichir");
		setChanged();
		notifyObservers(VueDessin.NO_CHANGE);
	}



}
