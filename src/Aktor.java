/**
 * 
 * @author Christian Kletzander
 *
 */
public class Aktor {

	private String name;
	private double kw;
	private int serialNum;
	
	public Aktor(String name, double kw, int serialNum) {
		this.name = name;
		this.kw = kw;
		this.serialNum = serialNum;
	}
	
	public double getkW() {
		return this.kw;
	}
	
	public String toString() {
		return "Name: " + this.name + " - Leistung: " + this.kw + " [kW]";
	}
	
	public int getSerialNum() {
		return this.serialNum;
	}
	
}
