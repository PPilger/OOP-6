import java.util.ArrayList;
import java.util.List;

/**
 * Invariante: Ein Kit ist unveraenderbar.
 * 
 * @author Peter Pilgerstorfer
 */
public class Kit {
	private List<Aktor> aktorList;
	private List<Sensor> sensorList;

	public Kit(List<Aktor> actors, List<Sensor> sensors) {
		// Erstellt (flache) Kopien der uebergebenen Listen, um nachtraegliche
		// Aenderungen zu unterbinden.
		// Da Aktor und Sensor unveraenderbar sind, reicht eine flache Kopie
		this.aktorList = new ArrayList<Aktor>(actors);
		this.sensorList = new ArrayList<Sensor>(sensors);
	}

	/**
	 * Liefert die Leistungsklasse des Kits (aller Aktoren zusammen).
	 */
	public PowerClass getPowerClass() {
		double summe = 0;

		for (Aktor temp : this.aktorList) {
			summe += temp.getkW();
		}

		return PowerClass.getPowerClass(summe);
	}

	/**
	 * Ueberprueft, ob alle Aktoren und Sensoren mit der uebergebenen
	 * Seriennummer codiert ist. Liefert Valid, falls es zutrifft und Error
	 * anderenfalls.
	 */
	public ValidationCode validSerialNum(SerialNumberValidator num) {
		ValidationCode code = new Valid();

		// Aktoren pruefen
		for (Aktor a : aktorList) {
			ValidationCode code2 = a.validSerialNum(num);
			code = code.merge(code2);
		}

		// Sensoren pruefen
		for (Sensor s : sensorList) {
			ValidationCode code2 = s.validSerialNum(num);
			code = code.merge(code2);
		}

		return code;
	}

	/**
	 * Gibt alle Aktoren und Sensoren in Stringdarstellung zurueck.
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("Aktoren: ");
		sb.append(aktorList);
		sb.append(", Sensoren: ");
		sb.append(sensorList);

		return sb.toString();
	}
}
