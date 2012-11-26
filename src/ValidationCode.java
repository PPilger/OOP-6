/**
 * Represents a validation-result.
 * 
 * Invariant: The content of a ValidationCode cannot be changed.
 * 
 * @author Peter Pilgerstorfer
 */
public interface ValidationCode {
	// Use the Visitor-Pattern to split merge(ValidationCode) into merge(Error)
	// and merge(Valid).

	/**
	 * Returns Valid if both ValidationCodes are Valid, and Error otherwise.
	 */
	public ValidationCode merge(ValidationCode other);

	/**
	 * Returns an Error
	 */
	public ValidationCode merge(Error other);

	/**
	 * Returns Valid if this is Valid and Error otherwise.
	 */
	public ValidationCode merge(Valid other);

	/**
	 * Executes the Operation op, if this is Valid.
	 */
	public void executeIfValid(Operation op);

	/**
	 * Represents an Operation that can be executed.
	 * 
	 * @author Peter Pilgerstorfer
	 */
	public static interface Operation {
		public void execute();
	}
}
