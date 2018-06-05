import java.util.*;
public class Point {
	private int x,y;

	public Point(){
		x=0;
		y=0;
	}


	public Point(int px , int py){
		x=px;
		y=py;
	}

	public double distance(Point p){
		int px = p.rendreX();
		int py = p.rendreY();
		Double res = Math.sqrt((px-x)*(px-x)+(py-y)*(py-y));

		return res;
	}

	public int rendreX(){
		return x;
	}

	public int rendreY(){
		return y;
	}

	public void incrementerX(){
		x=x+1;
	}

	public void incrementerY(){
		y=y+1;
	}

	public void modifierX(int mod){
		x=mod;
	}

	public void modifierY(int mod){
		y=mod;
	}

	public void translation(int tx,int ty){
		x=x+tx;
		y=y+ty;
	}
	
	public String toString() {
		return " Point "+this.x+":"+this.y+" ";
	}

}
