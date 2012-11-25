/**
 * 
 * @author Christian Kletzander
 * 
 */
public class Bodyguard extends Guard {

	public Bodyguard(int serialNum, Kit kit, Skin skin, Software software) {
		super(serialNum, kit, skin, software);
	}

	@Override
	public ValidationCode validSoftware(Bodyguard.BaseSoftware s) {
		return new Valid();
	}

	@Override
	public String getType() {
		return "Leibwaechter";
	}

	public static class BaseSoftware extends Software {

		public BaseSoftware(int serialNum, SecurityLevel level) {
			super(serialNum, level);
		}

		@Override
		public ValidationCode visit(Android android) {
			return android.validSoftware(this);
		}

		@Override
		public String toString() {
			return "Leibwaechter Software " + super.getLevel();
		}
	}
}
