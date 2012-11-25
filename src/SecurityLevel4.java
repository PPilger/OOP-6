
public class SecurityLevel4 extends SecurityLevel{

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
	public ValidationCode validSecurityLevel(SecurityLevel4 s) {
		return new Valid();
	}
	
	@Override
	public ValidationCode validPowerClass(PowerClass.LE10 s) {
		return new Valid();
	}
	
	@Override
	public ValidationCode validPowerClass(PowerClass.LE5 s) {
		return new Valid();
	}
	
	@Override
	public ValidationCode validPowerClass(PowerClass.LE1 s) {
		return new Valid();
	}
	
	@Override
	public String toString() {
		return "Level 4";
	}
}
