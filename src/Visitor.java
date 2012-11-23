
public interface Visitor<P> {
	public ValidationCode visit(P obj);
}
