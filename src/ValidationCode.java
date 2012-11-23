
public interface ValidationCode {
	public ValidationCode visit(Android obj, AndroidVisitor visitor);
	public ValidationCode visit(SecurityLevel obj, SecurityLevelVisitor visitor);
	public String toString();
	public ValidationCode mergeOr(ValidationCode other);
	public ValidationCode mergeAnd(ValidationCode other);
}
