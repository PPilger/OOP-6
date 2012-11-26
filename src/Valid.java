/**
 * Invariant: The content of Valid cannot be changed.
 * 
 * @author Peter Pilgerstorfer
 */
public class Valid implements ValidationCode {

	/**
	 * Returns Valid if other is Valid and Error otherwise.
	 */
	@Override
	public ValidationCode merge(ValidationCode other) {
		// visit merge(Valid) of the other validationCode
		return other.merge(this);
	}

	/**
	 * Returns an Error
	 */
	@Override
	public ValidationCode merge(Error other) {
		return other;
	}

	/**
	 * Returns Valid
	 */
	@Override
	public ValidationCode merge(Valid other) {
		return this;
	}

	/**
	 * Executes the Operation op.
	 */
	@Override
	public void executeIfValid(Operation op) {
		op.execute(); // this is Valid => execute
	}

	@Override
	public String toString() {
		return "[Valid]";
	}
}
