import java.util.HashSet;
import java.util.Set;

/**
 * Repraesentiert einen gueltigen ValidationCode (das validierte Objekt ist
 * valide).
 * 
 * @author Peter Pilgerstorfer
 */
public class Error implements ValidationCode {
	// Contains error messages
	private Set<String> messages = new HashSet<String>();

	/**
	 * Erstellt einen Error mit der angegebenen Fehlermeldung.
	 */
	public Error(String message) {
		messages.add(message);
	}

	/**
	 * Kopierkonstruktor
	 */
	public Error(Error error) {
		messages.addAll(error.messages);
	}

	/**
	 * Liefert einen Error. Dieser enthaelt die Fehlermeldungen beider Errors
	 * (sofern other ein Error ist).
	 */
	@Override
	public ValidationCode merge(ValidationCode other) {
		// visit merge(Error) of the other validationCode
		return other.merge(this);
	}

	/**
	 * Liefert einen Error, der die Fehlermeldungen beider Errors enthaelt.
	 */
	@Override
	public ValidationCode merge(Error other) {
		Error result = new Error(this);
		result.messages.addAll(other.messages);

		return result;
	}

	/**
	 * Liefert einen Error
	 */
	@Override
	public ValidationCode merge(Valid other) {
		return this;
	}

	/**
	 * Fuehrt die Operation op nicht aus.
	 */
	@Override
	public void executeIfValid(Operation op) {
		// this is not Valid => dont execute
	}

	/**
	 * Liefert einen String der alle Fehlermeldungen enthaelt
	 */
	@Override
	public String toString() {
		return messages.toString();
	}

}