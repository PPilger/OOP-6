/**
 * 
 * @author Christian Kletzander
 *
 */
public class Fighter extends Guard {

	public Fighter(int serialNum) {
		super(serialNum);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public ValidationCode validSoftware(Fighter.BaseSoftware s) {
		return new Valid();
	}

	public static class BaseSoftware implements Software {

		@Override
		public ValidationCode validateAndroid(Android android) {
			return android.validSoftware(this);
		}
		
	}
	
}
