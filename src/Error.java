import java.util.HashSet;
import java.util.Set;


public class Error implements ValidationCode {
	private Set<String> messages = new HashSet<String>();
	
	public Error(String message) {
		messages.add(message);
	}
	
	@Override
	public ValidationCode merge(ValidationCode other) {
		return other.merge(this); // visit merge(Error) of the other validationCode
	}
	
	@Override
	public ValidationCode merge(Error other) {
		messages.addAll(other.messages);
		return this;
	}
	
	@Override
	public ValidationCode merge(Valid other) {
		return this;
	}
	
	@Override
	public String toString() {
		return messages.toString();
	}

	@Override
	public ValidationCode executeIfValid(Operation op) {
		return this;
	}

}