/**
 * 
 * @author Christian Kletzander
 *
 */
public class ServiceTechnician extends HeavyWorker {

	public ServiceTechnician(int serialNum) {
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
