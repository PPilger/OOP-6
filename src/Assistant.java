/**
 * 
 * @author Koegler Alexander
 *
 */
public class Assistant extends Servant{

	public Assistant(int serialNum) {
		super(serialNum);
	}
	
	public class BaseSoftware extends Software
	{

		public BaseSoftware(SecurityLevel level) {
			super(level);
		}

		@Override
		public ValidationCode validateAndroid(Android android) {
			return android.validSoftware(this);
		}
		
	}
	
	@Override
	public ValidationCode validSoftware(Assistant.BaseSoftware s) {
		return new Valid();
	}
}
