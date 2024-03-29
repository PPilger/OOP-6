/**
 * Invariante: Ein Aktor ist unveraenderbar.
 * 
 * @author Christian Kletzander
 */
public class Aktor extends Encoded {
	private String name;
	private double kw;

	public Aktor(int serialNum, String name, double kw) {
		super(serialNum);
		this.name = name;
		this.kw = kw;
	}

	public double getkW() {
		return this.kw;
	}

	public String toString() {
		return this.name + " (" + this.kw + " kW)";
	}
}
