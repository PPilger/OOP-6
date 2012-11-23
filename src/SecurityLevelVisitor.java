
public interface SecurityLevelVisitor extends Visitor<SecurityLevel> {
	public ValidationCode visit(SecurityLevel level);
}
