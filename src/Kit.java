import java.util.ArrayList;

public class Kit implements Encoded {
	
	private int serialNum;
	private ArrayList<Aktor> aktorList;
	private ArrayList<Sensor> sensorList;
	
	public Kit(int serialNum, ArrayList<Aktor> aktorList, ArrayList<Sensor> sensorList) {
		this.serialNum = serialNum;
		this.aktorList = aktorList;
		this.sensorList = sensorList;
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

	@Override
	public ValidationCode validSerialNum(SerialNumber num) {
		ValidationCode code = new Valid();
		
		for(Aktor a : aktorList) {
			code = code.merge(a.validSerialNum(num));
		}
		
		for(Sensor s : sensorList) {
			code = code.merge(s.validSerialNum(num));
		}
		
		return num.validate(this.serialNum);
	}
		
}
