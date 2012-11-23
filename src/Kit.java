import java.util.ArrayList;

public class Kit implements Encoded {
	
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

	@Override
	public ValidationCode validSerialNum(SerialNumber num) {		
		
		ValidationCode code = new Valid();
		
		//Aktoren pruefen
		for(Aktor a : aktorList) {
		   ValidationCode code2 = a.validSerialNum(num);
		   code = code.mergeAnd(code2);
		}
		
		//Sensoren pruefen
		for(Sensor s : sensorList) {
			ValidationCode code2 = s.validSerialNum(num);
			code = code.mergeAnd(code2);
		}
		
		//Kit pruefen
		code = num.validate(serialNum).mergeAnd(code);
		
		return code;
	}
		
}
