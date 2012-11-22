
public abstract class Software implements AndroidVisitor {
	private SecurityLevel level;
	
	public Software(SecurityLevel level) {
		this.level = level;
	}

	public SecurityLevel getLevel() {
		return level;
	}
	
	public abstract ValidationCode visit(Android android);
}
