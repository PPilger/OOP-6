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
	
	public static class BaseSoftware implements Software {

		@Override
		public ValidationCode validateAndroid(Android android) {
			// TODO Auto-generated method stub
			return null;
		}
		
	}

}
