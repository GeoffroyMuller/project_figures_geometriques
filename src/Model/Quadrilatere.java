package Model;

public class Quadrilatere extends Polygone{
	public Quadrilatere(){
		super();
	}

	/**
	 * @return nombre de click necessaire à la création de la figure
	 */
	@Override
	public int nbPoint() {
		return 4;
	}
	
	
}
