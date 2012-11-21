
public abstract class Guardian extends Android {
	
	public Guardian(int serialNum) {
		super(serialNum);
	}

	@Override
	public ValidationCode validateAndroid(Android other) {
		return other.validAttribute(this);
	}

	@Override
	public ValidationCode validAttribute(Servant other) {
		return new Error("nicht vom Typ Bediener");
	}

	@Override
	public ValidationCode validAttribute(HeavyWorker other) {
		return new Error("nicht vom Typ Schwerarbeiter");
	}
}
