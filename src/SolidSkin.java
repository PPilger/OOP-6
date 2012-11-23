
public class SolidSkin extends Skin {

	public SolidSkin(int serialNum) {
		super(serialNum);
	}

	@Override
	public ValidationCode visit(Android android) {
		return android.validSkin(this);
	}
}
