
public abstract class Encoded {
	private int serialNum;
	
	public Encoded(int serialNum) {
		this.serialNum = serialNum;
	}
	
	public ValidationCode validSerialNum(SerialNumber num) {
		return num.validate(serialNum);
	}
}
