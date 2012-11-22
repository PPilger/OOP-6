/**
 * 
 * @author Christian Kletzander
 *
 */
public class TransportWorker extends HeavyWorker {

	public TransportWorker(int serialNum) {
		super(serialNum);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public ValidationCode validSoftware(TransportWorker.BaseSoftware s) {
		return new Valid();
	}
	
	public static class BaseSoftware implements Software {

		@Override
		public ValidationCode validateAndroid(Android android) {
			return android.validSoftware(this);
		}
		
	}

}
