
public class TouchSensitiveSkin implements Skin {

	@Override
	public ValidationCode validateReplacement(Android android) {
		return android.validSkin(this);
	}
}
