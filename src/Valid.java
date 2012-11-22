
public class Valid implements ValidationCode {

	@Override
	public ValidationCode validate(Android android, AndroidVisitor validable) {
		return validable.visit(android);
	}

	@Override
	public String toString() {
		return "gueltig";
	}
}
