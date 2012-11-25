
public class SecurityLevel5 extends SecurityLevel{

	@Override
	public ValidationCode visit(Android android) {
		return android.validSecLevel(this);
	}

	@Override
	public String toString() {
		return "Level 5";
	}
	
	@Override
	public ValidationCode validSecLevel(SecurityLevel5 level) {
		return new Valid();
	}
}
