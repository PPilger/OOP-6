
public class SecurityLevel2 extends SecurityLevel{

	@Override
	public ValidationCode visit(Android android) {
		ValidationCode code = android.validSecLevel(this);
		return code = code.mergeAnd(android.getSoftware().getLevel().validSecLevel(this));
	}

	@Override
	public String toString() {
		return "Level 2";
	}
	
	@Override
	public ValidationCode validSecLevel(SecurityLevel2 level) {
		return new Valid();
	}
}
