/**
 * 
 * @author Christian Kletzander
 * 
 */
public class ServiceTechnician extends HeavyWorker {

	public ServiceTechnician(int serialNum, Kit kit, Skin skin,
			Software software) {
		super(serialNum, kit, skin, software);
	}

	@Override
	public ValidationCode validSoftware(ServiceTechnician.BaseSoftware s) {
		return new Valid();
	}

	@Override
	public String getType() {
		return "Service Techniker";
	}

	public static class BaseSoftware extends Software {

		public BaseSoftware(int serialNum, SecurityLevel level) {
			super(serialNum, level);
		}

		@Override
		public ValidationCode visit(Android android) {
			return android.validSoftware(this);
		}
		
		@Override
		public String toString() {
			return "Service Techniker Software " + super.getLevel();
		}

	}

}
