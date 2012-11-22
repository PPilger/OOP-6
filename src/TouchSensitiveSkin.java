
public class TouchSensitiveSkin implements Skin {

	@Override
	public ValidationCode visit(Android android) {
		return android.validSkin(this);
	}
}
