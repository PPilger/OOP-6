
public class ArmoredSkin implements Skin {

	@Override
	public ValidationCode visit(Android android) {
		return android.validSkin(this);
	}
}
