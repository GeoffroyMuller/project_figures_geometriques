import java.util.*;
import java.util.Observable;

public class DessinModel extends Observable{
	private ArrayList<FigureColoree> lfi;
	FabricantFigures ff;
	ManipulateurFormes mf;
	MainLevee ml;
	
	/**
	 * Constructeur Vide
	 */
	public DessinModel() {
		lfi = new ArrayList<FigureColoree>();

	}
	
	/**
	 * methode qui ajoute une FigureColoree a un DessinModel
	 * @param fc FigureColoree a ajouter
	 */
	public void ajoute(FigureColoree fc){
		lfi.add(fc);
		if(fc instanceof Trait){
			System.out.println("fin de ajout suppresion listener");
			setChanged();	
			notifyObservers(VueDessin.NO_CHANGE);//remove Fabricant	
		}
		else{
			System.out.println("fin de ajout suppresion listener");
			setChanged();	
			notifyObservers(VueDessin.SUP_FF);//remove Fabricant
			constructionIterer(fc);
		}
		


	}
	
	/**
	 * ajout ou close de listner permetant la construction d'une FigureColoree passer en parametre
	 * @param fc FigureColoree a construire
	 */
	public void construit(FigureColoree fc){
		if(fc instanceof Trait){
			if(ml!=null){
				setChanged();	
				notifyObservers(VueDessin.SUP_ML);//remove Fabricant
			}
			ml = new MainLevee(fc, this);
			setChanged();	
			notifyObservers(VueDessin.ADD_ML);//add fabricant
		}
		else{
			if(ff!=null){
				setChanged();	
				notifyObservers(VueDessin.SUP_FF);//remove Fabricant
			}
			ff = new FabricantFigures(fc, this);
			setChanged();	
			notifyObservers(VueDessin.ADD_FF);//add fabricant
		}
	}

	/**
	 * permet de relancer une construction (sans avoir a rappuyer sur le boutton de construction de figure)
	 * d'une FigureColoree passer en parametre
	 * @param fc FigureColoree a construire 
	 */
	public void constructionIterer(FigureColoree fc) {	
		FigureColoree nfc = fc.cloner();
		construit(nfc);
	}
	/**
	 * initialise un nouveau Trait 
	 * @param fc
	 */
	public void initNouveauTrait(FigureColoree fc) {
		setChanged();	
		notifyObservers(VueDessin.SUP_ML);
		constructionIterer(fc);
	}
	
	/**
	 * permet la manipulation de forme en ajoutant le listner manipulateurforme
	 */
	public void manipuler(){
		if(mf!=null){
			setChanged();	
			notifyObservers(VueDessin.SUP_MF);//remove manipuateur
		}
		mf = new ManipulateurFormes(this);
		setChanged();	
		notifyObservers(VueDessin.ADD_MF);//add manipulateur
	}





	/**
	 * met fin a la manipulation 
	 */
	public void finManipulation(){
		setChanged();
		notifyObservers(VueDessin.SUP_MF);
	}

	/**
	 * met fin a la Creation
	 */
	public void finCreation(){
		setChanged();
		notifyObservers(VueDessin.SUP_FF);
	}

	/**
	 * met fin a la Creation d'un DessinMainLevee
	 */
	public void finDessinMainLevee(){
		setChanged();
		notifyObservers(VueDessin.SUP_ML);
	}

	/**
	 * get Arraylist de Point
	 * @return Arraylist de Point
	 */
	public ArrayList<FigureColoree> getlfi(){
		return lfi;
	}

	/**
	 * permet la selection d'une FigureColoree appartenant a DessinModel via les cooredonee d'un Point passer en parametre
	 * @param x	abscise du Point
	 * @param y	ordonnee du Point
	 * @return la FigureColoree selectionner
	 */
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
	
	/**
	 * permet la deselection de toute les FigureColoree de DessinModel 
	 */
	public void deSelectionnerTout() {
		for(int j=0;j<lfi.size();j++) {
			lfi.get(j).deSelectionne();
			setChanged();
			notifyObservers(VueDessin.NO_CHANGE);
		}
	}

	/**
	 * permet la translation de la figure selectioner 
	 * @param lp Arrylist de Point qui sera modifier
	 * @param fc FigureColoree a translater
	 */
	public void translater(ArrayList<Point> lp, FigureColoree fc) {
		if(fc!=null) {
			System.out.println(fc);
			if(lp.size()>2) {
				int tx,ty;
				tx=lp.get(lp.size()-1).rendreX()-lp.get(lp.size()-2).rendreX();
				ty=lp.get(lp.size()-1).rendreY()-lp.get(lp.size()-2).rendreY();
				fc.translation(tx, ty);
				setChanged();
				notifyObservers(VueDessin.NO_CHANGE);

			}
		}

		else {
		}


	}

	/**
	 * permet de deformer une FigureColoree passer en parametre
	 * @param lp Arrylist de Point qui sera modifier
	 * @param fc FigureColoree a deformer
	 * @param p Point depuit lequel se fait la deformation
	 */
	public void deformer(ArrayList<Point> lp, FigureColoree fc,Point p) {
		if(fc!=null) {
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
	
	/**
	 * efface toute les FigureColoree de DessinModel
	 */
	public void effacerTout() {
		lfi.clear();
		setChanged();
		notifyObservers(VueDessin.NO_CHANGE);
	}
	
	/**
	 * fait appel a la methode repaint de VueDessin
	 */
	public void rafraichir() {
		setChanged();
		notifyObservers(VueDessin.NO_CHANGE);
	}



}
