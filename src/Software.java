
public abstract class Software implements AndroidVisitor {
	private SecurityLevel level;
	private int serialNum;
	
	public Software(SecurityLevel level, int serialNum) {
		this.level = level;
		this.serialNum = serialNum;
	}

	public SecurityLevel getLevel() {
		return level;
	}
	
	public int getSerialNum() {
		return this.serialNum;
	}
	
	public abstract ValidationCode visit(Android android);
}
