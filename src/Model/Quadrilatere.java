package Model;

public class Quadrilatere extends Polygone{
	public Quadrilatere(){
		super();
	}

	/**
	 * @return nombre de click necessaire � la cr�ation de la figure
	 */
	@Override
	public int nbPoint() {
		return 4;
	}
	
	
}
