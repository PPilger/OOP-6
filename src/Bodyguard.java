/**
 * 
 * @author Christian Kletzander
 *
 */
public class Bodyguard extends Guard {

	public Bodyguard(int serialNum) {
		super(serialNum);
	}
	
	public static class BaseSoftware implements Software {

		@Override
		public ValidationCode validateAndroid(Android android) {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
}
