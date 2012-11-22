/**
 * 
 * @author Koegler Alexander
 *
 */
public class Partner extends Servant
{
	public class BaseSoftware implements Software
	{
		@Override
		public ValidationCode validateAndroid(Android android) {
			return android.validSoftware(this);
		}
	}
	
	public Partner(int serialNum) {
		super(serialNum);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public ValidationCode validSoftware(Partner.BaseSoftware s) {
		// TODO Auto-generated method stub
		return new Valid();
	}
}
