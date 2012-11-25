/**
 * 
 * @author Christian Kletzander
 * 
 */
public class ObjectGuard extends Guard {

	public ObjectGuard(int serialNum, Kit kit, Skin skin, Software software) {
		super(serialNum, kit, skin, software);
	}

	@Override
	public ValidationCode validSoftware(ObjectGuard.BaseSoftware s) {
		return new Valid();
	}

	@Override
	public String getType() {
		return "Objektbewacher";
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
			return "Objektbewacher Software " + super.getLevel();
		}

	}

}
