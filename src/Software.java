
public abstract class Software implements Validable {
	private SecurityLevel level;
	
	public Software(SecurityLevel level) {
		this.level = level;
	}

	public SecurityLevel getLevel() {
		return level;
	}
	
	public abstract ValidationCode validateAndroid(Android android);
}
