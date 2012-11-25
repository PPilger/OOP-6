/**
 * 
 * @author Christian Kletzander
 * 
 */
public class Fighter extends Guard {

	public Fighter(int serialNum, Kit kit, Skin skin, Software software) {
		super(serialNum, kit, skin, software);
	}

	@Override
	public ValidationCode validSoftware(Fighter.BaseSoftware s) {
		return new Valid();
	}

	@Override
	public ValidationCode validSecLevel(SecurityLevel4 s) {
		return new Error("Invalid Security Level");
	}

	@Override
	public ValidationCode validSecLevel(SecurityLevel5 s) {
		return new Valid();
	}

	@Override
	public ValidationCode validPowerClass(PowerClass.Unlimited s) {
		return new Valid();
	}

	@Override
	public ValidationCode validPowerClass(PowerClass.LE10 s) {
		return new Valid();
	}

	@Override
	public ValidationCode validPowerClass(PowerClass.LE5 s) {
		return new Valid();
	}

	@Override
	public ValidationCode validPowerClass(PowerClass.LE1 s) {
		return new Valid();
	}

	@Override
	public String getType() {
		return "Kaempfer";
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
			return "Kaempfer Software " + super.getLevel();
		}
	}
}
