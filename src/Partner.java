/**
 * 
 * @author Koegler Alexander
 *
 */
public class Partner extends Servant
{
	public Partner(int serialNum) {
		super(serialNum);
	}
	
	@Override
	public ValidationCode validSoftware(Partner.BaseSoftware s) {
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
