public class Valid implements ValidationCode {
	
	@Override
	public String toString() {
		return "gueltig";
	}

	@Override
	public ValidationCode mergeOr(ValidationCode other) {
		return other.mergeOr(this); // visit mergeOr(Valid) of the other validationCode
	}
	
	@Override
	public ValidationCode mergeOr(Error other) {
		return this;
	}
	
	@Override
	public ValidationCode mergeOr(Valid other) {
		return this;
	}
	
	@Override
	public ValidationCode mergeAnd(ValidationCode other) {
		return other.mergeAnd(this); // visit mergeAnd(Valid) of the other validationCode
	}
	
	@Override
	public ValidationCode mergeAnd(Error other) {
		return other;
	}
	
	@Override
	public ValidationCode mergeAnd(Valid other) {
		return this;
	}

	@Override
	public ValidationCode executeIfValid(Operation op) {
		op.execute();
		return this;
	}
}
