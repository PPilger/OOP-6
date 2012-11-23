/**
 * 
 * @author Christian Kletzander
 *
 */
public class TransportWorker extends HeavyWorker {

	public TransportWorker(int serialNum) {
		super(serialNum);
	}
	
	@Override
	public ValidationCode validSoftware(TransportWorker.BaseSoftware s) {
		return new Valid();
	}

	public static class BaseSoftware extends Software {

		public BaseSoftware(SecurityLevel level, int serialNum) {
			super(level, serialNum);
		}
		
		@Override
		public ValidationCode visit(Android android) {
			return android.validSoftware(this);
		}
		
	}

}
