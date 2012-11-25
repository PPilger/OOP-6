/**
 * 
 * @author Koegler Alexander
 * 
 */
public class Associate extends Servant {
	public Associate(int serialNum, Kit kit, Skin skin, Software software) {
		super(serialNum, kit, skin, software);
	}

	@Override
	public ValidationCode validSoftware(Associate.BaseSoftware s) {
		return new Valid();
	}

	@Override
	public String getType() {
		return "Gesellschafter";
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
			return "Gesellschafter Software " + super.getLevel();
		}
	}
}
