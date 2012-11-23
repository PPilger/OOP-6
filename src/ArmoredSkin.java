
public class ArmoredSkin extends Skin {

	public ArmoredSkin(int serialNum) {
		super(serialNum);
	}

	@Override
	public ValidationCode visit(Android android) {
		return android.validSkin(this);
	}
}
