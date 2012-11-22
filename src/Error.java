
public class Error implements ValidationCode {
	private String message;
	
	public Error(String message) {
		this.message = message;
	}

	@Override
	public ValidationCode validate(Android android, AndroidVisitor validable) {
		return this;
	}
	
	@Override
	public String toString() {
		return message;
	}
}
