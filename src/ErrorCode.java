
public class ErrorCode {
	private String error;
	
	public ErrorCode(String error) {
		this.error = error;
	}
	
	@Override
	public String toString() {
		return error;
	}
}
