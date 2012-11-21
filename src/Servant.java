
public abstract class Servant extends Android {
	
	public Servant(int serialNum) {
		super(serialNum);
	}

	@Override
	public ValidationCode validateReplacement(Android other) {
		return other.validMainType(this);
	}
	
	@Override
	public ValidationCode validMainType(HeavyWorker other) {
		return new Error("Falscher Haupttyp");
	}

	@Override
	public ValidationCode validMainType(Guardian other) {
		return new Error("Falscher Haupttyp");
	}
	
	@Override
	public ValidationCode validSkin(SolidSkin skin) {
		return new Error("Bediener kann keinen hochfesten Skin haben.");
	}
	
	@Override
	public ValidationCode validSkin(ArmoredSkin skin) {
		return new Error("Bediener kann keinen gepanzerten Skin haben.");
	}
}
