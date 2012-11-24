public abstract class Software extends Encoded implements AndroidVisitor {
	private SecurityLevel level;

	public Software(int serialNum, SecurityLevel level) {
		super(serialNum);
		this.level = level;
	}

	public SecurityLevel getLevel() {
		return level;
	}

	public abstract ValidationCode visit(Android android);
}
