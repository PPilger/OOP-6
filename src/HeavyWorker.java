
public abstract class HeavyWorker extends Android {
	
	@Override
	public ErrorCode setSkin(ArmoredSkin skin) {
		return new ErrorCode("Schwerarbeiter kann keinen gepanzerten Skin haben.");
	}
}
