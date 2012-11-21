
public abstract class Servant extends Android {
	
	public Servant(int serialNum) {
		super(serialNum);
	}

	@Override
	public ValidationCode validateAndroid(Android other) {
		return other.validAttribute(this);
	}
	
	@Override
	public ValidationCode validAttribute(HeavyWorker other) {
		return new Error("nicht vom Typ Schwerarbeiter");
	}

	@Override
	public ValidationCode validAttribute(Guardian other) {
		return new Error("nicht vom Typ Beschuetzer");
	}
	
	@Override
	public ValidationCode validAttribute(SolidSkin skin) {
		return new Error("Bediener kann keinen hochfesten Skin haben.");
	}
	
	@Override
	public ValidationCode validAttribute(ArmoredSkin skin) {
		return new Error("Bediener kann keinen gepanzerten Skin haben.");
	}
}
