
public abstract class Skin implements AndroidVisitor, Encoded {
	
	private int serialNum;
	
	public Skin(int serialNum) {
		this.serialNum = serialNum;
	}
	
	@Override
	public ValidationCode validSerialNum(SerialNumber num) {
		return num.validate(this.serialNum);
	}
	
}