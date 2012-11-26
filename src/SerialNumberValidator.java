import java.util.HashMap;

/**
 * Stellt eine Klasse zur Validierung von Seriennummern dar.
 * 
 * @author Peter Pilgerstorfer
 */
public class SerialNumberValidator {
	// enthaelt die Seriennummer als Schluessel und ein Valid Objekt als Wert
	private HashMap<Integer, ValidationCode> map;

	public SerialNumberValidator(int serialNum) {
		map = new HashMap<Integer, ValidationCode>();
		map.put(serialNum, new Valid());
	}

	public ValidationCode validate(int serialNum) {
		ValidationCode code = this.map.get(serialNum);

		if (code == null) {
			// die Seriennummer war nicht enthalten
			return new Error("not a valid Serial Number");
		}

		return code;
	}

}
