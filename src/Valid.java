
public class Valid implements ValidationCode {

	@Override
	public <P> ValidationCode validate(P obj, Visitor<P> visitor) {
		return visitor.visit(obj);
	}

	@Override
	public String toString() {
		return "gueltig";
	}

	@Override
	public ValidationCode merge(ValidationCode other) {
		return this;
	}
}
