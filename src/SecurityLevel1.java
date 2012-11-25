
public class SecurityLevel1 extends SecurityLevel{

	@Override
	public ValidationCode visit(Android android) {
		return android.validSecLevel(this);
	}

	@Override
	public ValidationCode visit(SecurityLevel level) {
		return level.validSecurityLevel(this);
	}

	@Override
	public ValidationCode validSecurityLevel(SecurityLevel1 s) {
		return new Valid();
	}

	@Override
	public String toString() {
		return "Level 1";
	}
}
