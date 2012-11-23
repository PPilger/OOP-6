
public interface ValidationCode {
	public ValidationCode visit(Android obj, AndroidVisitor visitor);
	public ValidationCode visit(SecurityLevel obj, SecurityLevelVisitor visitor);
	public String toString();
	public ValidationCode merge(ValidationCode other);
}
