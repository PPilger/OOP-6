
public interface ValidationCode {
	public Object getNull();
	public String toString();
	public ValidationCode mergeOr(ValidationCode other);
	public ValidationCode mergeAnd(ValidationCode other);
}
