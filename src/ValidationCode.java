/**
 * Repraesentiert ein Validierungsergebnis.
 * 
 * @author Peter Pilgerstorfer
 */
public interface ValidationCode {
	// verwendet das Visitor-Pattern um merge(ValidationCode) auf merge(Error)
	// und merge(Valid) aufzuteilen.

	/**
	 * Liefert Valid wenn beide gueltig sind und Error anderenfalls.
	 */
	public ValidationCode merge(ValidationCode other);

	/**
	 * Liefert einen Error.
	 */
	public ValidationCode merge(Error other);

	/**
	 * Liefert Valid wenn beide gueltig sind und Error anderenfalls.
	 */
	public ValidationCode merge(Valid other);

	/**
	 * Fuehrt die Operation op aus, wenn this gueltig ist.
	 */
	public void executeIfValid(Operation op);

	/**
	 * Stellt eine vom ValidationCode ausfuehrbare Operation dar.
	 * 
	 * @author Peter Pilgerstorfer
	 */
	public static interface Operation {
		public void execute();
	}
}
