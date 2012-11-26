public class Valid implements ValidationCode {
	
	@Override
	public String toString() {
		return "[Valid]";
	}
	
	@Override
	public ValidationCode merge(ValidationCode other) {
		return other.merge(this); // visit merge(Valid) of the other validationCode
	}
	
	@Override
	public ValidationCode merge(Error other) {
		return other;
	}
	
	@Override
	public ValidationCode merge(Valid other) {
		return this;
	}

	@Override
	public ValidationCode executeIfValid(Operation op) {
		op.execute();
		return this;
	}
}
