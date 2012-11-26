
public class SecurityLevel4 extends SecurityLevel{

	@Override
	public ValidationCode visit(Android android) {
		return android.validSecLevel(this);
	}

	@Override
	public ValidationCode visit(SecurityLevel level) {
		return level.validSecLevel(this);
	}

	@Override
	public ValidationCode validSecLevel(SecurityLevel4 s) {
		return new Valid();
	}
	
	@Override
	public ValidationCode validPowerClass(PowerClass.Unlimited s) {
		return new Error("Invalid Power Class");
	}
	
	@Override
	public String toString() {
		return "Level 4";
	}
}
