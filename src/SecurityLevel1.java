
public class SecurityLevel1 extends SecurityLevel{

	@Override
	public ValidationCode visit(Android android) {
		return android.validSecLevel(this);
	}

	@Override
	public String toString() {
		return "Level 1";
	}
	
	@Override
	public ValidationCode validSecLevel(SecurityLevel1 level) {
		return new Valid();
	}
}
