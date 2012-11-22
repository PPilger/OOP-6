import java.util.ArrayList;

public class Kit {
	
	private ArrayList<Aktor> aktorList;
	private ArrayList<Sensor> sensorList;
	
	public Kit() {
		this.aktorList = new ArrayList<Aktor>();
		this.sensorList = new ArrayList<Sensor>();
	}
	
	public PowerClass getPowerClass() {
		double summe = 0;
		
		for(Aktor temp : this.aktorList) {
			summe += temp.getkW();
		}
		
		return PowerClass.getPowerClass(summe);
	}
	
	public void addAktor(Aktor temp) {
		this.aktorList.add(temp);
	}
	
	public void addSensor(Sensor temp) {
		this.sensorList.add(temp);
	}
	
}
