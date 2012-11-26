/**
 * Stellt ein codiertes Bauteil dar.
 * 
 * @author Peter Pilgerstorfer
 */
public abstract class Encoded {
	private int serialNum; // Die Seriennummer mit der das Bauteil codiert wurde

	public Encoded(int serialNum) {
		this.serialNum = serialNum;
	}

	/**
	 * Ueberprueft, ob das Objekt mit der uebergebenen Seriennummer codiert ist.
	 * Liefert Valid, falls es zutrifft und Error anderenfalls.
	 */
	public ValidationCode validSerialNum(SerialNumberValidator num) {
		return num.validate(serialNum);
	}
}
