
public class Error implements ValidationCode {
	private String message;
	
	public Error(String message) {
		this.message = message;
	}

	@Override
	public ValidationCode visit(Android obj, AndroidVisitor visitor) {
		return this;
	}

	@Override
	public ValidationCode visit(SecurityLevel obj,
			SecurityLevelVisitor visitor) {
		return this;
	}
	
	@Override
	public ValidationCode mergeOr(ValidationCode other) {
		return other;
	}
	
	@Override
	public ValidationCode mergeAnd(ValidationCode other) {
		return this;
	}
	
	@Override
	public String toString() {
		return message;
	}

}
