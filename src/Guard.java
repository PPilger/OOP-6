
public abstract class Guard extends Android {
	
	public Guard(int serialNum) {
		super(serialNum);
	}

	@Override
	public ValidationCode validateAndroid(Android other) {
		return other.validMainType(this);
	}
	
	@Override
	public ValidationCode validMainType(Guard other) {
		return new Valid();
	}
	
	@Override
	public ValidationCode validSecLevel(SecurityLevel4 s) {
		return new Valid();
	}
	
	@Override
	public ValidationCode validSkin(ArmoredSkin skin) {
		return new Valid();
	}
}
