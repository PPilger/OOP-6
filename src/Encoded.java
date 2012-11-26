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
	 * Ueberprueft, ob die Seriennummer mit der uebergebenen uebereinstimmt.
	 * Liefert Valid, falls sie uebereinstimmen und Error anderenfalls.
	 */
	public ValidationCode validSerialNum(SerialNumber num) {
		return num.validate(serialNum);
	}
}
