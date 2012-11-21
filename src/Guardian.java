
public abstract class Guardian extends Android {
	
	public Guardian(int serialNum) {
		super(serialNum);
	}

	@Override
	public ValidationCode validateReplacement(Android other) {
		return other.validMainType(this);
	}

	@Override
	public ValidationCode validMainType(Servant other) {
		return new Error("Falscher Haupttyp");
	}

	@Override
	public ValidationCode validMainType(HeavyWorker other) {
		return new Error("Falscher Haupttyp");
	}
}
