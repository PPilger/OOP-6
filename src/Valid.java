public class Valid implements ValidationCode {

	@Override
	public Object getNull() {
		// TODO Auto-generated method stub
		return new Object();
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
