
public interface ValidationCode {
	public <P> ValidationCode validate(P obj, Visitor<P> visitor);
	public String toString();
	public ValidationCode merge(ValidationCode other);
}
