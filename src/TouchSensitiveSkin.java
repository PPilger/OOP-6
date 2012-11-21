
public class TouchSensitiveSkin implements Skin {

	@Override
	public ValidationCode validateAndroid(Android android) {
		return android.validSkin(this);
	}
}
