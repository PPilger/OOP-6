
public abstract class Software implements AndroidVisitor, Encoded {
	private SecurityLevel level;
	private int serialNum;
	
	public Software(SecurityLevel level, int serialNum) {
		this.level = level;
		this.serialNum = serialNum;
	}

	public SecurityLevel getLevel() {
		return level;
	}

	@Override
	public ValidationCode validSerialNum(SerialNumber num) {
		return num.validate(this.serialNum);
	}
	
	public abstract ValidationCode visit(Android android);
}
