
public class TouchSensitiveSkin extends Skin {

	public TouchSensitiveSkin(int serialNum) {
		super(serialNum);
	}

	@Override
	public ValidationCode visit(Android android) {
		return android.validSkin(this);
	}
}
