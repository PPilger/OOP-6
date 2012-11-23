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

		public BaseSoftware(SecurityLevel level, int serialNum) {
			super(level, serialNum);
		}

		@Override
		public ValidationCode visit(Android android) {
			return android.validSoftware(this);
		}
		
	}
	
	@Override
	public ValidationCode validSoftware(Assistant.BaseSoftware s) {
		return new Valid();
	}
	
	@Override
	public ValidationCode validSecLevel(SecurityLevel2 s) {
		return new Error("Invalid Security Level");
	}
}
