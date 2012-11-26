
public abstract class HeavyWorker extends Android {
	
	public HeavyWorker(int serialNum, Kit kit, Skin skin, Software software) {
		super(serialNum, kit, skin, software);
	}

	@Override
	public ValidationCode visit(Android other) {
		return other.validMainType(this);
	}
	
	@Override
	public ValidationCode validMainType(HeavyWorker other) {
		return new Valid();
	}
		
	@Override
	public ValidationCode validSecLevel(SecurityLevel3 s) {
		return new Valid();
	}
	
	@Override
	public ValidationCode validSecLevel(SecurityLevel4 s) {
		return new Valid();
	}
	
	@Override
	public ValidationCode validSkin(SolidSkin skin) {
		return new Valid();
	}
	
	@Override
	public ValidationCode validSkin(TouchSensitiveSkin skin) {
		return new Valid();
	}
}
