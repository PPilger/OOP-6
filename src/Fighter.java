/**
 * 
 * @author Christian Kletzander
 *
 */
public class Fighter extends Guard {

	public Fighter(int serialNum) {
		super(serialNum);
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

	public static class BaseSoftware extends Software {

		public BaseSoftware(SecurityLevel level) {
			super(level);
		}

		@Override
		public ValidationCode validateAndroid(Android android) {
			return android.validSoftware(this);
		}
		
		
	}
	
}
