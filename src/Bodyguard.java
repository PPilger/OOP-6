/**
 * 
 * @author Christian Kletzander
 *
 */
public class Bodyguard extends Guard {

	public Bodyguard(int serialNum) {
		super(serialNum);
	}
	
	@Override
	public ValidationCode validSoftware(Bodyguard.BaseSoftware s) {
		return new Valid();
	}
	
	public static class BaseSoftware extends Software {

		public BaseSoftware(SecurityLevel level) {
			super(level);
		}

		@Override
		public ValidationCode visit(Android android) {
			return android.validSoftware(this);
		}
		
	}
}
