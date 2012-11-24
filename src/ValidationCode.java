
public interface ValidationCode {
	public ValidationCode mergeOr(ValidationCode other);
	public ValidationCode mergeAnd(ValidationCode other);
	public ValidationCode executeIfValid(Operation op);
	public String toString();
	
	public static interface Operation {
		public void execute();
	}
}
