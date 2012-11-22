
public abstract class HeavyWorker extends Android {
	
	public HeavyWorker(int serialNum) {
		super(serialNum);
	}

	@Override
	public ValidationCode validateAndroid(Android other) {
		return other.validMainType(this);
	}
	
	@Override
	public ValidationCode validMainType(HeavyWorker other) {
		return new Valid();
	}
	
	@Override
	public ValidationCode validSkin(ArmoredSkin skin) {
		return new Error("Schwerarbeiter kann keinen gepanzerten Skin haben.");
	}
	
	@Override
	public ValidationCode validSecLevel(SecurityLevel3 s) {
		return new Valid();
	}
	
	@Override
	public ValidationCode validSecLevel(SecurityLevel4 s) {
		return new Valid();
	}
}
