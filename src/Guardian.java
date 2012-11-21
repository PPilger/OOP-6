
public abstract class Guardian extends Android {
	
	public Guardian(int serialNum) {
		super(serialNum);
	}

	@Override
	public ValidationCode validateAndroid(Android other) {
		return other.validMainType(this);
	}
	
	@Override
	public ValidationCode validMainType(Guardian other) {
		return new Valid();
	}
}
