
public class SecurityLevel2 extends SecurityLevel{

	@Override
	public ValidationCode visit(Android android) {
		ValidationCode code = android.validSecLevel(this);
		return code = code.mergeAnd(android.getSoftware().getLevel().validSecLevel(this));
	}

	@Override
	public ValidationCode visit(SecurityLevel level) {
		return level.validSecurityLevel(this);
	}
	
	@Override
	public ValidationCode validSecurityLevel(SecurityLevel2 level) {
		return new Valid();
	}

	@Override
	public String toString() {
		return "Level 2";
	}
}
