
public interface SecurityLevelVisitor extends Visitor<Android> {
	public ValidationCode visit(SecurityLevel level);
}
