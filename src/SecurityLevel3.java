
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
	public ValidationCode validPowerClass(PowerClass.Unlimited s) {
		return new Error("Invalid Power Class");
	}
	
	@Override
	public ValidationCode validPowerClass(PowerClass.LE10 s) {
		return new Error("Invalid Power Class");
	}

	@Override
	public String toString() {
		return "Level 3";
	}
}
