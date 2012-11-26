/**
 * Repraesentiert einen gueltigen ValidationCode (das validierte Objekt ist
 * valide).
 * 
 * @author Peter Pilgerstorfer
 */
public class Valid implements ValidationCode {

	/**
	 * Liefert Valid wenn other gueltig ist und Error anderenfalls.
	 */
	@Override
	public ValidationCode merge(ValidationCode other) {
		// visit merge(Valid) of the other validationCode
		return other.merge(this);
	}

	/**
	 * Liefert einen Error.
	 */
	@Override
	public ValidationCode merge(Error other) {
		return other;
	}

	/**
	 * Liefert ein Valid Objekt.
	 */
	@Override
	public ValidationCode merge(Valid other) {
		return this;
	}

	/**
	 * Fuehrt die Operation op aus.
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
