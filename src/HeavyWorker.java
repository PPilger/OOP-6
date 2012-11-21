
public abstract class HeavyWorker extends Android {
	
	public HeavyWorker(int serialNum) {
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
	public ValidationCode validMainType(Guardian other) {
		return new Error("Falscher Haupttyp");
	}
	
	@Override
	public ValidationCode validSkin(ArmoredSkin skin) {
		return new Error("Schwerarbeiter kann keinen gepanzerten Skin haben.");
	}
}
