/**
 * 
 * @author Christian Kletzander
 *
 */
public class BuildingWorker extends HeavyWorker {

	public BuildingWorker(int serialNum) {
		super(serialNum);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public ValidationCode validSoftware(BuildingWorker.BaseSoftware s) {
		return new Valid();
	}
	
	public static class BaseSoftware implements Software {

		@Override
		public ValidationCode validateAndroid(Android android) {
			return android.validSoftware(this);
		}
		
	}

}
