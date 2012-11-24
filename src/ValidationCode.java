public interface ValidationCode {
	public ValidationCode mergeOr(ValidationCode other);

	public ValidationCode mergeOr(Error other);

	public ValidationCode mergeOr(Valid other);

	public ValidationCode mergeAnd(ValidationCode other);

	public ValidationCode mergeAnd(Error other);

	public ValidationCode mergeAnd(Valid other);

	public ValidationCode executeIfValid(Operation op);

	public String toString();

	public static interface Operation {
		public void execute();
	}
}
