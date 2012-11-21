
public class Valid implements ValidationCode {

	@Override
	public ValidationCode validate(Android android, Validable validable) {
		return validable.validateAndroid(android);
	}

	@Override
	public String toString() {
		return "gueltig";
	}
}
