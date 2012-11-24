/**
 * 
 * @author Koegler Alexander
 * 
 */
public class Partner extends Servant {
	public Partner(int serialNum, Kit kit, Skin skin, Software software) {
		super(serialNum, kit, skin, software);
	}

	@Override
	public ValidationCode validSoftware(Partner.BaseSoftware s) {
		return new Valid();
	}

	public static class BaseSoftware extends Software {

		public BaseSoftware(int serialNum, SecurityLevel level) {
			super(serialNum, level);
		}

		@Override
		public ValidationCode visit(Android android) {
			return android.validSoftware(this);
		}
	}
}
