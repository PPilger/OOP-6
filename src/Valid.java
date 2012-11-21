
public class Valid implements ValidationCode {

	@Override
	public ValidationCode validate(Android android, Validable validable) {
		return validable.validateReplacement(android);
	}

	@Override
	public String toString() {
		return "gueltig";
	}
}
