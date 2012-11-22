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
			// TODO Auto-generated method stub
			return null;
		}
	}
	
	public Partner(int serialNum) {
		super(serialNum);
		// TODO Auto-generated constructor stub
	}
}
