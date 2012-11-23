import java.util.ArrayList;

public class Kit {
	
	private int serialNum;
	private ArrayList<Aktor> aktorList;
	private ArrayList<Sensor> sensorList;
	
	public Kit(int serialNum) {
		this.serialNum = serialNum;
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
	
	public int getSerialNum() {
		return this.serialNum;
	}
		
}
