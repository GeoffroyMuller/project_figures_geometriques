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
		setChanged();
		notifyObservers();
	}

	public void construit(FigureColoree fc){
		ff = new FabricantFigures(fc, this);
	}

	public ArrayList<FigureColoree> getlfi(){
		return lfi;
	}
}
