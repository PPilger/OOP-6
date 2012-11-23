
public interface ValidationCode {
	public String toString();
	public ValidationCode mergeOr(ValidationCode other);
	public ValidationCode mergeAnd(ValidationCode other);
}
