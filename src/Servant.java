
public abstract class Servant extends Android {
	
	@Override
	public ErrorCode setSkin(SolidSkin skin) {
		return new ErrorCode("Bediener kann keinen hochfesten Skin haben.");
	}
	
	@Override
	public ErrorCode setSkin(ArmoredSkin skin) {
		return new ErrorCode("Bediener kann keinen gepanzerten Skin haben.");
	}
}
