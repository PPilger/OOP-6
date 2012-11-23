public class Valid implements ValidationCode {

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
