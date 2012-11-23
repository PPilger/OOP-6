
public abstract class Skin implements AndroidVisitor, Encoded {
	
	private int serialNum;
	
	public Skin(int serialNum) {
		this.serialNum = serialNum;
	}
	
	public int getSerialNum() {
		return this.serialNum;
	}
	
	@Override
	public ValidationCode validSerialNum(SerialNumber num) {
		return num.validate(this.serialNum);
	}
	
}