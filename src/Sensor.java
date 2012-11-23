/**
 * 
 * @author Christian Kletzander
 *
 */
public class Sensor implements Encoded {

	private String name;
	private int serialNum;
	
	public Sensor(String name, int serialNum) {
		this.name = name;
		this.serialNum = serialNum;
	}
	
	public String toString() {
		return this.name;
	}
	
	@Override
	public ValidationCode validSerialNum(SerialNumber num) {
		return num.validate(this.serialNum);
	}
	
}
