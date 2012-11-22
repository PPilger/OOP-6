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
			return android.validSoftware(this);
		}
		
	}
	
	@Override
	public ValidationCode validSoftware(Assistant.BaseSoftware s) {
		// TODO Auto-generated method stub
		return new Valid();
	}
}
