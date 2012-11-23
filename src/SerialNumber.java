import java.util.HashMap;

public class SerialNumber {

	private HashMap<Integer, ValidationCode> map;
	
	public SerialNumber() {
		this.map = new HashMap<Integer, ValidationCode>();
	}
	
	public ValidationCode validate(int serialNum) {
		
		ValidationCode code = this.map.get(serialNum);
		
		if(code == null) {
			return new Error("not a valid Serial Number");
		}
		
		return code;
	}
	
}
