
public abstract class Servant extends Android {
	
	public Servant(int serialNum) {
		super(serialNum);
	}

	@Override
	public ValidationCode validateAndroid(Android other) {
		return other.validMainType(this);
	}
	
	@Override
	public ValidationCode validMainType(Servant other) {
		return new Valid();
	}
	
	@Override
	public ValidationCode validSkin(SolidSkin skin) {
		return new Error("Bediener kann keinen hochfesten Skin haben.");
	}
	
	@Override
	public ValidationCode validSkin(ArmoredSkin skin) {
		return new Error("Bediener kann keinen gepanzerten Skin haben.");
	}
	
	@Override
	public ValidationCode validSecLevel(SecurityLevel1 s) {
		// TODO Auto-generated method stub
		return new Valid();
	}
	
	@Override
	public ValidationCode validSecLevel(SecurityLevel2 s) {
		// TODO Auto-generated method stub
		return new Valid();
	}
}
