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
		if(mf.getMlmf()==null && mf.getMml()==null) {
			mf = new ManipulateurFormes(this);
			setChanged();	
			notifyObservers(VueDessin.ADD_MF);//add Manipulateur
		}
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

}
