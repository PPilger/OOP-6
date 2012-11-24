public class ArmoredSkin extends Skin {

	public ArmoredSkin(int serialNum) {
		super(serialNum);
	}

	@Override
	public ValidationCode visit(Android android) {
		return android.validSkin(this);
	}

	@Override
	public String toString() {
		return "gepanzerter Skin";
	}
}
