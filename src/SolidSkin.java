
public class SolidSkin implements Skin {

	@Override
	public ValidationCode visit(Android android) {
		return android.validSkin(this);
	}
}
