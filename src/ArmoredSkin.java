
public class ArmoredSkin extends Skin {

	@Override
	public ErrorCode applyTo(Android android) {
		return android.setSkin(this);
	}
}
