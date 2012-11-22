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

	public static class BaseSoftware implements Software {

		@Override
		public ValidationCode validateAndroid(Android android) {
			return android.validSoftware(this);
		}
		
	}
	
}
