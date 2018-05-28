import java.util.*;
import java.util.Observable;

public class DessinModel extends Observable{
	private ArrayList<FigureColoree> lfi;
	FabricantFigures ff;
	public DessinModel() {
		lfi = new ArrayList<FigureColoree>();
	}

	public void ajoute(FigureColoree fc){
		lfi.add(fc);
		System.out.println("dessin modele updater");
		setChanged();	
		notifyObservers(true);
	}

	public void construit(FigureColoree fc){
		ff = new FabricantFigures(fc, this);
		setChanged();	
		notifyObservers(false);
	}

	public ArrayList<FigureColoree> getlfi(){
		return lfi;
	}
	
}
