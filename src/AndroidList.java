import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;


public class AndroidList {
	private LinkedHashMap<Integer, AndroidLog> map = new LinkedHashMap<Integer, AndroidLog>();
	
	private Android foundedAndroid = null;
	
	public ValidationCode insert(Android newAndroid) {
		int serialNum = newAndroid.getSerialNum();
		AndroidLog existing = map.get(serialNum);
		ValidationCode vc;
		
		//is the given Android currently in the map?
		if(existing == null) {
			//No add new log
			existing = new AndroidLog();
			vc = existing.addIfValid(newAndroid);
			map.put(serialNum, existing);
		} else {
			//add new Android's configuration to the log 
			vc = existing.addIfValid(newAndroid);
		}
		
		/*if(existing == null) {
			vc = newAndroid.validate();
		} else {
			vc = newAndroid.validate(existing);
		}
		
		//TODO: ersetze das if^^
		if(vc.toString().equals("gueltig")) {
			map.put(serialNum, newAndroid);
		}*/
		
		return vc;
		
		// TODO: ... alle Teile werden mit der Seriennummer des Andoiden codiert um
		// unauthorisierte Manipulationen zu unterbinden. Entsprechend der
		// Androide-Verordnung sind genaue Aufzeichnungen über die
		// Anfangskonfiguration und alle Änderungen zu führen.
	}
	
	public String find(int serialNum)
	{
		AndroidLog existing = map.get(serialNum);
		if(existing == null)
		{
			return null;
		}
		this.foundedAndroid = existing.getLast();
		StringBuilder sb = new StringBuilder();
		sb.append("Serial Number of Android: ");
		sb.append(this.foundedAndroid.getSerialNum());
		sb.append("\nKit: ");
		sb.append(this.foundedAndroid.getKit().toString());
		sb.append("\nSkin: ");
		sb.append(this.foundedAndroid.getSkin().toString());
		sb.append("\nSoftware: ");
		sb.append(this.foundedAndroid.getSoftware().toString());
		return sb.toString();
	}
	
	public Iterator<Android> iterator()
	{
		if (foundedAndroid == null)
		{
			return null;
		}
		return map.get(foundedAndroid.getSerialNum()).iterator();
	}
	
}
