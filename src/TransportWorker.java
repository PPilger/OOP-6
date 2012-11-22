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
	
	public static class BaseSoftware implements Software {

		@Override
		public ValidationCode validateAndroid(Android android) {
			// TODO Auto-generated method stub
			return null;
		}
		
	}

}
