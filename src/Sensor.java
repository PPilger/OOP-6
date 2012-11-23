/**
 * 
 * @author Christian Kletzander
 *
 */
public class Sensor {

	private String name;
	private int serialNum;
	
	public Sensor(String name, int serialNum) {
		this.name = name;
		this.serialNum = serialNum;
	}
	
	public String toString() {
		return this.name;
	}
	
	public int getSerialNum() {
		return this.serialNum;
	}
	
}
