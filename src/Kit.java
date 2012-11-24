import java.util.ArrayList;

public class Kit extends Encoded {

	private ArrayList<Aktor> aktorList;
	private ArrayList<Sensor> sensorList;

	public Kit(int serialNum, ArrayList<Aktor> aktorList,
			ArrayList<Sensor> sensorList) {
		super(serialNum);
		this.aktorList = aktorList;
		this.sensorList = sensorList;
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
			code = code.mergeAnd(code2);
		}

		// Sensoren pruefen
		for (Sensor s : sensorList) {
			ValidationCode code2 = s.validSerialNum(num);
			code = code.mergeAnd(code2);
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
