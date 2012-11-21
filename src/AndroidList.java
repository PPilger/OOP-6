import java.util.LinkedHashMap;
import java.util.Map;


public class AndroidList {
	private Map<Integer, Android> map = new LinkedHashMap<Integer, Android>();
	
	public ValidationCode insert(Android newAndroid) {
		int serialNum = newAndroid.getSerialNum();
		Android existing = map.get(serialNum);
		ValidationCode vc;
		

		
		if(existing == null) {
			vc = newAndroid.validate();
		} else {
			vc = newAndroid.validate(existing);
		}
		
		//TODO: ersetze das if^^
		if(vc.toString().equals("gueltig")) {
			map.put(serialNum, newAndroid);
		}
		
		return vc;
		
		// TODO: ... alle Teile werden mit der Seriennummer des Andoiden codiert um
		// unauthorisierte Manipulationen zu unterbinden. Entsprechend der
		// Androide-Verordnung sind genaue Aufzeichnungen über die
		// Anfangskonfiguration und alle Änderungen zu führen.
	}
}
