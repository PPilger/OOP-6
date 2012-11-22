/**
 * 
 * @author Christian Kletzander
 *
 */
public class ObjectGuard extends Guard {

	public ObjectGuard(int serialNum) {
		super(serialNum);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public ValidationCode validSoftware(ObjectGuard.BaseSoftware s) {
		return new Valid();
	}
	
	public static class BaseSoftware implements Software {

		@Override
		public ValidationCode validateAndroid(Android android) {
			return android.validSoftware(this);
		}
		
	}

}
