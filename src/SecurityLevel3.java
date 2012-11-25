
public class SecurityLevel3 extends SecurityLevel{

	@Override
	public ValidationCode visit(Android android) {
		return android.validSecLevel(this);
	}

	@Override
	public ValidationCode visit(SecurityLevel level) {
		return level.validSecurityLevel(this);
	}

	@Override
	public ValidationCode validSecurityLevel(SecurityLevel3 s) {
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
		return "Level 3";
	}
}
