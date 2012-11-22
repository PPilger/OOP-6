
public class Aktor {

	private String name;
	private double kw;
	
	public Aktor(String name, double kw) {
		this.name = name;
		this.kw = kw;
	}
	
	public double getkW() {
		return this.kw;
	}
	
	public String toString() {
		return "Name: " + this.name + " - Leistung: " + this.kw + " [kW]";
	}
	
}
