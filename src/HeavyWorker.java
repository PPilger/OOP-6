
public abstract class HeavyWorker extends Android {
	
	public HeavyWorker(int serialNum) {
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
	public ValidationCode validAttribute(Guardian other) {
		return new Error("nicht vom Typ Beschuetzer");
	}
	
	@Override
	public ValidationCode validAttribute(ArmoredSkin skin) {
		return new Error("Schwerarbeiter kann keinen gepanzerten Skin haben.");
	}
}
