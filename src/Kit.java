import java.util.ArrayList;

public class Kit extends Encoded {

	private ArrayList<Aktor> aktorList;
	private ArrayList<Sensor> sensorList;

	public Kit(int serialNum, ArrayList<Aktor> aktorList,
			ArrayList<Sensor> sensorList) {
		super(serialNum);
		
		//new Objects are created and references of parameters are copied
		//in order to prevent changes within these lists
		this.aktorList = new ArrayList<Aktor>(aktorList);
		this.sensorList = new ArrayList<Sensor>(sensorList);
	}

	public PowerClass getPowerClass() {
		double summe = 0;

		for (Aktor temp : this.aktorList) {
			summe += temp.getkW();
		}

		return PowerClass.getPowerClass(summe);
	}

	@Override
	public ValidationCode validSerialNum(SerialNumber num) {

		ValidationCode code;

		// Kit pruefen
		code = super.validSerialNum(num);

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
