import java.util.HashSet;
import java.util.Set;


public class Error implements ValidationCode {
	private Set<String> messages = new HashSet<String>();
	
	public Error(String message) {
		messages.add(message);
	}
	
	@Override
	public ValidationCode mergeOr(ValidationCode other) {
		return other.mergeOr(this); // visit mergeOr(Error) of the other validationCode
	}
	
	@Override
	public ValidationCode mergeOr(Error other) {
		messages.addAll(other.messages);
		return this;
	}
	
	@Override
	public ValidationCode mergeOr(Valid other) {
		return other;
	}
	
	@Override
	public ValidationCode mergeAnd(ValidationCode other) {
		return other.mergeAnd(this); // visit mergeAnd(Error) of the other validationCode
	}
	
	@Override
	public ValidationCode mergeAnd(Error other) {
		messages.addAll(other.messages);
		return this;
	}
	
	@Override
	public ValidationCode mergeAnd(Valid other) {
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