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
	
	@Override
	public ValidationCode validSoftware(ServiceTechnician.BaseSoftware s) {
		return new Valid();
	}
	
	public static class BaseSoftware implements Software {

		@Override
		public ValidationCode validateAndroid(Android android) {
			return android.validSoftware(this);
		}
		
	}

}
