import java.util.HashSet;
import java.util.Set;

/**
 * Invariant: The content of an Error cannot be changed.
 * 
 * @author Peter Pilgerstorfer
 */
public class Error implements ValidationCode {
	// Contains error messages
	private Set<String> messages = new HashSet<String>();

	/**
	 * Creates an Error with an error message.
	 */
	public Error(String message) {
		messages.add(message);
	}

	/**
	 * Copy constructor
	 */
	public Error(Error error) {
		messages.addAll(error.messages);
	}

	/**
	 * Returns an Error. If other is an Error too, the returned Error contains
	 * both messages (of this and other)
	 */
	@Override
	public ValidationCode merge(ValidationCode other) {
		// visit merge(Error) of the other validationCode
		return other.merge(this);
	}

	/**
	 * Returns an Error containing the messages of both Error-Objects.
	 */
	@Override
	public ValidationCode merge(Error other) {
		Error result = new Error(this);
		result.messages.addAll(other.messages);

		return result;
	}

	/**
	 * Returns an Error
	 */
	@Override
	public ValidationCode merge(Valid other) {
		return this;
	}

	/**
	 * Doesn't execute the Operation
	 */
	@Override
	public void executeIfValid(Operation op) {
		// this is not Valid => dont execute
	}

	/**
	 * Returns a String containing all error-messages.
	 */
	@Override
	public String toString() {
		return messages.toString();
	}

}