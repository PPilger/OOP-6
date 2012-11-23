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
	public ValidationCode mergeOr(ValidationCode other) {
		return this;
	}
	
	@Override
	public ValidationCode mergeAnd(ValidationCode other) {
		return other;
	}
}
