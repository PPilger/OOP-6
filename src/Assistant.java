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
	
	@Override
	public ValidationCode validSecLevel(SecurityLevel2 s) {
		// TODO Auto-generated method stub
		return new Error("Invalid Security Level");
	}
}
