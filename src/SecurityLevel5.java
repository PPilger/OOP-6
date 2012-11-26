
public class SecurityLevel5 extends SecurityLevel{

	@Override
	public ValidationCode visit(Android android) {
		return android.validSecLevel(this);
	}

	@Override
	public ValidationCode visit(SecurityLevel level) {
		return level.validSecLevel(this);
	}

	@Override
	public ValidationCode validSecLevel(SecurityLevel5 s) {
		return new Valid();
	}

	@Override
	public String toString() {
		return "Level 5";
	}
}
