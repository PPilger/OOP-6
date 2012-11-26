/**
 * Invariante: Ein Sensor ist unveraenderbar.
 * 
 * @author Christian Kletzander
 */
public class Sensor extends Encoded {

	private String name;

	public Sensor(int serialNum, String name) {
		super(serialNum);
		this.name = name;
	}

	public String toString() {
		return this.name;
	}
}
