public class Valid implements ValidationCode {

	@Override
	public ValidationCode visit(Android obj, AndroidVisitor visitor) {
		return visitor.visit(obj);
	}

	@Override
	public ValidationCode visit(SecurityLevel obj,
			SecurityLevelVisitor visitor) {
		return visitor.visit(obj);
	}

	@Override
	public String toString() {
		return "gueltig";
	}

	@Override
	public ValidationCode merge(ValidationCode other) {
		return this;
	}
}
