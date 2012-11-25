
public abstract class Servant extends Android {
	
	public Servant(int serialNum, Kit kit, Skin skin, Software software) {
		super(serialNum, kit, skin, software);
	}

	@Override
	public ValidationCode visit(Android other) {
		return other.validMainType(this);
	}
	
	@Override
	public ValidationCode validMainType(Servant other) {
		return new Valid();
	}
	
	@Override
	public ValidationCode validSkin(SolidSkin skin) {
		return new Error("Invalid Skin");
	}
	
	@Override
	public ValidationCode validSkin(ArmoredSkin skin) {
		return new Error("Invalid Skin");
	}
	
	@Override
	public ValidationCode validSecLevel(SecurityLevel1 s) {
		return new Valid();
	}
	
	@Override
	public ValidationCode validSecLevel(SecurityLevel2 s) {
		return new Valid();
	}
	
	@Override
	public ValidationCode validSkin(TouchSensitiveSkin skin) {
		return new Valid();
	}
	
	@Override
	public ValidationCode validPowerClass(PowerClass.LE1 s) {
		return new Valid();
	}
}
