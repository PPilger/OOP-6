
public class Error implements ValidationCode {
	private String message;
	
	public Error(String message) {
		this.message = message;
	}

	@Override
	public <P> ValidationCode validate(P obj, Visitor<P> visitor) {
		return this;
	}
	
	@Override
	public String toString() {
		return message;
	}

	@Override
	public ValidationCode merge(ValidationCode other) {
		return other;
	}
}
