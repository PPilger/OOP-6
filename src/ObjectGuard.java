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

	public static class BaseSoftware extends Software {

		public BaseSoftware(SecurityLevel level, int serialNum) {
			super(level, serialNum);
		}
		
		@Override
		public ValidationCode visit(Android android) {
			return android.validSoftware(this);
		}
		
	}

}
