public interface ValidationCode {
	/**
	 * Returns Valid if both ValidationCodes are Valid, and Error otherwise.
	 */
	public ValidationCode merge(ValidationCode other);

	public ValidationCode merge(Error other);

	public ValidationCode merge(Valid other);

	public ValidationCode executeIfValid(Operation op);

	public String toString();

	public static interface Operation {
		public void execute();
	}
}
