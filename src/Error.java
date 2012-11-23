
public class Error implements ValidationCode {
	private String message;
	
	@Override
	public Object getNull() {
		return null;
	}
	
	public Error(String message) {
		this.message = message;
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
