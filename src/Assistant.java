/**
 * 
 * @author Koegler Alexander
 *
 */
public class Assistant extends Servant{

	public Assistant(int serialNum) {
		super(serialNum);
	}
	
	public class BaseSoftware implements Software
	{

		@Override
		public ValidationCode validateAndroid(Android android) {
			return null;
		}
		
	}
}
